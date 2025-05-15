package com.synchrotech.lac_datamanagement.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synchrotech.lac_datamanagement.exception.UserException;
import com.synchrotech.lac_datamanagement.models.User;
import com.synchrotech.lac_datamanagement.repository.UserRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.ConstraintViolationException;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    private void sendEmail(String recipientEmail, String body, String subject) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromEmail);
        simpleMailMessage.setTo(recipientEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
    }

    private String generateOtp() {
        Random random = new Random();
        int randomNum = random.nextInt(999999);
        String otp = Integer.toString(randomNum);
        while (otp.length() < 6) {
            otp = "0" + otp;
        }
        return otp;
    }

    public void loginUser(String email, String password) throws UserException {
        Optional<User> userOptional = userRepo.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            if (!bcrypt.matches(password, user.getPassword())) {
                throw new UserException(UserException.IncorrectPasswordException());
            }
            if (user.getIs_active() == null) {
                throw new UserException(UserException.UserEmailNotVerified());
            }
        } else {
            throw new UserException(UserException.NotFoundException(email));
        }
    }

    public void addUser(User user) throws ConstraintViolationException, UserException {
        Optional<User> userOptional = userRepo.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new UserException(UserException.UserAlreadyExistsException());
        } else {
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            String encryptedPassword = bcrypt.encode(user.getPassword());
            user.setPassword(encryptedPassword);
            String otp = generateOtp();
            user.setOtp(otp);
            user.setOtp_expiry_time(LocalDateTime.now().plus(Duration.ofMinutes(5)));
            userRepo.save(user);
            sendEmail(user.getEmail(),
                    "Your OTP to verify your emails is " + otp + ". This OTP is valid for only 5 minutes.",
                    "Verify Email");
        }
    }

    public List<User> getUsers() {
        List<User> users = userRepo.findAll();
        if (users.size() > 0) {
            return users;
        } else {
            return new ArrayList<User>();
        }
    }

    public User getUserById(String id) throws UserException {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UserException(UserException.NotFoundException(id));
        }
    }

    public void updateUser(String id, User updatedUser) throws UserException {
        Optional<User> userToBeUpdated = userRepo.findById(id);
        Optional<User> userWithSameEmail = userRepo.findByEmail(updatedUser.getEmail());
        if (userToBeUpdated.isPresent()) {
            if (userWithSameEmail.isPresent() && !userWithSameEmail.get().getUser_id().equals(id)) {
                throw new UserException(UserException.UserAlreadyExistsException());
            }
            User user = userToBeUpdated.get();
            user.setName(updatedUser.getName() != null ? updatedUser.getName() : user.getName());
            user.setEmail(updatedUser.getEmail() != null ? updatedUser.getEmail() : user.getEmail());
            user.setPhone(updatedUser.getPhone() != null ? updatedUser.getPhone() : user.getPhone());
            user.setCid(updatedUser.getCid() != null ? updatedUser.getCid() : user.getCid());
            user.setDob(updatedUser.getDob() != null ? updatedUser.getDob() : user.getDob());
            user.setGender(updatedUser.getGender() != null ? updatedUser.getGender() : user.getGender());
            user.setPassword(updatedUser.getPassword() != null ? updatedUser.getPassword() : user.getPassword());
            user.setLawyerType(
                    updatedUser.getLawyerType() != null ? updatedUser.getLawyerType() : user.getLawyerType());
            user.setLocation(updatedUser.getLocation() != null ? updatedUser.getLocation() : user.getLocation());
            user.setSpecialization(updatedUser.getSpecialization() != null ? updatedUser.getSpecialization()
                    : user.getSpecialization());
            user.setRole(updatedUser.getRole() != null ? updatedUser.getRole() : user.getRole());
            userRepo.save(user);
        } else {
            throw new UserException(UserException.NotFoundException(id));
        }
    }

    public void deleteUser(String id) throws UserException {
        Optional<User> userOptional = userRepo.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserException(UserException.NotFoundException(id));
        } else {
            userRepo.deleteById(id);
        }
    }
}
