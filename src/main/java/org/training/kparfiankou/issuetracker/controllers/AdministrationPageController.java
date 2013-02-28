package org.training.kparfiankou.issuetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.training.kparfiankou.issuetracker.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 1:46 PM
 */
@Controller
public class AdministrationPageController {

    @RequestMapping(value = Constants.CREATE_ADMINISTRATION_PAGE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createAdministrationPage() {

        return Constants.ADMINISTRATION_PAGE;
    }
}
