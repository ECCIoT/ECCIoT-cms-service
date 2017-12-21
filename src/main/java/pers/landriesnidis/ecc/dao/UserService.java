package pers.landriesnidis.ecc.dao;

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
     * @return
     */
    boolean createNewUser(String strEmail, String strPassword, String strPhone, int intIndustry);

    /**
     * 用户登录校验
     * @param account
     * @param password
     * @param remember
     * @return
     */
    boolean checkUserPassword(String account, String password, boolean remember);


}
