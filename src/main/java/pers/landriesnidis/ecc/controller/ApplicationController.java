package pers.landriesnidis.ecc.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.landriesnidis.ecc.bean.ApplicationBean;
import pers.landriesnidis.ecc.dao.ApplicationService;
import pers.landriesnidis.ecc.dao.DeveloperService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

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

        //获取当前用户拥有的APP列表
//        List<ApplicationBean> lstApp = applicationService.getApplicationBySession(request.getSession().getId());
//        //判断拥有的APP数量是否不为0
//        if(lstApp.size()>0){
//            //构造下拉选项列表
//            StringBuilder sbOptions = new StringBuilder();
//            for(ApplicationBean app : lstApp){
//                sbOptions.append(String.format("<option value=\"%s\">%s</option>",app.getAppAPIKey(),app.getAppName()));
//            }
//        }else{
//            //没有应用
//        }

        return "ApplicationManage";
    }

    @RequestMapping("/ServerSetting")
    public String serverSetting(ModelMap map, HttpServletRequest request){
        //检测Session是否有效,并载页面动态信息
        String returnUrl = ControllerUtils.checkSessionInvalid(map,request);
        if(returnUrl!=null)return returnUrl;

        //获取当前用户拥有的APP列表
        List<ApplicationBean> lstApp = applicationService.getApplicationBySession(request.getSession().getId());
        if(lstApp.size()>0){
            //这里只读取第一个记录
            ApplicationBean app = lstApp.get(0);
            map.addAttribute("app_name",app.getAppName());
            map.addAttribute("app_api_key",app.getAppAPIKey());

            try{
                String strConfig = app.getAppServerSettings();
                if(strConfig != null){
                    JSONObject json = new JSONObject(strConfig);
                    for (Iterator<String> it = json.keys(); it.hasNext(); ) {
                        String key = it.next();
                        map.addAttribute(key,json.get(key));
                    }
                }
            }catch (JSONException e){}
        }else{
            return "redirect:/AppPage";
        }
        return "ServerSetting";
    }

    @RequestMapping("/serverSettingParam")
    public String serverSettingParam(ModelMap map, HttpServletRequest request){
        //检测Session是否有效,并载页面动态信息
        String returnUrl = ControllerUtils.checkSessionInvalid(map,request);
        if(returnUrl!=null)return returnUrl;

        JSONObject json = new JSONObject();
        Enumeration enume = request.getParameterNames();
        while (enume.hasMoreElements()) {
            String key = (String) enume.nextElement();
            String val = request.getParameter(key);
            json.put(key,val);
        }

        String strSession = request.getSession().getId();
        String strApiKey = request.getParameter("app_key");
        String strConfigParam = json.toString();

        try
        {
            //设置服务端配置
            applicationService.setApplicationServerSettings(strSession,strApiKey,strConfigParam);
        }
        catch (DataAccessException e)
        {
            String redirectUrl = ControllerUtils.getRedirectUrlByException(map,request,e);
            if(redirectUrl!=null)return redirectUrl;
        }

        return "redirect:/ServerSetting";
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
