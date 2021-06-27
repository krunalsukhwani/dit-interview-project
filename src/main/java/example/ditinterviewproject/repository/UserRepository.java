package example.ditinterviewproject.repository;

import example.ditinterviewproject.bean.CreateResponseBean;
import example.ditinterviewproject.bean.LoginRequestBean;
import example.ditinterviewproject.bean.UserBean;

public interface UserRepository {
    CreateResponseBean create(UserBean user);
}
