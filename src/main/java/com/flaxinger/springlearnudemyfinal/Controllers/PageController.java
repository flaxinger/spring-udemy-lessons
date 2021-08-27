package com.flaxinger.springlearnudemyfinal.Controllers;

import com.flaxinger.springlearnudemyfinal.model.StatusUpdate;
import com.flaxinger.springlearnudemyfinal.service.StatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/addstatus", method = RequestMethod.GET)
    public ModelAndView addStatus(ModelAndView modelAndView) {

        modelAndView.setViewName("app.addStatus");
//        return "app.addStatus";
        StatusUpdate statusUpdate = new StatusUpdate();

        // Posting most recent status update
        StatusUpdate latestStatusUpdate = statusUpdateService.getLatest();
        modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);

        modelAndView.getModel().put("statusUpdate", statusUpdate);
        return modelAndView;
    }

    @RequestMapping(value = "/addstatus", method = RequestMethod.POST)
    public ModelAndView addStatus(ModelAndView modelAndView, StatusUpdate statusUpdate) {

        modelAndView.setViewName("app.addStatus");
        statusUpdateService.save(statusUpdate);

        // Posting most recent status update
        StatusUpdate latestStatusUpdate = statusUpdateService.getLatest();
        modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);

        return modelAndView;
    }
}
