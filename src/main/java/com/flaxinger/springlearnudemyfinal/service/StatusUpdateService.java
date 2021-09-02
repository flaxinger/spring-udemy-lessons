package com.flaxinger.springlearnudemyfinal.service;

import com.flaxinger.springlearnudemyfinal.model.StatusUpdate;
import com.flaxinger.springlearnudemyfinal.model.StatusUpdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StatusUpdateService {

    private int PAGESIZE;

    public int getPAGESIZE() {
        return PAGESIZE;
    }

    public void setPAGESIZE(int PAGESIZE) {
        this.PAGESIZE = PAGESIZE;
    }

    @Autowired
    private StatusUpdateDao statusUpdateDao;
    
    public void save(StatusUpdate statusUpdate){
        statusUpdateDao.save(statusUpdate);
    }

    public StatusUpdate getLatest(){
        return statusUpdateDao.findFirstByOrderByAddedDesc();
    }

    public Page<StatusUpdate> getPage(int pageNumber){
        //PageRequest request = new PageRequest(pageNumber-1, PAGESIZE, Sort.Direction.DESC, "added");
        // The [new PageRequest()] function has been deprecated
        PageRequest request = PageRequest.of(pageNumber-1, PAGESIZE, Sort.Direction.DESC, "added");

        return statusUpdateDao.findAll(request);

    }

    public void delete(Long id) {
        // In the Lecture, just delete() was used. However, in recent versions delete() requires the entity.
        statusUpdateDao.deleteById(id);
    }

    public StatusUpdate get(Long id) {
        return statusUpdateDao.findById(id).orElse(null);
    }
}
