package com.techelevator.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * User
 */
public class User {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Username is required")
    private String username;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;
    private String confirmEmail;

    @AssertTrue(message = "Emails must match")
    public boolean isEmailMatching() {
        if (email != null) {
            return email.equals(confirmEmail);
        }
        return true;
    }



    private Long userId;
    private String role;

    @Size(min = 6, message = "Password must be at least 6 characters")
    @NotBlank(message = "Password is required")
    private String password;
    private String confirmPassword;

    private boolean passwordMatching;

    @AssertTrue(message = "Passwords must match")
    public boolean isPasswordMatching() {
        if (password != null) {
            return password.equals(confirmPassword);
        }
        return true;
    }

    //
    // GET METHODS
    //
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getConfirmEmail() {
        return confirmEmail;
    }
    public String getPassword() {
        return password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public long getId() {return userId;}
    public String getRole() {
        return role;
    }

    //
    // SET METHODS
    //
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public void setId(Long userId) {this.userId = userId;}
    public void setRole(String role) {
        this.role = role;
    }
}