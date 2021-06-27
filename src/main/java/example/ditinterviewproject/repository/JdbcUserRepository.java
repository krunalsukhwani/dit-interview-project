package example.ditinterviewproject.repository;

import example.ditinterviewproject.bean.CreateResponseBean;
import example.ditinterviewproject.bean.DataResponseBean;
import example.ditinterviewproject.bean.ResponseBean;
import example.ditinterviewproject.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class JdbcUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public CreateResponseBean create(User user) {
        CreateResponseBean respBean = new CreateResponseBean();
        DataResponseBean dataResp = new DataResponseBean();
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    PreparedStatement statement = con.prepareStatement("INSERT INTO users(first_name,last_name,user_name,user_password) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    statement.setString(1, user.getFirst_name());
                    statement.setString(2, user.getLast_name());
                    statement.setString(3, user.getUser_name());
                    statement.setString(4, user.getPassword());
                    return statement;
                }
            }, holder);

            dataResp.setId(String.valueOf(holder.getKey().intValue()));
            respBean.setError(null);
            respBean.setData(dataResp);
            respBean.setSuccess("true");
        } catch (Exception e) {
            dataResp.setId(null);
            respBean.setError(e.getMessage());
            respBean.setData(dataResp);
            respBean.setSuccess("false");
            System.out.println("Error in repository create method " + e.getMessage());
        }
        return respBean;
    }
}
