package pers.landriesnidis.ecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.landriesnidis.ecc.dao.ApplicationService;
import pers.landriesnidis.ecc.dao.DeveloperService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by landriesnidis on 17-10-27.
 */
@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/AppPage")
    public String loginPage(ModelMap map, HttpServletRequest request){

        //检测Session是否有效,并载页面动态信息
        String returnUrl = ControllerUtils.checkSessionInvalid(map,request);
        if(returnUrl!=null)return returnUrl;

        return "ApplicationManage";
    }

    @RequestMapping("/ServerSetting")
    public String serverSetting(ModelMap map, HttpServletRequest request){
        //检测Session是否有效,并载页面动态信息
        String returnUrl = ControllerUtils.checkSessionInvalid(map,request);
        if(returnUrl!=null)return returnUrl;

        return "ServerSetting";
    }


    @RequestMapping("/createApp")
    public String loginParam(final ModelMap map, HttpServletRequest request){

        //获取请求的参数和sessionId
        String strAppName = request.getParameter("appName");
        String strAppNote = request.getParameter("appNote");
        String strSession = request.getSession().getId();


        try
        {
            //创建新应用
            applicationService.createApp(strSession,strAppName, strAppNote);
        }
        catch (DataAccessException e)
        {
            String redirectUrl = ControllerUtils.getRedirectUrlByException(map,request,e);
            if(redirectUrl!=null)return redirectUrl;
        }

        return "redirect:/AppPage";
    }
}
