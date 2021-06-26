package example.ditinterviewproject.bean;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseBean {
    private String success;
    private String data;
    private String error;
}
