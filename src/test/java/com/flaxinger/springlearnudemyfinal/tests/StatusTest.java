package com.flaxinger.springlearnudemyfinal.tests;

import com.flaxinger.springlearnudemyfinal.App;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;
//import org.springframework.boot.test.SpringApplicationConfiguration;

//

// Seems to be deprecated
// @SpringApplicationConfiguration(App.class)
@SpringBootTest
@WebAppConfiguration
public class StatusTest {

    @Test
    public void testDummy() {
        Long value = 7L;
        assertNotNull("Value Should not be Null", value);
    }


}
