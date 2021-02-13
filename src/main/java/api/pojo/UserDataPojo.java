package api.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDataPojo {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
