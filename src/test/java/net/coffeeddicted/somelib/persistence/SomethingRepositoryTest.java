// Copyright Coffeeddicted 2018
package net.coffeeddicted.somelib.persistence;

import net.coffeeddicted.somelib.SomelibService;
import net.coffeeddicted.somelib.domain.something.Something;
import net.coffeeddicted.somelib.domain.something.SomethingType;

import java.util.List;
import java.util.Optional;
import org.assertj.core.util.Arrays;
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
public class SomethingRepositoryTest {
    
    @Autowired
    private SomethingRepository somethingRepository;
    
    @Autowired
    private SomethingTypeRepository somethingTypeRepository;
    
    @Before
    public void checkDbInitializationTest() {
        Assert.assertTrue(somethingRepository.count() == 10);
    }
    
    @Test
    public void findByNameTest() {
        System.out.println("findByName");
        
        String sName = "Something 2";
        int expSize = 1;
        
        List<Something> ls = somethingRepository.findByName(sName);
        Assert.assertTrue(ls.size() == expSize);
        Assert.assertEquals(sName, ls.get(0).getName());   
    }
    
    @Test
    public void findByPrimarySomethingTypeTest() {
        System.out.println("findByPrimarySomethingType");
         
        long typeId = 1;
        int expSize = 4;
        long expSthId = 1;
         
        Optional<SomethingType> ost = somethingTypeRepository.findById(typeId);
        SomethingType st = ost.get();
         
        List<Something> ls = somethingRepository.findByPrimarySomethingType(st);
        Assert.assertTrue(ls.size() == expSize);
        Assert.assertTrue(ls.get(0).getId() == expSthId);
    }
     
    @Test
    public void findBySecondarySomethingTypeTest() {
        System.out.println("findBySecondarySomethingType");
        
        long typeId = 1;
        int expSize = 3;
        long expSthId = 3;
         
        Optional<SomethingType> ost = somethingTypeRepository.findById(typeId);
        SomethingType st = ost.get();
         
        List<Something> ls = somethingRepository.findBySecondarySomethingType(st);
        Assert.assertTrue(ls.size() == expSize);
        Assert.assertTrue(ls.get(0).getId() == expSthId);
    }
     
    @Test
    public void findByPrimarySomethingTypeAndSecondarySomethingTypeTest() {
        System.out.println("findByPrimarySomethingTypeAndSecondarySomethingType");
         
        long typId1 = 4;
        long typId2 = 1;
        int expSize = 2;
        long expId0 = 7;
        long expId1 = 8;
        
        Optional<SomethingType> ost1 = somethingTypeRepository.findById(typId1);
        Optional<SomethingType> ost2 = somethingTypeRepository.findById(typId2);
        SomethingType st1 = ost1.get();
        SomethingType st2 = ost2.get();
        
        List<Something> ls = somethingRepository.findByPrimarySomethingTypeAndSecondarySomethingType(st1, st2);
        Assert.assertTrue(ls.size() == expSize);
        Assert.assertTrue(ls.get(0).getId() == expId0);
        Assert.assertTrue(ls.get(1).getId() == expId1);
    }
    
    @Test
    public void findByPrimarySomethingTypeOrSecondarySomethingTypeTest() {
        System.out.println("findByPrimarySomethingTypeOrSecondarySomethingType");
         
        long typId1 = 4;
        long typId2 = 1;
        int expSize = 5;
        long[] expIds = {3l, 7l, 8l, 9l, 10l};
        
        Optional<SomethingType> ost1 = somethingTypeRepository.findById(typId1);
        Optional<SomethingType> ost2 = somethingTypeRepository.findById(typId2);
        SomethingType st1 = ost1.get();
        SomethingType st2 = ost2.get();
        
        List<Something> ls = somethingRepository.findByPrimarySomethingTypeOrSecondarySomethingType(st1, st2);
        Assert.assertTrue(ls.size() == expSize);
        for (int i = 0; i < expIds.length; i++) {
            Assert.assertTrue(ls.get(i).getId() == expIds[i]);
        }
    }
    
    @Test
    public void findBySecondarySomethingTypeIsNullTest() {
        System.out.println("findBySecondarySomethingTypeIsNull");
        
        long[] expIds = {2, 5};
        
        List<Something> ls = somethingRepository.findBySecondarySomethingTypeIsNull();
        Assert.assertTrue(ls.size() == expIds.length);
        for (int i = 0; i < expIds.length; i++) {
            Assert.assertTrue(ls.get(i).getId() == expIds[i]);
        }
        
    }
    
}
