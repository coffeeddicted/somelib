// Copyright 2018, Coffeeddicted
package net.coffeeddicted.somelib.persistence;

import java.util.List;
import net.coffeeddicted.somelib.domain.tag.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Coffeeddicted
 */
@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    
    List<Tag> findByName(String name);
    List<Tag> findByNameContaining(String name);
    List<Tag> findByLinkedTagsContaining(Tag tag);
       
}
