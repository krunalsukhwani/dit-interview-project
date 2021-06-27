package example.ditinterviewproject.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginResponseBean {
    private String success;
    private String data;
    private String error;
}
