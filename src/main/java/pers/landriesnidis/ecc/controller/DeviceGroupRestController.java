package pers.landriesnidis.ecc.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.landriesnidis.ecc.bean.DeviceBean;
import pers.landriesnidis.ecc.dao.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by landriesnidis on 17-10-27.
 */
@RestController
public class DeviceGroupRestController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/getDeviceList")
    public String getDeviceList(final ModelMap map, HttpServletRequest request){
        //获取请求的参数和sessionId
        String strAppApiKey = request.getParameter("appApikey");
        String strSession = request.getSession().getId();

        try
        {
            //获取设备列表
            List<DeviceBean> lstDevice = applicationService.getDeviceList(strSession, strAppApiKey);

            JSONArray jsonArray = new JSONArray();
            for (DeviceBean bean : lstDevice){
                jsonArray.put(bean.toJson());
            }
            JSONObject json = new JSONObject();
            json.put("code",0);
            json.put("msg","");
            json.put("count",lstDevice.size());
            json.put("data",jsonArray);

            return json.toString();
        }
        catch (DataAccessException e)
        {
            String redirectUrl = ControllerUtils.getRedirectUrlByException(map,request,e);
            if(redirectUrl!=null)return redirectUrl;
        }

        return "redirect:/devicePage";
    }
}
