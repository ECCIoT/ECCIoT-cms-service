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
public class DeveloperController {

    @Autowired
    private DeveloperService userService;

    @RequestMapping("/loginPage")
    public String loginPage(ModelMap map, HttpServletRequest request){
        //检查是否显示错误提示信息
        Object error_info = request.getSession().getAttribute("error_info");
        if(error_info!=null){
            map.addAttribute("error_info",error_info.toString());
            request.getSession().removeAttribute("error_info");
        }

        return "UserLogin";
    }

    @RequestMapping("/logout")
    public String logout(ModelMap map, HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/loginPage";
    }

    @RequestMapping("/loginParam")
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
            String redirectUrl = ControllerUtils.getRedirectUrlByException(map,request,e);
            if(redirectUrl!=null)return redirectUrl;
        }

        //检查是否有返回链接
        Object returnUrl = request.getSession().getAttribute("returnUrl");
        if(returnUrl!=null){
            request.getSession().removeAttribute("returnUrl");
            return "redirect:" + returnUrl.toString();
        }

        return "redirect:/index";
    }

    @RequestMapping("/registerPage")
    public String registerPage(ModelMap map, HttpServletRequest request){
        //检查是否显示错误提示信息
        Object error_info = request.getSession().getAttribute("error_info");
        if(error_info!=null){
            map.addAttribute("error_info",error_info.toString());
            request.getSession().removeAttribute("error_info");
        }

        return "UserRegister";
    }

    @RequestMapping("/registerParam")
    public String registerParam(final ModelMap map, HttpServletRequest request){

        //获取请求的参数和sessionId
        String strEmail = request.getParameter("email");
        String strPassword = request.getParameter("password");
        String strPhone = request.getParameter("phone");
        int intIndustry = Integer.parseInt(request.getParameter("industry"));
        String strSession = request.getSession().getId();

        try
        {
            //注册新用户
            userService.createNewUser(strEmail, strPassword, strPhone, intIndustry, strSession);
            //保存用户名到session中
            request.getSession().setAttribute("account",strEmail);
        }
        catch (DataAccessException e)
        {
            String redirectUrl = ControllerUtils.getRedirectUrlByException(map,request,e);
            if(redirectUrl!=null)return redirectUrl;
        }

        return "redirect:/index";
    }

    @RequestMapping("/userManage")
    public String UserManage(ModelMap map, HttpServletRequest request){

        //检测Session是否有效,并载页面动态信息
        String returnUrl = ControllerUtils.checkSessionInvalid(map,request);
        if(returnUrl!=null)return returnUrl;

        //检查是否显示错误提示信息
        Object error_info = request.getSession().getAttribute("error_info");
        if(error_info!=null){
            map.addAttribute("error_info",error_info.toString());
            request.getSession().removeAttribute("error_info");
        }

        return "UserManage";
    }

    @RequestMapping("/changePassword")
    public String changePassword(final ModelMap map, HttpServletRequest request){

        //获取请求的参数和sessionId
        String strPass = request.getParameter("pass");
        String strNewpass = request.getParameter("newpass");
        String strSession = request.getSession().getId();

        try
        {
            //修改密码
            userService.changePassword(strSession,strPass,strNewpass);
        }
        catch (DataAccessException e)
        {
            String redirectUrl = ControllerUtils.getRedirectUrlByException(map,request,e);
            if(redirectUrl!=null)return redirectUrl;
        }
        return "redirect:/index";
    }
}
