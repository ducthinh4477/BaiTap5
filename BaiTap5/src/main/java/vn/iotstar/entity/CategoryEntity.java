package vn.iotstar.bt5.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;
    private String categoryCode;
    private String images;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "username")
    private UserEntity user;   // 1 user - nhiều category

    @OneToMany(mappedBy = "category")
    private List<VideoEntity> videos;

    // getter, setter
}
