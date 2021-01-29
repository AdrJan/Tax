package api.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserListPojo {

    @Getter
    @Setter
    private int page;
    @Getter
    @Setter
    private int per_page;
    @Getter
    @Setter
    private int total;
    @Getter
    @Setter
    private int total_pages;
    @Getter
    @Setter
    private List<UserDataPojo> data;
    @Getter
    @Setter
    SupportPojo support;
}
