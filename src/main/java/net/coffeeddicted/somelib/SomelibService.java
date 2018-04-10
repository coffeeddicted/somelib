// Copyright 2018, Coffeeddicted
package net.coffeeddicted.somelib;

import net.coffeeddicted.somelib.domain.something.SomethingType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

/**
 * The somelib library entry point.
 * 
 * @author Coffeeddicted
 */
@Service
@EnableAutoConfiguration
public class SomelibService {
    
    public void createSomethingType(SomethingType somethingType) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
