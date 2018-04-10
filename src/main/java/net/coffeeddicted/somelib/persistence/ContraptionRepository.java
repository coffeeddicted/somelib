// Copyright 2018, Coffeeddicted
package net.coffeeddicted.somelib.persistence;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.coffeeddicted.somelib.domain.contraption.Contraption;

/**
 *
 * @author Coffeeddicted
 */
@Repository
public interface ContraptionRepository extends CrudRepository<Contraption, Long> {
    
    List<Contraption> findByName(String name);
    
    List<Contraption> findByNameContaining(String content);
    
    List<Contraption> findByExpirationDateBefore(Date date);
    
}
