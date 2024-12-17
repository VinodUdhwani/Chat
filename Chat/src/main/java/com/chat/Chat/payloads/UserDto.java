package com.chat.Chat.payloads;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public class UserDto {

    private int id;
    @NotEmpty
    private String username;
    @Email
    private String email;
    @NotEmpty
    @NotNull
    @Length(min = 4)
    @Pattern(regexp ="[a-zA-Z0-9]*[^a-zA-Z0-9]? " )
    private String password;
    @NotBlank
    private String bio;

    public UserDto(String username, String password, int id, String email, String bio) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.email = email;
        this.bio = bio;
    }

    public UserDto(){
        super();
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
