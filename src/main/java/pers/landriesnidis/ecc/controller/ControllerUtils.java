package pers.landriesnidis.ecc.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by landriesnidis on 18-1-1.
 */
public class ControllerUtils {

    /**
     * 检测Session是否有效
     * @param map
     * @param request
     * @return
     */
    public static String checkSessionInvalid(ModelMap map, HttpServletRequest request){
        //检查是否显示错误提示信息
        Object account = request.getSession().getAttribute("account");
        if(account==null){
            request.getSession().setAttribute("returnUrl",request.getRequestURI());
            return "redirect:/loginPage";
        }else{
            map.addAttribute("account",account.toString());
            return null;
        }


    }

    /**
     * 根据异常信息获取跳转链接
     * @param map
     * @param request
     * @param e
     * @return
     */
    public static String getRedirectUrlByException(ModelMap map, HttpServletRequest request, DataAccessException e){

        SQLException exception = (SQLException)e.getCause();

        switch(exception.getMessage()){

            case "IDENTITY_INVALID":
                request.getSession().setAttribute("error_info","身份已失效，请重新登录。");
                request.getSession().setAttribute("returnUrl",request.getRequestURI());
                return "redirect:/loginPage";

            case "AUTHENTICATION_FAILED":
                request.getSession().setAttribute("error_info","帐号或密码错误，请再次确认。");
                return "redirect:/loginPage";

            case "PASSWORD_IS_WRONG":
                request.getSession().setAttribute("error_info","原密码不正确。");
                return "redirect:/userManage";

            case "EMAIL_OCCUPIED":
                request.getSession().setAttribute("error_info","该Email已经被注册过。");
                return "redirect:/registerPage";

            case "INSUFFICIENT_PERMISSIONS":
                //当这个异常抛出时应该被记录下来，同时排查日志（有人试图寻找系统漏洞）
                request.getSession().setAttribute("error_info","无权限。");
                return "redirect:/error";
        }
        return null;
    }
}
