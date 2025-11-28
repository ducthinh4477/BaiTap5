package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.entity.UserEntity;
import vn.iotstar.repository.IUserPepository;
import vn.iotstar.repository.impl.UserRepository;
import vn.iotstar.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<UserEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public UserEntity findById(String username) {
        return repo.findById(username).orElse(null);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return repo.save(user);
    }

    @Override
    public void delete(String username) {
        repo.deleteById(username);
    }
}
