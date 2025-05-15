package com.synchrotech.lac_datamanagement.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.synchrotech.lac_datamanagement.models.Enums.LawyerType;
import com.synchrotech.lac_datamanagement.models.Enums.UserRole;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String user_id;
    @NotNull(message = "name cannot be null")
    private String name;
    private String gender;
    @NotNull(message = "email cannot be null")
    @Indexed(unique = true)
    private String email;
    private String phone;
    private String cid;
    private String dob;
    @NotNull(message = "password cannot be null")
    private String password;
    @NotNull(message = "role cannot be null")
    private UserRole role;
    private String location;
    private String photo; // can be ipfs path if i can't figure how to upload image to server
    private String specialization; // Specialization if the user is a lawyer
    private LawyerType lawyerType; // Lawyer type if applicable
    private String license_id; // License ID for lawyers
    private String permanent_address; // Permanent address
    private String present_address; // Present address
    private Boolean is_active;
    private String otp;
    private LocalDateTime otp_expiry_time;
}