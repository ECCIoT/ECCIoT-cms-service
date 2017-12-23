package pers.landriesnidis.ecc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.stereotype.Service;
import pers.landriesnidis.ecc.bean.UserBean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by landriesnidis on 17-12-20.
 */

@Service
public class UserServiceImpl implements UserService{

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
    public UserBean checkUserSession(String strSessionId) {
        RowMapper<UserBean> mapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
        UserBean user = jdbcTemplate.queryForObject("CALL CheckWebSession(?)",mapper,strSessionId);
        return user;
    }
}
