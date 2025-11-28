package vn.iotstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iotstar.bt5.entity.VideoEntity;

public interface VideoRepository extends JpaRepository<VideoEntity, Integer> {

}
