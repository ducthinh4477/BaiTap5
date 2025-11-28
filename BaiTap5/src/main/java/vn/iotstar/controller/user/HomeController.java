package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.entity.CategoryEntity;
import vn.iotstar.entity.UserEntity;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryService;
import vn.iotstar.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.iotstar.service.VideoService;


@Controller
public class HomeController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("videos", videoService.findAll());
        return "user/home";
    }
}
