package dn.bms3.model;

import dn.core3.model.interfac.AuditoryEntity;
import dn.core3.model.interfac.EntityActivate;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "payment_proof", catalog = "public")
@XmlRootElement
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class PaymentProof implements AuditoryEntity<Short, User>, EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;
    @Column(name = "code")
    @Size(max = 2)
    @PositiveOrZero
    @NonNull
    @NotBlank
    @Digits(fraction = 0, integer = 2)
    private String code;
    @Column(name = "abbr")
    @Size(max = 10)
    private String abbr;
    @Column(name = "name")
    @NonNull
    @NotBlank
    @Size(max = 380)
    private String name;
    @Column(name = "for_sale")
    @NonNull
    private Boolean forSale = Boolean.FALSE;
    @Column(name = "for_purchase")
    @NonNull
    private Boolean forPurchase = Boolean.FALSE;
    @Column(name = "for_stored")
    @NonNull
    private Boolean forStored = Boolean.FALSE;
    @Column(name = "for_return")
    @NonNull
    private Boolean forReturn = Boolean.FALSE;

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
    private Date editDate;
    @Column(name = "active")
    @NonNull
    private Boolean active = Boolean.TRUE;

    public PaymentProof(Short id) {
        this.id = id;
    }

}
