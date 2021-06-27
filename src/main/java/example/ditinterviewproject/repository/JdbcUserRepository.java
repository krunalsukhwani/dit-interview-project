package example.ditinterviewproject.repository;

import example.ditinterviewproject.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(User user) {
        return jdbcTemplate.update("INSERT INTO users(first_name,last_name,user_name,user_password) VALUES(?,?,?,?)",
                user.getFirst_name(),user.getLast_name(),user.getUser_name(),user.getPassword());
    }
}
