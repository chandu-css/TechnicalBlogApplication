package technical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technical.model.Post;
import technical.service.PostService;

import java.util.ArrayList;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    public String getUserPost(Model model){
        ArrayList<Post> posts = postService.getOnePost();
        model.addAttribute("posts", posts);

        return "post";
    }

    @RequestMapping("/posts/createpost")
    public String newPost(){
        return "posts/createpost";
    }

    @RequestMapping(value="/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost, Model model){
        ArrayList<Post> posts = postService.createPost(newPost);
        model.addAttribute("posts", posts);
        return "post";
    }
}


