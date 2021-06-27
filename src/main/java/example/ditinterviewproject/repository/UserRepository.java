package example.ditinterviewproject.repository;

import example.ditinterviewproject.bean.CreateResponseBean;
import example.ditinterviewproject.bean.User;

public interface UserRepository {
    CreateResponseBean create(User user);
}
