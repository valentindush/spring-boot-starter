package com.dush.springsec.dto;

import com.dush.springsec.enums.Gender;
import com.dush.springsec.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Fistname is required")
    @Size(min = 2, max = 50, message = "The length of name must be between 2 and 50 characters.")
    private String firstname;

    @NotBlank(message = "Lastname is required")
    @Size(min = 2, max = 50, message = "The length of name must be between 2 and 50 characters.")
    private String lastname;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid email", flags = {Flag.CASE_INSENSITIVE})
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
    message = "Password must be at least 8 characters long, contain at least one lowercase letter, one uppercase letter, one digit, and one special character")
    private String password;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "\\d{10,13}", message = "Invalid mobile number")
    private String mobileNumber;

    @NotBlank(message = "Gender is required")
    private Gender gender;

    @NotBlank(message = "Role is required")
    @Enumerated(EnumType.STRING)
    private Role role;
}
