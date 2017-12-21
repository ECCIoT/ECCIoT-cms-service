package pers.landriesnidis.ecc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by landriesnidis on 17-10-27.
 */
@Controller
public class DeviceGroupController {

    @RequestMapping("/group")
    public String homepage(ModelMap map){
        map.addAttribute("msg_msgcount","99+");
        map.addAttribute("user_nickname","猿长大人");
        return "DeviceGroup";
    }
}
