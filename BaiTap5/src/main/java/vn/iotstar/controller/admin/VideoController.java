
package vn.iotstar.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iotstar.entity.VideoEntity;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.VideoService;


@Controller
@RequestMapping("/admin/videos")
public class VideoController {

    @Autowired
    VideoService videoService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("items", videoService.findAll());
        return "admin/video/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("video", new VideoEntity());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/video/add";
    }

    @PostMapping("/add")
    public String add(VideoEntity v, @RequestParam("cateId") Integer cateId) {
        v.setCategory(categoryService.findById(cateId));
        videoService.save(v);
        return "redirect:/admin/videos/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("video", videoService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "admin/video/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, VideoEntity v,
                       @RequestParam("cateId") Integer cateId) {
        v.setId(id);
        v.setCategory(categoryService.findById(cateId));
        videoService.save(v);
        return "redirect:/admin/videos/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        videoService.deleteById(id);
        return "redirect:/admin/videos/list";
    }
}
