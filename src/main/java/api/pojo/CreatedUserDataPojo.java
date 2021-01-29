package api.pojo;

import lombok.Getter;
import lombok.Setter;

public class CreatedUserDataPojo {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String job;
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String createdAt;
}
