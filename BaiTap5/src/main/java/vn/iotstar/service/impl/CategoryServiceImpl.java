package vn.iotstar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.entity.CategoryEntity;
import vn.iotstar.repository.ICategoryRepository;
import vn.iotstar.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repo;

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
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
