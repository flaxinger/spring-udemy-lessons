package com.flaxinger.springlearnudemyfinal.service;

import com.flaxinger.springlearnudemyfinal.model.StatusUpdate;
import com.flaxinger.springlearnudemyfinal.model.StatusUpdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusUpdateService {
    
    @Autowired
    private StatusUpdateDao statusUpdateDao;
    
    public void save(StatusUpdate statusUpdate){
        statusUpdateDao.save(statusUpdate);
    }

    public StatusUpdate getLatest(){
        return statusUpdateDao.findFirstByOrderByAddedDesc();
    }
}
