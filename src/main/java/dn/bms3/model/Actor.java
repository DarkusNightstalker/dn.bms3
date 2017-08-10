package dn.bms3.model;

import dn.core3.model.interfac.AuditoryEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "actor", catalog = "public")
@XmlRootElement
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Actor implements Serializable, AuditoryEntity<Long, User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "identity_number")
    @NonNull
    @NotBlank
    @Digits(fraction = 0,integer = 20)
    private String identityNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "other")
    private String other;
    @Column(name = "representative")
    private String representative;
    @Column(name = "address")
    private String address;
    @Column(name = "points")
    @Min(0)
    @NonNull
    private Long points = 0L;  
    @Column(name = "synchronized")
    @NonNull
    private Boolean synchronized_ = Boolean.FALSE;
    @Column(name = "uploaded")
    @NonNull
    private Boolean uploaded = Boolean.TRUE;
    @Column(name = "customer")
    @NonNull
    private Boolean customer = Boolean.FALSE;
    @Column(name = "supplier")
    @NonNull
    private Boolean supplier = Boolean.FALSE;

    @JoinColumn(name = "id_district")
    @ManyToOne
    private Ubigeo ubigeo;

    @JoinColumn(name = "id_identity_document")
    @ManyToOne
    @NonNull
    private IdentityDocument identityDocument;
    @JoinColumn(name = "create_uid")
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private User createUser;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date createDate;
    @JoinColumn(name = "edit_uid")
    @ManyToOne(fetch = FetchType.LAZY)
    private User editUser;
    @Column(name = "edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;
    @Column(name = "active")
    @NotNull
    private Boolean active = Boolean.TRUE;

    public Actor(Long id) {
        this.id = id;
    }

}
