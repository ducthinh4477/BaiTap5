package vn.iotstar.controller.admin;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("items", service.findAll());
        return "admin/user/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new UserEntity());
        return "admin/user/add";
    }

    @PostMapping("/save")
    public String save(UserEntity user) {
        service.save(user);
        return "redirect:/admin/users/list";
    }

    @GetMapping("/edit/{username}")
    public String edit(@PathVariable String username, Model model) {
        model.addAttribute("item", service.findById(username));
        return "admin/user/edit";
    }

    @GetMapping("/delete/{username}")
    public String delete(@PathVariable String username) {
        service.delete(username);
        return "redirect:/admin/users/list";
    }
}
