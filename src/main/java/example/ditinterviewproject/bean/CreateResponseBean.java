package example.ditinterviewproject.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateResponseBean {
    private String success;
    private DataResponseBean data;
    private String error;
}
