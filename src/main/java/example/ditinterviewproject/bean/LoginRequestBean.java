package example.ditinterviewproject.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginRequestBean {
    private String user_name;
    private String password;
}
