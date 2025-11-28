package vn.iotstar.controller.admin;

@Controller
@RequestMapping("/admin/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String list(@RequestParam(value = "keyword", required = false) String keyword,
                       Model model) {
        if (keyword != null && !keyword.isBlank()) {
            model.addAttribute("items", videoService.search(keyword));
            model.addAttribute("keyword", keyword);
        } else {
            model.addAttribute("items", videoService.findAll());
        }
        return "admin/video/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new VideoEntity());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/video/add";
    }

    @PostMapping("/save")
    public String save(VideoEntity video,
                       @RequestParam("categoryId") Integer categoryId) {
        CategoryEntity cate = categoryService.findById(categoryId);
        video.setCategory(cate);
        if (video.getViews() == null) video.setViews(0);
        videoService.save(video);
        return "redirect:/admin/videos/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("item", videoService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "admin/video/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        videoService.delete(id);
        return "redirect:/admin/videos/list";
    }
}
