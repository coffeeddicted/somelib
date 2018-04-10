// Copyright 2018, Coffeeddicted
package net.coffeeddicted.somelib.persistence;

import java.util.List;
import net.coffeeddicted.somelib.domain.something.Something;
import net.coffeeddicted.somelib.domain.something.SomethingType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Coffeeddicted
 */
@Repository
public interface SomethingRepository extends CrudRepository<Something, Long> {
    
    List<Something> findByName(String name);
    
    // @see https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    List<Something> findByPrimarySomethingType(SomethingType primarySomethingType);
    
    List<Something> findBySecondarySomethingType(SomethingType secondarySomethingType);
    
    List<Something> findByPrimarySomethingTypeAndSecondarySomethingType(SomethingType primarySomethingType, SomethingType secondarySomethingType);
    
    List<Something> findByPrimarySomethingTypeOrSecondarySomethingType(SomethingType primarySomethingType, SomethingType secondarySomethingType);
    
    List<Something> findBySecondarySomethingTypeIsNull();
}
