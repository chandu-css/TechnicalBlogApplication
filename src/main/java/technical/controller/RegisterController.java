package technical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technical.model.Post;

import java.util.ArrayList;

@Controller
public class RegisterController {

    @RequestMapping("/registration")
    public String getUserPost(Model model){

        return "registered";
    }
}
