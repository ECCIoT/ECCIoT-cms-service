package pers.landriesnidis.ecc.dao;

import pers.landriesnidis.ecc.bean.ApplicationBean;
import pers.landriesnidis.ecc.bean.DeveloperBean;
import pers.landriesnidis.ecc.bean.DeviceBean;

import java.util.List;

/**
 * Created by landriesnidis on 17-12-20.
 */
public interface ApplicationService {


    boolean createNewUser(final String strEmail, final String strPassword, final String strPhone, final int intIndustry, final String strSession);
    boolean checkUserPassword(final String strEmail, final String strPassword, final String strSession);
    DeveloperBean checkUserSession(String strSessionId);
    boolean setApplicationServerSettings(String strSessionId,String appApikey,String configParam);

    /**
     * 创建应用
     * @param strSessionId
     * @param strAppName
     * @param strAppNote
     * @return
     */
    boolean createApp(String strSessionId,String strAppName,String strAppNote);

    /**
     * 创建设备
     * @param strSession
     * @param strDeviceModel
     * @param strDeviceFlag
     * @param strDeviceNote
     * @return
     */
    boolean createDevice(String strSession,String strAppApiKey,String strDeviceModel,String strDeviceFlag,String strDeviceNote);

    /**
     * 获取设备列表
     * @param strSession
     * @param strAppApiKey
     * @return
     */
    List<DeviceBean> getDeviceList(String strSession,String strAppApiKey);

    /**
     * 通过APIKey对应Application的信息
     * @param strAPIKey
     * @return
     */
    ApplicationBean getAppInfoByKey(String strAPIKey);

    /**
     * 查询当前Session对应用户所有的应用信息
     * @param strSessionId
     * @return
     */
    List<ApplicationBean> getApplicationBySession(String strSessionId);

}
