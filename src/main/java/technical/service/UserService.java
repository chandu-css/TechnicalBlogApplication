package technical.service;

import org.springframework.stereotype.Service;
import technical.model.User;

@Service
public class UserService {

    public boolean login(User user){
        if(user.getUserName().equalsIgnoreCase("validUser")){
            return true;
        }
        else{
            return false;
        }

    }
}
