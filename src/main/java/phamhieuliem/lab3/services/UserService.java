package phamhieuliem.lab3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phamhieuliem.lab3.entity.User;
import phamhieuliem.lab3.repository.IUserRepository;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }
}
