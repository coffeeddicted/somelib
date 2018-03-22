// Copyright Coffeeddicted 2018
package net.coffeeddicted.somelib.domain.contraption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Domain model class Contraption.
 * 
 * Here another class layout is presented.
 * 
 * @author Coffeeddicted
 */
@SuppressWarnings("PersistenceUnitPresent")
@Entity
public class Contraption implements Serializable {
    
    @Id
    @SequenceGenerator(name = "SeqContraption", sequenceName = "SeqContraption", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqContraption")
    private long id;
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    
    @Column(length = 63)
    private String name;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    
    @Column @Temporal(TemporalType.DATE)
    private Date someDate;
    public Date getSomeDate() {return someDate;}
    public void setSomeDate(Date someDate) {this.someDate = someDate;}
    
    @Column @Temporal(TemporalType.DATE)
    private Date expirationDate;
    public Date getExpirationDate() {return expirationDate;}
    public void setExpirationDate(Date expirationDate) {this.expirationDate = expirationDate;}
    
    @Column
    private boolean elementary;
    public boolean isElementary() {return elementary;}
    public void setElementary(boolean elementary) {this.elementary = elementary;}
    
    @OneToMany(targetEntity = Contraption.class)
    private List<Contraption> composition;
    public List<Contraption> getComposition() {return composition;}
    public void setComposition(List<Contraption> composition) {this.composition = composition;}
    
    protected Contraption () {}

    public Contraption(String name, Date someDate, Date expirationDate, boolean elementary) {
        this.name = name;
        this.someDate = someDate;
        this.expirationDate = expirationDate;
        this.elementary = elementary;
        this.composition = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("{Contraption{dd: %d, name: %s, someDate: %s, expirationDate: %s, isElementary: %b, numberOfSubElements: %d}}", 
                this.id, this.name, this.someDate, this.expirationDate, this.elementary, this.getCompositionListSize());
    }
    
    /**
     * Proxy to this.composition.size().
     * @return the number of elements in the composition list.
     */
    public int getCompositionListSize() {
        return this.composition.size();
    }
    
    /**
     * Proxy to this.composition.add().
     * @param contraption 
     */
    public void addSubContraption(Contraption contraption) {
        this.composition.add(contraption);
    }
    
    /**
     * Proxy to this.composition.get().
     * @param index
     * @return 
     */
    public Contraption getSubContraptionAtIndex(int index) {
        return this.composition.get(index);
    }

}
