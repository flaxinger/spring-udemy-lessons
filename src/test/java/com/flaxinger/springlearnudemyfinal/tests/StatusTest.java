package com.flaxinger.springlearnudemyfinal.tests;

import com.flaxinger.springlearnudemyfinal.App;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.flaxinger.springlearnudemyfinal.model.StatusUpdate;
import com.flaxinger.springlearnudemyfinal.model.StatusUpdateDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import javax.transaction.Status;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Optional;
//import org.springframework.boot.test.SpringApplicationConfiguration;

//

// Seems to be deprecated
// @SpringApplicationConfiguration(App.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class StatusTest {

    @Autowired
    private StatusUpdateDao statusUpdateDao;

    @Test
    public void testSave() {
        StatusUpdate status = new StatusUpdate("This is a test status update");

        statusUpdateDao.save(status);

        assertNotNull("Non-null ID", status.getId());
        assertNotNull("Non-null ID", status.getAdded());

        Optional<StatusUpdate> retrieved = statusUpdateDao.findById(status.getId());


        assertEquals("Matching Status Update", status, retrieved.get());
    }

    @Test
    @DisplayName("Test Find Latest")
    public void testFindLatest(){
        Calendar calendar = Calendar.getInstance();

        StatusUpdate lastStatusUpdate = null;

        for(int i = 0; i < 10; i++){
            calendar.add(Calendar.DAY_OF_YEAR, 1);

            StatusUpdate status = new StatusUpdate("Status update " + i, calendar.getTime());

            statusUpdateDao.save(status);

            lastStatusUpdate = status;
        }

        StatusUpdate retrieved = statusUpdateDao.findFirstByOrderByAddedDesc();

        assertEquals("Latest status update", lastStatusUpdate, retrieved);

    }


}
