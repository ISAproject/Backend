package com.example.ISA2023.back.user;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Optional;
import java.util.List;

@Service
public class UserService {
    private final IUserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void sendVerificationEmail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Account Verification");
        message.setText("Dear " + user.getFirst_name() + ",\n\n"
                + "Thank you for joining us. Please click on the following link to verify your account: "
                + "http://localhost:8090/api/v1/user/verify/" + user.getId());

        javaMailSender.send(message);
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
    public User getLastUser()
    {
        return userRepository.getLastUser();
    }
}
