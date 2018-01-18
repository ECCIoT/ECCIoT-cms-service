package pers.landriesnidis.ecc.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.landriesnidis.ecc.bean.ApplicationBean;
import pers.landriesnidis.ecc.dao.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * Created by landriesnidis on 17-10-27.
 */
@RestController
public class ApplicationRestController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/getApplicationList")
    public String getApplicationList(final ModelMap map, HttpServletRequest request){
        try
        {
            //获取当前用户拥有的APP列表
            List<ApplicationBean> lstApp = applicationService.getApplicationBySession(request.getSession().getId());

            JSONArray jsonArray = new JSONArray();
            for (ApplicationBean bean : lstApp){
                jsonArray.put(bean.toJson());
            }
            JSONObject json = new JSONObject();
            json.put("code",0);
            json.put("msg","");
            json.put("count",lstApp.size());
            json.put("data",jsonArray);

            return json.toString();
        }
        catch (DataAccessException e)
        {
            return e.getCause().getMessage();
        }
    }
}
