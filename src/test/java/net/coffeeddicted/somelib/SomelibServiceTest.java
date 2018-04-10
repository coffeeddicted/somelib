// Copyright 2018, Coffeeddicted
package net.coffeeddicted.somelib;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author yann
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SomelibService.class)
public class SomelibServiceTest {
    
    @Test
    public void loadContext () {
        System.out.println("SOMELIB / SomelibServiceTest : loadContext");
        Assert.assertTrue(true);
    }
    
}
