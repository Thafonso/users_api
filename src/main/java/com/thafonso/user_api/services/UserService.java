package com.thafonso.user_api.services;

import com.thafonso.user_api.dto.UserDTO;
import com.thafonso.user_api.entities.User;
import com.thafonso.user_api.exceptions.NotFoundException;
import com.thafonso.user_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return new UserDTO(user);
    }

    public UserDTO insertUser(UserDTO userdto){
        User user = fromDTO(userdto);
        user =  userRepository.save(user);
        return new UserDTO(user);
    }

    // convertion method
    public User fromDTO(UserDTO userdto) {
        User user = new User();
        userdto.setId(userdto.getId());
        user.setUsername(userdto.getUsername());
        user.setEmail(userdto.getEmail());
        user.setCpf(userdto.getCpf());
        user.setBirthdate(userdto.getBirthdate());
        return user;
    }

    public void deleteUser(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        User updatedUser = userRepository.getReferenceById(user.getId());
        updateData(updatedUser, user);
        return userRepository.save(updatedUser);
    }

    private void updateData(User updatedUser, User user) {
        updatedUser.setUsername(user.getUsername());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setCpf(user.getCpf());
        updatedUser.setBirthdate(user.getBirthdate());
    }


}
