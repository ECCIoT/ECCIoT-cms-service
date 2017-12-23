package pers.landriesnidis.ecc.dao;

import pers.landriesnidis.ecc.bean.UserBean;

import java.sql.SQLException;

/**
 * Created by landriesnidis on 17-12-20.
 */
public interface UserService {

    /**
     * 创建新用户
     * @param strEmail
     * @param strPassword
     * @param strPhone
     * @param intIndustry
     * @param strSession
     * @return
     */
    boolean createNewUser(String strEmail, String strPassword, String strPhone, int intIndustry,String strSessionId);

    /**
     * 用户登录校验
     * @param account
     * @param password
     * @return
     */
    boolean checkUserPassword(String account, String password,String strSessionId);

    /**
     * 校验用户的Session
     * @param strSessionId
     * @return
     */
    UserBean checkUserSession(String strSessionId);
}
