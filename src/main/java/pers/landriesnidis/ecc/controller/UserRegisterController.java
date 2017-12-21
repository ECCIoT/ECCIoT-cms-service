package pers.landriesnidis.ecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.landriesnidis.ecc.dao.UserService;

/**
 * Created by landriesnidis on 17-10-27.
 */
@Controller
public class UserRegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/registerPage")
    public String registerPage(ModelMap map){
        return "UserRegister";
    }

    @RequestMapping("/registerParam")
    public String registerParam(ModelMap map){
        String strEmail = map.get("email").toString();
        String strPassword = map.get("password").toString();
        String strPhone = map.get("phone").toString();
        int intIndustry = Integer.parseInt(map.get("industry").toString());

        userService.createNewUser(strEmail,strPassword,strPhone,intIndustry);

        return "ControlPanel";
    }
}
