package pers.landriesnidis.ecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.InvalidResultSetAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.landriesnidis.ecc.dao.SQLExceptionCallback;
import pers.landriesnidis.ecc.dao.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

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
    public String registerParam(final ModelMap map, HttpServletRequest request){
        String strEmail = request.getParameter("email");
        String strPassword = request.getParameter("password");
        String strPhone = request.getParameter("phone");
        int intIndustry = Integer.parseInt(request.getParameter("industry"));
        String strSession = request.getSession().getId();

        try
        {
            userService.createNewUser(strEmail, strPassword, strPhone, intIndustry, strSession);
        }
        catch (DataAccessException e)
        {
            SQLException exception = (SQLException)e.getCause();
            map.addAttribute("error_info",exception.getMessage());
            return "UserRegister";
        }

        return "ControlPanel";
    }
}
