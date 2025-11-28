package vn.iotstar.bt5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iotstar.bt5.entity.VideoEntity;
import java.util.List;

public interface VideoRepository extends JpaRepository<VideoEntity, Integer> {
    // phục vụ tìm kiếm video theo title
    List<VideoEntity> findByTitleContaining(String keyword);
}
