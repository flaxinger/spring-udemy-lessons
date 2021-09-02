package com.flaxinger.springlearnudemyfinal.Controllers;

import com.flaxinger.springlearnudemyfinal.model.StatusUpdate;
import com.flaxinger.springlearnudemyfinal.service.StatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StatusUpdateController {

    @Autowired
    private StatusUpdateService statusUpdateService;

    @RequestMapping(value = "/editstatus", method = RequestMethod.GET)
    public ModelAndView editStatus(ModelAndView modelAndView, @RequestParam(name="id") Long id){

        StatusUpdate statusUpdate = statusUpdateService.get(id);

        modelAndView.getModel().put("statusUpdate", statusUpdate);

        modelAndView.setViewName("app.editStatus");

        return modelAndView;
    }

    @RequestMapping(value = "/editstatus", method = RequestMethod.POST)
    public ModelAndView editStatus(ModelAndView modelAndView, @Valid StatusUpdate statusUpdate, BindingResult result){

        modelAndView.setViewName("app.editStatus");

        if(!result.hasErrors()){
            statusUpdateService.save(statusUpdate);
            modelAndView.setViewName("redirect:/viewstatus");
        }

        modelAndView.getModel().put("statusUpdate", statusUpdate);

        return modelAndView;
    }

    @RequestMapping(value = "/deletestatus", method = RequestMethod.GET)
    public ModelAndView deleteStatus(ModelAndView modelAndView, @RequestParam(name="id") Long id){

        statusUpdateService.delete(id);

        modelAndView.setViewName("redirect:/viewstatus");

        return modelAndView;
    }

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

    // @Valid validates form inputs with validation specifications in the entity class
    // Binding result(Spring) holds the validation results
    @RequestMapping(value = "/addstatus", method = RequestMethod.POST)
    public ModelAndView addStatus(ModelAndView modelAndView, @Valid StatusUpdate statusUpdate, BindingResult result){

        modelAndView.setViewName("app.addStatus");

        if(!result.hasErrors()){
            statusUpdateService.save(statusUpdate);
            // Sending new status update to model after update
            // this the input form after post
            modelAndView.getModel().put("statusUpdate", new StatusUpdate());
            modelAndView.setViewName("redirect:/viewstatus");
        }

        // Posting most recent status update
        StatusUpdate latestStatusUpdate = statusUpdateService.getLatest();
        modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);

        return modelAndView;
    }

    // RequestParam gets a parameter via the url
    // you need a variable name that gets the parameter and another variable name for the function parameter
    @RequestMapping(value = "/viewstatus", method = RequestMethod.GET)
    public ModelAndView viewStatus(ModelAndView modelAndView, @RequestParam(name="p", defaultValue = "1") int pageNumber,
                                   @RequestParam(name="s", defaultValue ="10") int pageSize){

        statusUpdateService.setPAGESIZE(pageSize);
        Page<StatusUpdate> page = statusUpdateService.getPage(pageNumber);

        modelAndView.setViewName("app.viewStatus");
        modelAndView.getModel().put("page", page);

        return modelAndView;

    }
}
