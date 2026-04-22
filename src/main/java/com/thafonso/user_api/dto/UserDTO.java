package com.thafonso.user_api.dto;

import com.thafonso.user_api.entities.User;
import com.thafonso.user_api.validations.CpfValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.Instant;

public class UserDTO {

    private Long id;

    @NotBlank(message = "You need to put an username")
    private String username;

    @NotBlank(message = "You need to put an email")
    @Email(message = "invalid format")
    private String email;

    @CpfValid
    private String cpf;

    @Past(message = "the birthdate cant be in the future")
    private Instant birthdate;

    public UserDTO(User user) {
        id = user.getId();
        username = user.getUsername();
        email = user.getEmail();
        cpf = user.getCpf();
        birthdate = user.getBirthdate();
    }

    public UserDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Instant getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Instant birthdate) {
        this.birthdate = birthdate;
    }
}
