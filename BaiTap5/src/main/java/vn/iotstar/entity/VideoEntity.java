package vn.iotstar.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "videos")
@Data @AllArgsConstructor @NoArgsConstructor
public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String poster;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
