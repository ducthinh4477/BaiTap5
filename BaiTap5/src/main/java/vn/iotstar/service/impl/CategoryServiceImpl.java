package vn.iotstar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iotstar.entity.CategoryEntity;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.service.CategoryService;


import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repo;

    @Override
    public List<CategoryEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public CategoryEntity findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public CategoryEntity save(CategoryEntity cate) {
        return repo.save(cate);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
