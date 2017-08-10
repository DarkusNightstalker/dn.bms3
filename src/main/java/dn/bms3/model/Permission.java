package dn.bms3.model;

import dn.core3.model.interfac.EntityActivate;
import java.util.ArrayList;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "permission", catalog = "public")
@XmlRootElement
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Permission implements EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    @Size(max = 6)
    @NonNull
    private String code;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "limited")
    @NonNull
    private Boolean limited = Boolean.FALSE;

    @JoinColumn(name = "id_permission_category")
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private PermissionCategory permissionCategory;

    @Column(name = "active")    
    @NonNull
    private Boolean active = Boolean.TRUE;
    
    @ManyToMany
    @JoinTable(name = "permission_has_rol",
            joinColumns = {
                @JoinColumn(name = "id_permission", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "id_rol", nullable = false, updatable = false)
            })    
    @NonNull
    private List<Rol> rols = new ArrayList(0);

    public Permission(Integer id) {
        this.id = id;
    }

}
