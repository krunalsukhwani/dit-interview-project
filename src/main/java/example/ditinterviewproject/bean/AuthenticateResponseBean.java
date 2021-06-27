package example.ditinterviewproject.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthenticateResponseBean {
    private String success;
    private AuthDataResponse data;
    private String error;
}