package pers.landriesnidis.ecc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;
import pers.landriesnidis.ecc.bean.DeveloperBean;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by landriesnidis on 17-12-20.
 */

@Service
public class DeveloperServiceImpl implements DeveloperService {

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
}
