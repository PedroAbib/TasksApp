package com.example.tasksApp.domain.tasks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotEmpty(message = "Campo não pode estar vazio")
    private String name;

    private boolean isChecked;

    // This constructor transforms the TaskRecord into a Task
    public Task(TaskRecord taskDTO) {
        this.name = taskDTO.name();
    }
}
