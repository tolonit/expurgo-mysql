package br.com.tolonit.expurgo.expurgo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "domain_one")
public class DomainOne {

    @Id
    private Integer id;
    private String name;
    private Integer validityDays;

    public DomainOne() {
    }

    public DomainOne(int id, String name, int validityDays) {
        this.id = id;
        this.name = name;
        this.validityDays = validityDays;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getValidityDays() {
        if (this.validityDays == null)
            return 1000;
        return validityDays;
    }
}
