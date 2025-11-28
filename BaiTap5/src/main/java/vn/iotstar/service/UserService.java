package vn.iotstar.service;

import java.util.List;

import vn.iotstar.entity.UserEntity;
import vn.iotstar.repository.impl.UserRepository;

public interface UserService {
    List<UserEntity> findAll();
    UserEntity findById(String username);
    UserEntity save(UserEntity user);
    void delete(String username);
}

