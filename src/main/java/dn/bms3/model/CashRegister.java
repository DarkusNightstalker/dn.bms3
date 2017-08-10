package dn.bms3.model;

import dn.core3.model.interfac.AuditoryEntity;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "cash_register", catalog = "public")
@XmlRootElement
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class CashRegister implements AuditoryEntity<Long, User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_company")
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Company company;
    @JoinColumn(name = "id_work_shift")
    @ManyToOne
    @NonNull
    private WorkShift workShift;
    @Column(name = "initial_cash")
    @NonNull
    private BigDecimal initialCash = BigDecimal.ZERO;
    @Column(name = "expected_cash")
    @NonNull
    private BigDecimal expectedCash = BigDecimal.ZERO;
    @Column(name = "credit")
    @NonNull
    private BigDecimal credit = BigDecimal.ZERO;
    @Column(name = "visa")
    @NonNull
    private BigDecimal visa = BigDecimal.ZERO;
    @Column(name = "\"out\"")
    @NonNull
    private BigDecimal outs = BigDecimal.ZERO;
    @Column(name = "real_cash")
    @NonNull
    private BigDecimal realCash = BigDecimal.ZERO;

    @Column(name = "payment_voucher_total")
    @NonNull
    private Integer paymentVoucherTotal;

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
    @Column(name = "date_arcing")
    @Temporal(TemporalType.DATE)
    @NonNull
    private Date dateArcing;

    public CashRegister(Long id) {
        this.id = id;
    }

    
}
