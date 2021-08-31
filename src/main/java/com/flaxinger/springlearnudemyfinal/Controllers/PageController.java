package com.flaxinger.springlearnudemyfinal.Controllers;

import com.flaxinger.springlearnudemyfinal.model.StatusUpdate;
import com.flaxinger.springlearnudemyfinal.service.StatusUpdateService;
import jdk.jshell.Snippet;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class PageController {

    @Autowired
    private StatusUpdateService statusUpdateService;

    @RequestMapping("/")
    ModelAndView home(ModelAndView modelAndView){

        StatusUpdate statusUpdate = statusUpdateService.getLatest();
        modelAndView.getModel().put("statusUpdate", statusUpdate);
        modelAndView.setViewName("app.homepage");
        return modelAndView;
    }

    @RequestMapping("/about")
    public String about() { return "app.about"; }

    // @ModelAttribute creates the object + adds it to the model
    // Is it ok not to use it?
    //   Spring actually creates a new statusUpdate and adds it to the model automatically
    //   However, for clarity it is good practice to add it nonetheless



}
