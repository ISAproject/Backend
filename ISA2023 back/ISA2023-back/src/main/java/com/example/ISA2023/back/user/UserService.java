package com.example.ISA2023.back.user;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UserService {
    private final IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public User save(User user){
        return userRepository.save(user);
    }
    public User update(Long id,User updatedUser){
        Optional<User> optionalUser= userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            modelMapper.map(updatedUser, user);
            userRepository.save(user);
            return user;
        }

        return null;
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    
    public List<User> getCompanyAdministrators(){
        return userRepository.getCompanyAdministrators();
    }
}
