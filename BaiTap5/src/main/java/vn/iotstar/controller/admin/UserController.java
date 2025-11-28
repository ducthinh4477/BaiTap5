package vn.iotstar.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.iotstar.entity.UserEntity;
import vn.iotstar.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("items", userService.findAll());
        return "admin/user/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "admin/user/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") UserEntity user) {
        userService.save(user);
        return "redirect:/admin/users/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "admin/user/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,
                       @ModelAttribute("user") UserEntity user) {
        user.setId(id);
        userService.save(user);
        return "redirect:/admin/users/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/admin/users/list";
    }
}
