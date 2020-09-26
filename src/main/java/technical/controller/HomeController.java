package technical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technical.model.Post;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getAllPosts(Model model){

        ArrayList<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setTitle("Post 1");
        post.setBody("Body 1");
        post.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setBody("Body 2");
        post2.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Post 3");
        post3.setBody("Body 3");
        post3.setDate(new Date());

        posts.add(post);
        posts.add(post2);
        posts.add(post3);

        model.addAttribute("posts", posts);
        return "index";
    }
}
