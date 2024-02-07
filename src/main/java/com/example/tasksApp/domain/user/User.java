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
    @NotEmpty(message = "Campo nome é obrigatório")
    private String name;
    @NotEmpty(message = "Campo email é obrigatório")
    private String email;
    @NotEmpty(message = "Campo senha é obrigatório")
    private String password;

    public User(UserRecord userDTO) {
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = userDTO.password();
    }
}
