package vn.iotstar.bt5.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private String username;

    private String password;
    private String phone;
    private String fullname;
    private String email;
    private Boolean admin;
    private Boolean active;
    private String images;

    @OneToMany(mappedBy = "user")
    private List<CategoryEntity> categories;

}
