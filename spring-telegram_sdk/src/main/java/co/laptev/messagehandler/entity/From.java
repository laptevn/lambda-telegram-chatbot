package co.laptev.messagehandler.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class From {
    private long id;
    private String username;
    private String first_name;
    private String last_name;
}