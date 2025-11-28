package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.entity.CategoryEntity;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService cateService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("items", cateService.findAll());
        return "admin/category/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new CategoryEntity());
        model.addAttribute("users", userService.findAll());   // chọn user tạo category
        return "admin/category/add";
    }

    @PostMapping("/save")
    public String save(CategoryEntity cate, @RequestParam("username") String username) {
        UserEntity user = userService.findById(username);
        cate.setUser(user);
        cateService.save(cate);
        return "redirect:/admin/categories/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("item", cateService.findById(id));
        model.addAttribute("users", userService.findAll());
        return "admin/category/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        cateService.delete(id);
        return "redirect:/admin/categories/list";
    }
}
