package vn.iotstar.service;

import vn.iotstar.entity.UserEntity;
import java.util.List;

public interface UserService {
    List<UserEntity> findAll();
    UserEntity findById(Integer id);
    UserEntity save(UserEntity user);
    void deleteById(Integer id);
}
