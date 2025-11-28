package vn.iotstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iotstar.bt5.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
