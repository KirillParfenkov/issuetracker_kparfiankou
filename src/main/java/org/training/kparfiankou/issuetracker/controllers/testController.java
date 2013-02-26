package org.training.kparfiankou.issuetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/26/13
 * Time: 2:12 PM
 */
@RequestMapping("/testServlet.to")
@Controller
public class testController {

    protected String perform(Model uiModel) {
        return "test.jsp";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String doPost(Model uiModel) {
        return perform(uiModel);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(Model uiModel) {
        return perform(uiModel);
    }
}
