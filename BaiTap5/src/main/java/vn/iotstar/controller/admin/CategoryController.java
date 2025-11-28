package vn.iotstar.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iotstar.entity.CategoryEntity;
import vn.iotstar.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // LIST
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("items", categoryService.findAll());
        return "admin/category/list";
    }

    // ADD FORM
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("cate", new CategoryEntity());
        return "admin/category/add";
    }

    // ADD
    @PostMapping("/add")
    public String add(@ModelAttribute("cate") CategoryEntity cate) {
        categoryService.save(cate);
        return "redirect:/admin/categories/list";
    }

    // EDIT FORM
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cate", categoryService.findById(id));
        return "admin/category/edit";
    }

    // UPDATE
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,
                       @ModelAttribute("cate") CategoryEntity cate) {
        cate.setId(id);
        categoryService.save(cate);
        return "redirect:/admin/categories/list";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        categoryService.deleteById(id);
        return "redirect:/admin/categories/list";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("cate") CategoryEntity cate,
                      @RequestParam("imageFile") MultipartFile imageFile,
                      HttpServletRequest request) {

        String uploadDir = request.getServletContext().getRealPath("/uploads/category/");

        String savedFile = FileUploadUtil.saveFile(uploadDir, imageFile);
        cate.setImages(savedFile);

        categoryService.save(cate);
        return "redirect:/admin/categories/list";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id,
                       @ModelAttribute("cate") CategoryEntity cate,
                       @RequestParam("imageFile") MultipartFile imageFile,
                       HttpServletRequest request) {

        CategoryEntity old = categoryService.findById(id);

        String uploadDir = request.getServletContext().getRealPath("/uploads/category/");

        if (!imageFile.isEmpty()) {
            String saved = FileUploadUtil.saveFile(uploadDir, imageFile);
            cate.setImages(saved);
        } else {
            cate.setImages(old.getImages());
        }

        cate.setId(id);
        categoryService.save(cate);
        return "redirect:/admin/categories/list";
    }

}
