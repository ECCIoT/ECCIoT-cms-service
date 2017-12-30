package pers.landriesnidis.ecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.landriesnidis.ecc.dao.DeveloperService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by landriesnidis on 17-10-27.
 */
@Controller
public class ApplicationController {

    @Autowired
    private DeveloperService userService;

    @RequestMapping("/AppPage")
    public String loginPage(ModelMap map){
        return "UserLogin";
    }


    @RequestMapping("/createApp")
    public String loginParam(final ModelMap map, HttpServletRequest request){

        //获取请求的参数和sessionId
        String strEmail = request.getParameter("email");
        String strPassword = request.getParameter("password");
        String strSession = request.getSession().getId();


        try
        {
            //校验账号密码
            userService.checkUserPassword(strEmail, strPassword, strSession);

            //保存用户名到session中
            request.getSession().setAttribute("account",strEmail);


        }
        catch (DataAccessException e)
        {
            SQLException exception = (SQLException)e.getCause();
            map.addAttribute("error_info",exception.getMessage());
            return "redirect:/loginPage";
        }

        return "redirect:/index";
    }
}
