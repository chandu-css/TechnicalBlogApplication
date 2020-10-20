package technical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technical.model.Post;
import technical.model.Registration;
import technical.model.User;
import technical.model.UserProfile;
import technical.service.PostService;
import technical.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PostService postservice;

    @Autowired
    private UserService userservice;

    @RequestMapping("/users/login")
    public String login(){
        return "users/login";
    }

    @RequestMapping("/users/registration")
    public String registration(Model model){
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);
        model.addAttribute("User", user);
        return "users/registration";
    }

    @RequestMapping(value = "/users/login", method= RequestMethod.POST)
    public String userLogin(User user, HttpSession session) {
        User existingUser = userservice.login(user);
        if(existingUser != null) {
            session.setAttribute("loggeduser", existingUser);
            return "redirect:/posts";
        }
        else {
            return "users/login";
        }
    }

    @RequestMapping(value="/users/registration", method = RequestMethod.POST)
    public String userRegistration(User newUser){
        userservice.userRegister(newUser);
        return "redirect:/users/login";
    }

    @RequestMapping(value ="/users/logout", method = RequestMethod.POST)
    public String logout(Model model, HttpSession session){
        session.invalidate();
        List<Post> posts = postservice.getAllPosts();

        model.addAttribute("posts", posts);
        return "index";
    }

}
