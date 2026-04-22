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
        user.setId(userdto.getId());
        user.setUsername(userdto.getUsername());
        user.setEmail(userdto.getEmail());
        user.setCpf(userdto.getCpf());
        user.setBirthdate(userdto.getBirthdate());
        return user;
    }

    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (NotFoundException e){
            throw new NotFoundException(id);
        }
    }

    public UserDTO updateUser(Long id, UserDTO userdto) {
        try {
            User updatedUser = userRepository.getReferenceById(id);
            updateData(updatedUser, userdto);
            updatedUser = userRepository.save(updatedUser);
            return new UserDTO(updatedUser);
        } catch (NotFoundException e){
            throw new NotFoundException(id);
        }

    }

    private void updateData(User updatedUser, UserDTO userdto) {
        updatedUser.setUsername(userdto.getUsername());
        updatedUser.setEmail(userdto.getEmail());
        updatedUser.setCpf(userdto.getCpf());
        updatedUser.setBirthdate(userdto.getBirthdate());
    }


}
