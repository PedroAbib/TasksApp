package com.example.tasksApp.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    public User(UserRecord userDTO) {
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = userDTO.password();
    }
}
