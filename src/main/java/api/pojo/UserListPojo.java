package api.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserListPojo {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserDataPojo> data;
    SupportPojo support;
}
