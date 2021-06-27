package example.ditinterviewproject.service;

import example.ditinterviewproject.bean.CreateResponseBean;
import example.ditinterviewproject.bean.User;

public interface DitService {
    CreateResponseBean create(User user);
}
