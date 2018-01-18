package pers.landriesnidis.ecc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import pers.landriesnidis.ecc.bean.ApplicationBean;
import pers.landriesnidis.ecc.bean.DeveloperBean;
import pers.landriesnidis.ecc.bean.DeviceBean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by landriesnidis on 17-12-20.
 */

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean createNewUser(final String strEmail, final String strPassword, final String strPhone, final int intIndustry, final String strSession){
        jdbcTemplate.update("CALL UserRegister(?,?,?,?,?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,strEmail);
                preparedStatement.setString(2,strPassword);
                preparedStatement.setString(3,strPhone);
                preparedStatement.setInt(4,intIndustry);
                preparedStatement.setString(5,strSession);
            }
        });
        return true;
    }

    @Override
    public boolean checkUserPassword(final String strEmail, final String strPassword, final String strSession) {
        jdbcTemplate.update("CALL UserLogin(?,?,?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,strEmail);
                preparedStatement.setString(2,strPassword);
                preparedStatement.setString(3,strSession);
            }
        });
        return false;
    }

    @Override
    public DeveloperBean checkUserSession(String strSessionId) {
        RowMapper<DeveloperBean> mapper = new BeanPropertyRowMapper<DeveloperBean>(DeveloperBean.class);
        DeveloperBean user = jdbcTemplate.queryForObject("CALL GetDeveloperInfoBySession(?)",mapper,strSessionId);
        return user;
    }

    @Override
    public boolean setApplicationServerSettings(final String strSessionId, final String appApikey, final String configParam) {
        jdbcTemplate.update("CALL setApplicationServerSettings(?,?,?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,strSessionId);
                preparedStatement.setString(2,appApikey);
                preparedStatement.setString(3,configParam);
            }
        });
        return false;
    }

    @Override
    public boolean createApp(final String strSessionId, final String strAppName, final String strAppNote) {
        jdbcTemplate.update("CALL CreateApp(?,?,?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,strSessionId);
                preparedStatement.setString(2,strAppName);
                preparedStatement.setString(3,strAppNote);
            }
        });
        return false;
    }

    @Override
    public boolean createDevice(final String strSession, final String strAppApiKey, final String strDeviceModel, final String strDeviceFlag, final String strDeviceNote) {
        jdbcTemplate.update("CALL CreateDevice(?,?,?,?,?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,strSession);
                preparedStatement.setString(2,strAppApiKey);
                preparedStatement.setString(3,strDeviceModel);
                preparedStatement.setString(4,strDeviceFlag);
                preparedStatement.setString(5,strDeviceNote);
            }
        });
        return false;
    }

    @Override
    public List<DeviceBean> getDeviceList(String strSession, String strAppApiKey) {
        RowMapper<DeviceBean> mapper = new BeanPropertyRowMapper<DeviceBean>(DeviceBean.class);
        List<DeviceBean> devicelst = jdbcTemplate.query("CALL GetDeviceList(?,?);",mapper,strSession,strAppApiKey);
        return devicelst;
    }

    @Override
    public ApplicationBean getAppInfoByKey(String strAPIKey) {
        RowMapper<ApplicationBean> mapper = new BeanPropertyRowMapper<ApplicationBean>(ApplicationBean.class);
        ApplicationBean app = jdbcTemplate.queryForObject("CALL GetAppInfoByKey(?);",mapper,strAPIKey);
        return app;
    }

    @Override
    public List<ApplicationBean> getApplicationBySession(String strSessionId) {
        RowMapper<ApplicationBean> mapper = new BeanPropertyRowMapper<ApplicationBean>(ApplicationBean.class);
        List<ApplicationBean> applst = jdbcTemplate.query("CALL GetAppListBySession(?)",mapper,strSessionId);
        return applst;
    }
}
