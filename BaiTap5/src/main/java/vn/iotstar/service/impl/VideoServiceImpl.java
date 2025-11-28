package vn.iotstar.service.impl;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository repo;

    @Override
    public List<VideoEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public VideoEntity findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public VideoEntity save(VideoEntity video) {
        return repo.save(video);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<VideoEntity> search(String keyword) {
        return repo.findByTitleContaining(keyword);
    }
}
