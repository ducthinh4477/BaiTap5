
package vn.iotstar.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iotstar.entity.UserEntity;
import vn.iotstar.repository.UserRepository;
import vn.iotstar.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    public List<UserEntity> findAll() { return repo.findAll(); }
    public UserEntity findById(Integer id) { return repo.findById(id).orElse(null); }
    public UserEntity save(UserEntity user) { return repo.save(user); }
    public void deleteById(Integer id) { repo.deleteById(id); }
}
