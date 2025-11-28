package vn.iotstar.service;

import java.util.List;

import vn.iotstar.entity.CategoryEntity;


public interface CategoryService {
    List<CategoryEntity> findAll();
    CategoryEntity findById(Integer id);
    CategoryEntity save(CategoryEntity cate);
    void delete(Integer id);
}
