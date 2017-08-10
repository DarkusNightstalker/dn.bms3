package dn.bms3.model;

import dn.core3.model.interfac.AuditoryEntity;
import dn.core3.model.interfac.EntityActivate;
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
@Table(name = "company_group")
@XmlRootElement
@Data 
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class CompanyGroup  implements AuditoryEntity<Integer, User>, EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;
    @Column(name = "name")
    @NonNull
    protected String name;
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

    public CompanyGroup(Integer companyGroupId) {
        this.id = companyGroupId;
    }
}
