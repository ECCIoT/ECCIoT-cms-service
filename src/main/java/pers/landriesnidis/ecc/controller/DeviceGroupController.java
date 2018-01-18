package pers.landriesnidis.ecc.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.landriesnidis.ecc.bean.DeviceBean;
import pers.landriesnidis.ecc.dao.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by landriesnidis on 17-10-27.
 */
@Controller
public class DeviceGroupController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/devicePage")
    public String devicePage(ModelMap map, HttpServletRequest request){
        //检测Session是否有效,并载页面动态信息
        String returnUrl = ControllerUtils.checkSessionInvalid(map,request);
        if(returnUrl!=null)return returnUrl;

        //读取参数（应用的APIkey）
        String strAppApiKey = request.getParameter("apikey");

        map.addAttribute("app_api_key",strAppApiKey);

        return "DeviceManage";
    }

    @RequestMapping("/devices")
    public String devices(ModelMap map, HttpServletRequest request){
        //检测Session是否有效,并载页面动态信息
        String returnUrl = ControllerUtils.checkSessionInvalid(map,request);
        if(returnUrl!=null)return returnUrl;

        return "DeviceList";
    }

    @RequestMapping("/createDevice")
    public String createDevice(final ModelMap map, HttpServletRequest request){

        //获取请求的参数和sessionId
        String strAppApiKey = request.getParameter("appApikey");
        String strDeviceModel = request.getParameter("deviceModel");
        String strDeviceFlag = request.getParameter("deviceFlag");
        String strDeviceNote = request.getParameter("deviceNote");
        String strSession = request.getSession().getId();

        try
        {
            //创建新应用
            applicationService.createDevice(strSession, strAppApiKey, strDeviceModel, strDeviceFlag, strDeviceNote);
        }
        catch (DataAccessException e)
        {
            String redirectUrl = ControllerUtils.getRedirectUrlByException(map,request,e);
            if(redirectUrl!=null)return redirectUrl;
        }

        return "redirect:/devicePage?apikey=" + strAppApiKey;
    }
}
