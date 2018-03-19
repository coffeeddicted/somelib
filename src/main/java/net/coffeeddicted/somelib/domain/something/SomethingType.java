// Copyright Coffeeddicted 2018
package net.coffeeddicted.somelib.domain.something;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Domain model class SomethingType.
 * A domain model class :
 *  - is an @Entity so that it can be persisted through JPA ;
 *  - must provide an Id
 *  - must provide a no-arg constructor ;
 *  - should provide a more suitable constructor for domain methods (typically all except Id) ;
 *  - must provide getter and setter for all persistable fields.
 * 
 * @author Coffeeddicted
 */
@SuppressWarnings("PersistenceUnitPresent")
@Entity
public class SomethingType implements Serializable {
    
    @Id
    @SequenceGenerator(name = "SeqSomethingType", sequenceName = "SeqSomethingType", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqSomethingType")
    private Long id;
    
    @Column(length = 63)
    private String name;
    
    protected SomethingType() {}
    
    public SomethingType(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return String.format("{SomethingType{id:%d, name:%s}}", this.id, this.name);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
