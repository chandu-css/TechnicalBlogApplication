package technical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technical.model.User;
import technical.repository.PostRepository;
import technical.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public User login(User user){
        User existingUser = repository.checkUser(user.getUserName(), user.getPassword());
        if(existingUser != null){
            return existingUser;
        }
        else{
            return null;
        }
    }

    public void userRegister(User newUser){
        repository.registerUser(newUser);
    }
}
