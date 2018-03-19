// Copyright Coffeeddicted 2018
package net.coffeeddicted.somelib.persistence;

import java.util.List;
import net.coffeeddicted.somelib.SomelibService;
import net.coffeeddicted.somelib.domain.something.SomethingType;

import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This test class is (obviously) for SomethingTypeRepository.
 * @RunWith(SpringRunner.class) is mandatory to use Spring Boot features related to JUnit.
 * @DataJpaTest enable Spring JPA testing features. It basically uses H2 (in-memory database).
 * @SpringBootTest(classes= ...) refers to the application context (the service entry point in this case).
 * 
 * @author Coffeeddicted
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes=SomelibService.class)
public class SomethingTypeRepositoryTest {
    
    @Autowired
    private SomethingTypeRepository repository;
    
    @BeforeClass
    public static void uselessMethod() {
        System.out.println("[somelib] : This message is useless. Nonetheless it provides an example of @BeforeClass.");
    }
    
    @Before
    public void checkDbInitializationTest() {
        Assert.assertTrue(repository.count() == 5); // See src/main/resources/data.sql
    }
    
    // Check src/main/resources/data.sql if there is a problem with this test. 
    @Test
    public void findByIdTest() {
        System.out.println("findById");
        long findId = 1;
        String expectedName = "Some name";
        
        Optional<SomethingType> sto = repository.findById(findId);
        if (sto.isPresent()) {
            SomethingType st = sto.get();
            Assert.assertEquals(expectedName, st.getName());
        } else {
            Assert.fail("This test is supposed to find one element.");
        }
    }
    
    // Check src/main/resources/data.sql if there is a problem with this test.
    @Test
    public void findByNameTest() {
        System.out.println("findByName");
        
        String searchedName = "Some name again";
        int expectedSizeList = 2;
        long expectedId0 = 3;
        long expectedId1 = 5;
        
        List<SomethingType> resultList = repository.findByName(searchedName);
        
        // Check the number of returned rows
        Assert.assertEquals(expectedSizeList, resultList.size());
        
        // Check returned ids
        long actualId0 = resultList.get(0).getId();
        Assert.assertEquals(expectedId0, actualId0);
        long actualId1 = resultList.get(1).getId();
        Assert.assertEquals(expectedId1, actualId1);
    }
    
    @Test
    public void persistTest() {
        System.out.println("persist");
        
        SomethingType st1 = new SomethingType("Machin truc");
        
        // Here it has no Id
        Assert.assertTrue(null == st1.getId());
        
        // Now persist so auto generation strategy for ids must work
        st1 = repository.save(st1);
        Assert.assertTrue(null != st1.getId());
        Assert.assertTrue(repository.count() == 6);   
    }
    
    @Test
    public void updateTest() {
        System.out.println("update");
        
        long searchedId = 2;
        String newName = "Machin bidule génial";
        
        // Search for a specific element by ID, then modify its name
        Optional<SomethingType> ost = repository.findById(searchedId);
        if (ost.isPresent()) {
            SomethingType st = ost.get();
            st.setName(newName);
        } else {
            Assert.fail("This test is supposed to find an element [1].");
        }
        
        // Now search the same ID again, then check modification is done
        ost = repository.findById(searchedId);
        if (ost.isPresent()) {
            SomethingType st = ost.get();
            Assert.assertEquals(newName, st.getName());
        } else {
            Assert.fail("This test is supposed to find an element [2].");
        }
    }
    
    @Test
    public void deleteTest() {
        System.out.println("delete");
        
        long searchedId = 1;
        Optional<SomethingType> ost = repository.findById(searchedId);
        if (ost.isPresent()) {
            SomethingType st = ost.get();
            repository.delete(st);
        } else {
            Assert.fail("This test is supposed to find an element.");
        }
        
        Assert.assertTrue(repository.count() == 4);
        ost = repository.findById(searchedId);
        Assert.assertFalse(ost.isPresent());
        
    }
    
}
