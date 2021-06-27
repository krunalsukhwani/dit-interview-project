package example.ditinterviewproject.repository;

import example.ditinterviewproject.bean.CreateResponseBean;
import example.ditinterviewproject.bean.LoginRequestBean;
import example.ditinterviewproject.bean.UserBean;

import java.util.Optional;

public interface UserRepository {
    CreateResponseBean create(UserBean user);

    public Optional<UserBean> findByUsername(String username);
}
