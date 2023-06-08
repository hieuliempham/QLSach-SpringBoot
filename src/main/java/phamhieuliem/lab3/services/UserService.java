package phamhieuliem.lab3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phamhieuliem.lab3.entity.User;
import phamhieuliem.lab3.repository.IRoleRepository;
import phamhieuliem.lab3.repository.IUserRepository;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;


    public void save(User user){
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("USER");
        if(userId != 0 && roleId !=0){
            userRepository.addRoleToUser(userId, roleId);
        }
    }
}
