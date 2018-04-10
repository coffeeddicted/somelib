// Copyright 2018, Coffeeddicted
package net.coffeeddicted.somelib.persistence;

import java.util.List;
import net.coffeeddicted.somelib.SomelibService;
import net.coffeeddicted.somelib.domain.tag.Tag;
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
public class TagRepositoryTest {
    @Autowired
    private TagRepository tagRepo;
    
    @Before
    public void checkDbInitializationTest() {
        System.out.println("SOMELIB / TagRepositoryTest");
        Assert.assertTrue(tagRepo.count() == 3);
    }
    
    @Test
    public void findByNameTest () {
        System.out.println("SOMELIB / TagRepositoryTest : findByNameContaining");
        
        // Parameters
        String name = "Tag";
        int expSize = 3;
        
        // Test
        List<Tag> tags = tagRepo.findByNameContaining(name);
        
        // Assert
        Assert.assertEquals(expSize, tags.size());
    }
    
    @Test
    public void findByLinkedTagsContainingTest () {
        System.out.println("SOMELIB / TagRepositoryTest : findByLinkedTagsContaining");
        
        // Parameters
        Tag tag = tagRepo.findById(3L).get();
        int expSize = 2;
        
        // Test
        List<Tag> tags = tagRepo.findByLinkedTagsContaining(tag);
        tags.forEach((t) -> {
            System.out.println(t);
        });
        
        // Assert
        Assert.assertEquals(expSize, tags.size());
    }
    
}
