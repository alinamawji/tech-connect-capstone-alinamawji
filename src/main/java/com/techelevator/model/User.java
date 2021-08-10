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
    private String first_name;

    @NotBlank(message = "Last name is required")
    private String last_name;

    @NotBlank(message = "Username is required")
    private String username;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;
    private String confirm_email;

    @AssertTrue(message = "Emails must match")
    public boolean isEmailMatching() {
        if (email != null) {
            return email.equals(confirm_email);
        }
        return true;
    }

    @NotBlank(message = "Role is required")

    private long user_id;
    private String role;

    @Size(min = 6, message = "Password must be at least 6 characters")
    @NotBlank(message = "Password is required")
    private String password;
    private String confirm_password;

    private boolean passwordMatching;

    @AssertTrue(message = "Passwords must match")
    public boolean isPasswordMatching() {
        if (password != null) {
            return password.equals(confirm_password);
        }
        return true;
    }

    //
    // GET METHODS
    //
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getConfirmEmail() {
        return confirm_email;
    }
    public String getPassword() {
        return password;
    }
    public String getConfirmPassword() {
        return confirm_password;
    }
    public long getId() {
        return user_id;
    }
    public String getRole() {
        return role;
    }

    //
    // SET METHODS
    //
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setConfirm_email(String confirm_email) {
        this.confirm_email = confirm_email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
    public void setId(long user_id) {
        this.user_id = user_id;
    }
    public void setRole(String role) {
        this.role = role;
    }
}

