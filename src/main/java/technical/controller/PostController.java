package technical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import technical.model.Category;
import technical.model.Post;
import technical.model.User;
import technical.service.PostService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    public String getUserPost(Model model){
        List<Post> posts = postService.getAllPosts();
//        Post latestPost = postService.getOnePost();
//        posts.add(latestPost);
        model.addAttribute("posts", posts);

        return "post";
    }

    @RequestMapping("/posts/createpost")
    public String newPost(){
        return "posts/createpost";
    }

    @RequestMapping(value="/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost, HttpSession session){
        User user = (User) session.getAttribute("loggeduser");
        newPost.setUser(user);

        if(newPost.getSpringBlog() != null){
            Category springBlogCategory = new Category();
            springBlogCategory.setCategory(newPost.getSpringBlog());
            newPost.getCategories().add(springBlogCategory);
        }
        if(newPost.getJavaBlog() != null){
            Category javaBlogCategory = new Category();
            javaBlogCategory.setCategory(newPost.getJavaBlog());
            newPost.getCategories().add(javaBlogCategory);
        }

        postService.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.GET)
    public String editPost(@RequestParam(name = "postId") Integer postId, Model model){
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.POST)
    public String editPostSubmit(@RequestParam(name = "postId") Integer postId, Post post, HttpSession session){
        post.setId(postId);
        User user = (User) session.getAttribute("loggeduser");
        post.setUser(user);

        if(post.getSpringBlog() != null){
            Category springBlogCategory = new Category();
            springBlogCategory.setCategory(post.getSpringBlog());
            post.getCategories().add(springBlogCategory);
        }
        if(post.getJavaBlog() != null){
            Category javaBlogCategory = new Category();
            javaBlogCategory.setCategory(post.getJavaBlog());
            post.getCategories().add(javaBlogCategory);
        }
        postService.updatePost(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    public String deletePostSubmit(@RequestParam(name = "postId") Integer postId){
        postService.removePost(postId);
        return "redirect:/posts";
    }
}


