package example.ditinterviewproject.service.serviceimpl;

import example.ditinterviewproject.bean.CreateResponseBean;
import example.ditinterviewproject.bean.User;
import example.ditinterviewproject.repository.UserRepository;
import example.ditinterviewproject.service.DitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ditService")
public class DitServiceImpl implements DitService {

    @Autowired
    UserRepository userRepository;

    @Override
    public CreateResponseBean create(User user) {
        CreateResponseBean respBean = new CreateResponseBean();
        int i = userRepository.create(user);
        System.out.println("i value : " + i);
        return respBean;
    }
}
