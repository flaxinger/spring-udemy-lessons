package com.flaxinger.springlearnudemyfinal.Controllers;

import com.flaxinger.springlearnudemyfinal.model.StatusUpdate;
import com.flaxinger.springlearnudemyfinal.service.StatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class PageController {

    @Autowired
    private StatusUpdateService statusUpdateService;

    @RequestMapping("/")
    public String home(){
        return "app.homepage";
    }

    @RequestMapping("/about")
    public String about() { return "app.about"; }

    // @ModelAttribute creates the object + adds it to the model
    // Is it ok not to use it?
    //   Spring actually creates a new statusUpdate and adds it to the model automatically
    //   However, for clarity it is good practice to add it nonetheless
    @RequestMapping(value = "/addstatus", method = RequestMethod.GET)
    public ModelAndView addStatus(ModelAndView modelAndView, @ModelAttribute("statusUpdate") StatusUpdate statusUpdate) {

        modelAndView.setViewName("app.addStatus");
//        return "app.addStatus";
//        StatusUpdate statusUpdate = new StatusUpdate();

        // Posting most recent status update
        StatusUpdate latestStatusUpdate = statusUpdateService.getLatest();
        modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);

//        modelAndView.getModel().put("statusUpdate", statusUpdate);
        return modelAndView;
    }

    @RequestMapping(value = "/addstatus", method = RequestMethod.POST)
    public ModelAndView addStatus(ModelAndView modelAndView, StatusUpdate statusUpdate, String temp){

        modelAndView.setViewName("app.addStatus");
        statusUpdateService.save(statusUpdate);

        // Posting most recent status update
        StatusUpdate latestStatusUpdate = statusUpdateService.getLatest();
        modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);

        // Sending new status update to model after update
        // this the input form after post
        modelAndView.getModel().put("statusUpdate", new StatusUpdate());

        return modelAndView;
    }
}
