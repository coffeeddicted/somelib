// Copyright Coffeeddicted 2018
package net.coffeeddicted.somelib.persistence;

import net.coffeeddicted.somelib.SomelibService;
import net.coffeeddicted.somelib.domain.contraption.Contraption;

import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Coffeeddicted
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes=SomelibService.class)
public class ContraptionRepositoryTest {
    
    @Autowired
    private ContraptionRepository contraptionRepository;
    
    @Before
    public void checkDbInitializationTest() {
        Assert.assertTrue(contraptionRepository.count() == 5);
    }
    
    @Test
    public void findByNameTest() {
        System.out.println("findByName");
        
        // Test parameters
        String sName = "Contraption 1";
        int expSize = 1;
        long expId = 1;
        
        List<Contraption> lc = contraptionRepository.findByName(sName);
        Assert.assertTrue(lc.size() == expSize);
        Assert.assertTrue(lc.get(0).getId() == expId);
    }
    
    @Test
    public void findByNameContainingTest() {
        System.out.println("findByNameContaining");
        
        // Test parameters
        String content = "trapt";
        int expSize = 5;
        
        List<Contraption> lc = contraptionRepository.findByNameContaining(content);
        Assert.assertTrue(lc.size() == expSize);
    }
    
    @Test
    public void findByExpirationDateBeforeTest() {
        System.out.println("findByExpirationDateBefore");
        
        // Test parameters
        Date testDate = new Date(2017, 1, 1);
        int expSize = 5;
        
        List<Contraption> lc = contraptionRepository.findByExpirationDateBefore(testDate);
        Assert.assertTrue(lc.size() == expSize);   
    }

    
}
