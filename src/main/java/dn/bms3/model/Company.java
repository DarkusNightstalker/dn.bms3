package dn.bms3.model;

import dn.core3.model.interfac.AuditoryEntity;
import dn.core3.model.interfac.EntityActivate;
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
import javax.validation.constraints.Digits;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "company")
@XmlRootElement
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Company implements AuditoryEntity<Integer, User>, EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;
    @Column(name = "code")
    @NonNull
    protected String code;
    @Column(name = "name")
    @NonNull
    protected String name;
    @Column(name = "ruc")
    @NonNull
    protected String ruc;
    @Column(name = "description")
    protected String description;
    @JoinColumn(name = "id_district")
    @ManyToOne
    protected District district;
    @JoinColumn(name = "id_company_group")
    @ManyToOne
    protected CompanyGroup companyGroup;
    @Column(name = "city")
    protected String city;
    @Column(name = "address")
    protected String address;
    @Column(name = "phone1")
    protected String phone1;
    @Column(name = "phone2")
    protected String phone2;
    @Column(name = "fax")
    protected String fax;
    @Column(name = "private_transport_description")
    protected String privateTransportDescription;
    @Column(name = "private_driver_license")
    protected String privateDriverLicense;
    @JoinColumn(name = "id_parent")
    @ManyToOne
    protected Company parent;
    @Column(name = "path")
    protected String path;
    @Column(name = "igv_percent")
    @NonNull
    protected BigDecimal igvPercent = BigDecimal.ZERO;

    @Column(name = "title")
    protected String title;
    @Column(name = "address_reference")
    protected String addressReference;
    @Column(name = "last_data_update")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastDataUpdate;
    @Column(name = "can_buy")
    @NonNull
    protected Boolean buy = Boolean.FALSE;
    @Column(name = "can_stored")
    @NonNull
    protected Boolean stored = Boolean.FALSE;
    @Column(name = "can_sold")
    @NonNull
    protected Boolean sold = Boolean.FALSE;

    @JoinColumn(name = "create_uid")
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    protected User createUser;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
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

    public Company(Integer id) {
        this.id = id;
    }

}
