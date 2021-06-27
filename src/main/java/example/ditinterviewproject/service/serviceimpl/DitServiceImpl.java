package example.ditinterviewproject.service.serviceimpl;

import example.ditinterviewproject.bean.CreateResponseBean;
import example.ditinterviewproject.bean.LoginRequestBean;
import example.ditinterviewproject.bean.LoginResponseBean;
import example.ditinterviewproject.bean.UserBean;
import example.ditinterviewproject.repository.UserRepository;
import example.ditinterviewproject.service.DitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("ditService")
public class DitServiceImpl implements DitService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public CreateResponseBean create(UserBean user) {
        return userRepository.create(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("vishptl".equals(username)) {
            return new User("vishptl", "$2a$10$E3hnIxpKBLe13Jc0iTk37.HL8aEN3QkQb1/fZQizivF.f.EqQMN52",new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
