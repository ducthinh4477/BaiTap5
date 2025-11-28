package vn.iotstar.bt5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "videos")
public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer videoId;

    private String title;
    private String poster;
    private Integer views;
    private String description;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoryEntity category;   // nhiều video – 1 category

    // getter, setter
}
