// Copyright Coffeeddicted 2018
package net.coffeeddicted.somelib.domain.something;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Coffeeddicted
 */
@SuppressWarnings("PersistenceUnitPresent")
@Entity
public class Something implements Serializable {
    
    @Id
    @SequenceGenerator(name = "SeqSomething", sequenceName = "SeqSomething", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqSomething")
    private Long id;
    
    @Column(length = 63)
    private String name;
    
    @ManyToOne(optional = false)
    private SomethingType primarySomethingType;
    
    @ManyToOne(optional = true)
    private SomethingType secondarySomethingType;

    public Something() {}

    public Something(String name, SomethingType primarySomethingType, SomethingType secondarySomethingType) {
        this.name = name;
        this.primarySomethingType = primarySomethingType;
        this.secondarySomethingType = secondarySomethingType;
    }

    @Override
    public String toString() {
        return String.format("{Something{id=%d, name=%s, primarySomethingType=%s, secondarySomethingType=%s}}", id, name, primarySomethingType, secondarySomethingType);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SomethingType getPrimarySomethingType() {
        return primarySomethingType;
    }

    public void setPrimarySomethingType(SomethingType primarySomethingType) {
        this.primarySomethingType = primarySomethingType;
    }

    public SomethingType getSecondarySomethingType() {
        return secondarySomethingType;
    }

    public void setSecondarySomethingType(SomethingType secondarySomethingType) {
        this.secondarySomethingType = secondarySomethingType;
    }    
    
}
