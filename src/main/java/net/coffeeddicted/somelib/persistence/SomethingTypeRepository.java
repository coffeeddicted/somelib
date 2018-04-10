// Copyright 2018, Coffeeddicted
package net.coffeeddicted.somelib.persistence;

import net.coffeeddicted.somelib.domain.something.SomethingType;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Coffeeddicted
 */
@Repository
public interface SomethingTypeRepository extends CrudRepository<SomethingType, Long> {
    
    /**
     * @see spring-boot-starter-data-jpa documentation.
     * @param name
     * @return 
     */
    List<SomethingType> findByName(String name);
}
