package br.com.tolonit.expurgo.expurgo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity(name = "domain_two")
public class DomainTwo {

    @Id
    private String id;

    private Integer idDomainOne;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    public DomainTwo() {
    }

    public DomainTwo(String id, int idDomainOne, LocalDateTime creationDateTime) {
        this.id = id;
        this.idDomainOne = idDomainOne;
        this.creationDateTime = Date.from(creationDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
