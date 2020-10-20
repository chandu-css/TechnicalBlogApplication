package technical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technical.model.Post;
import technical.service.PostService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postservice;

    @RequestMapping("/")
    public String getAllPosts(Model model){

        List<Post> posts = postservice.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }
}
