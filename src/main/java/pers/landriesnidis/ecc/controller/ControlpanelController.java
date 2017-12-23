package pers.landriesnidis.ecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.landriesnidis.ecc.bean.UserBean;
import pers.landriesnidis.ecc.dao.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by landriesnidis on 17-10-27.
 */
@Controller
public class ControlpanelController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String homepage(ModelMap map, HttpServletRequest request){

        try
        {
            //校验账号密码
            UserBean user = userService.checkUserSession(request.getSession().getId());

            //保存email到session中
            request.getSession().setAttribute("email",user.getAccount_email());

            map.addAttribute("msg_msgcount","99+");
            map.addAttribute("user_nickname",user.getAccount_email());

            return "ControlPanel";
        }
        catch (DataAccessException e)
        {
            SQLException exception = (SQLException)e.getCause();
            map.addAttribute("error_info",exception.getMessage());
            return "redirect:/loginPage";
        }
    }
}
