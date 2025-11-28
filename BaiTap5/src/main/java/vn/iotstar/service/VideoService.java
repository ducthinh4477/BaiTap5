package vn.iotstar.service;

public interface VideoService {
    List<VideoEntity> findAll();
    VideoEntity findById(Integer id);
    VideoEntity save(VideoEntity video);
    void delete(Integer id);
    List<VideoEntity> search(String keyword);
}
