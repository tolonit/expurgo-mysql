package br.com.tolonit.expurgo.expurgo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "domain_three")
public class DomainThree {

    @Id
    private String id;
    private String idDomainTwo;

    public DomainThree() {
    }

    public DomainThree(String id, String idDomainTwo) {
        this.id = id;
        this.idDomainTwo = idDomainTwo;
    }
}
