package api.pojo;

import lombok.Getter;
import lombok.Setter;

public class UserPojo {

    @Getter
    @Setter
    private UserDataPojo data;
    @Getter
    @Setter
    private SupportPojo support;
}
