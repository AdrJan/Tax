package api.pojo;

import lombok.Getter;
import lombok.Setter;

public class UserDataPojo {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String first_name;
    @Getter
    @Setter
    private String last_name;
    @Getter
    @Setter
    private String avatar;
}
