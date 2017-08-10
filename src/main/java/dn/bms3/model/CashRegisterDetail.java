package dn.bms3.model;

import dn.bms3.enumerated.CashType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "cash_register_detail", catalog = "public")
@XmlRootElement
@EqualsAndHashCode(of = {"cashRegister","cashType"})
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class CashRegisterDetail implements Serializable {

    @Id
    @JoinColumn(name = "id_cash_register")
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    protected CashRegister cashRegister;
    @Id
    @Column(name = "cash_type")
    @Enumerated(EnumType.ORDINAL)
    @NonNull
    protected CashType cashType;
    @Column(name = "quantity")
    @Min(0)
    @NonNull
    protected Integer quantity = 0;

}
