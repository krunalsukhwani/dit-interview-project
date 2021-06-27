package example.ditinterviewproject.service;

import example.ditinterviewproject.bean.CreateResponseBean;
import example.ditinterviewproject.bean.LoginRequestBean;
import example.ditinterviewproject.bean.LoginResponseBean;
import example.ditinterviewproject.bean.UserBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface DitService {
    CreateResponseBean create(UserBean user);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
