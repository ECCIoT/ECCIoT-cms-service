package pers.landriesnidis.ecc.dao;

import pers.landriesnidis.ecc.bean.DeveloperBean;

/**
 * Created by landriesnidis on 17-12-20.
 */
public interface ApplicationService {

    /**
     * 创建应用
     * @param strSessionId
     * @param strAppName
     * @param strAppNote
     * @return
     */
    boolean createApp(String strSessionId,String strAppName,String strAppNote);

    /**
     * 通过APIKey对应Application的信息
     * @param strAPIKey
     * @return
     */
    boolean getAppInfoByKey(String strAPIKey);

    /**
     * 查询当前Session对应用户所有的应用信息
     * @param strSessionId
     * @return
     */
    boolean getAppLicBySession(String strSessionId);

}
