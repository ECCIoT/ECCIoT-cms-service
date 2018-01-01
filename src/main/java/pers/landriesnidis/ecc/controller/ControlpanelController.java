package pers.landriesnidis.ecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.landriesnidis.ecc.bean.DeveloperBean;
import pers.landriesnidis.ecc.dao.DeveloperService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by landriesnidis on 17-10-27.
 */
@Controller
public class ControlpanelController {

    @Autowired
    private DeveloperService userService;

    @RequestMapping("/index")
    public String index(ModelMap map, HttpServletRequest request){

        //检测Session是否有效,并载页面动态信息
        String returnUrl = ControllerUtils.checkSessionInvalid(map,request);
        if(returnUrl!=null)return returnUrl;

        return "ControlPanel";
    }
}
