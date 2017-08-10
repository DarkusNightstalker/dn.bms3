package dn.bms3.model;

import dn.core3.model.interfac.AuditoryEntity;
import dn.core3.model.interfac.EntityActivate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Darkus Nightmare
 */
@Entity
@Table(name = "user", catalog = "public")
@XmlRootElement
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class User implements AuditoryEntity<Integer, User>, EntityActivate,UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;
    
    @Column(name = "username")
    @Size(min=4, max=16)
    @NonNull
    protected String username;
    
    @Column(name = "password")
    @Size(min=4, max=16)
    @NonNull
    protected String password;
    
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    @PastOrPresent
    protected Date lastLogin;
    
    @Column(name = "is_superuser")
    @NonNull
    protected Boolean superUser = Boolean.FALSE;

    @JoinColumn(name = "id_employee")
    @ManyToOne
    protected Actor employee;

    @JoinColumn(name = "create_uid")
    @ManyToOne(fetch = FetchType.LAZY)
    protected User createUser;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;
    
    @JoinColumn(name = "edit_uid")
    @ManyToOne(fetch = FetchType.LAZY)
    protected User editUser;
    
    @Column(name = "edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date editDate;
    
    @Column(name = "active")
    @NonNull
    protected Boolean active = Boolean.TRUE;
    
    @ManyToMany
    @JoinTable(name = "rol_has_user", joinColumns = {
        @JoinColumn(name = "id_user", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol", nullable = false, updatable = false)})    
    @NonNull
    protected List<Rol> rols = new ArrayList(0);

    @ManyToMany
    @JoinTable(name = "dn_has_user", joinColumns = {
        @JoinColumn(name = "id_user", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_document_numbering", nullable = false, updatable = false)})
    @NonNull
    protected List<DocumentNumbering> documentNumberings = new ArrayList(0);

    @ManyToMany
    @JoinTable(name = "special_p_has_user", joinColumns = {
        @JoinColumn(name = "id_user", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_special_permission", nullable = false, updatable = false)})
    @NonNull
    protected List<SpecialPermission> specialPermissions = new ArrayList(0);

    public User(Integer id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return rols;
    }

    @Override
    public boolean isAccountNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
