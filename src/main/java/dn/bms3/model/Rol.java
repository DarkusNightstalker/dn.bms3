package dn.bms3.model;

import dn.core3.model.interfac.AuditoryEntity;
import dn.core3.model.interfac.EntityActivate;
import java.util.ArrayList;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "rol", catalog = "public")
@XmlRootElement
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Rol implements AuditoryEntity<Integer, User>, EntityActivate, GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @NonNull
    @NotBlank
    private String name;
    @JoinColumn(name = "create_uid")
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private User createUser;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    @PastOrPresent
    private Date createDate;
    @JoinColumn(name = "edit_uid")
    @ManyToOne(fetch = FetchType.LAZY)
    private User editUser;
    @Column(name = "edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    @PastOrPresent
    private Date editDate;
    @Column(name = "active")
    @NonNull
    private Boolean active = Boolean.TRUE;
    @ManyToMany
    @JoinTable(name = "rol_has_user", joinColumns = {
        @JoinColumn(name = "id_rol", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_user", nullable = false, updatable = false)})
    @NonNull
    private List<User> users = new ArrayList(0);

    @ManyToMany
    @JoinTable(name = "permission_has_rol", joinColumns = {
        @JoinColumn(name = "id_rol", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_permission", nullable = false, updatable = false)})
    @NonNull
    private List<Permission> permissions = new ArrayList(0);

    public Rol(Integer id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}
