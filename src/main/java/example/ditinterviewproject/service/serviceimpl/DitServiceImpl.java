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
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

        Optional<UserBean> userBean = userRepository.findByUsername(username);

        if (userBean.get().getUser_name() == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        String pw_hash = BCrypt.hashpw(userBean.get().getPassword(), BCrypt.gensalt());
        return new org.springframework.security.core.userdetails.User(userBean.get().getUser_name(),pw_hash,
                new ArrayList<>());
    }
}
