package com.example.ISA2023.back.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final IUserRepository userRepository;

    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    };
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
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
}
