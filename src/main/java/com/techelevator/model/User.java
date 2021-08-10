package com.techelevator.model;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * User
 */
public class User {
    private long user_id;

    private String role;

    @NotBlank(message = "Username is required")
    private String username;

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

    @NotBlank(message = "First name is required")
    private String first_name;

    @NotBlank(message = "Last name is required")
    private String last_name;

    @NotBlank(message = "Email name is required")
    @Email(message = "Please enter a valid email address")
    private String email;

    //
    // GET METHODS
    //

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }


    /**
     * @return the id
     */
    public long getUser_id() {
        return user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    //
    // SET METHODS
    //

    /**
     * @param user_id the id to set
     */
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

