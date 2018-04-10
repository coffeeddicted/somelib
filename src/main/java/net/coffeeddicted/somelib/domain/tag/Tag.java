// Copyright 2018, Coffeeddicted
package net.coffeeddicted.somelib.domain.tag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Coffeeddicted
 */
@SuppressWarnings("PersistenceUnitPresent")
@Entity
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "SeqTag", sequenceName = "SeqTag", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqTag")
    private long id;
    
    @Column(length = 63)
    private String name;
    
    @ManyToMany(targetEntity = Tag.class)
    private final List<Tag> linkedTags = new ArrayList<>();
    
    public Tag () {}
    
    public Tag (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Tag, %d, %s", id, name);
    }
    
    
    
    public int getNumberOfLinkedTags() {
        return linkedTags.size();
    }

    public List<Tag> getLinkedTags() {
        return linkedTags;
    }

    public void addLinkedTag(Tag tag) {
        linkedTags.add(tag);
    }

    public void removeLinkedTag(Tag tag) {
        // Precondition : element must be tagged
        if (!linkedTags.contains(tag)) {
            throw new IllegalArgumentException("Cannot remove a non-linked tag");
        }
        linkedTags.remove(tag);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
