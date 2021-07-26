package com.example.demo.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_generator")
    @SequenceGenerator(name = "user_generator",sequenceName = "user_sequence_generator")
    @Min(1)
    private Long id;
    @Column(nullable = false)
    @NotEmpty(message = "Username must not be empty")
    private String username;
    @Column(nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"
            ))
    private Collection<Role> roles = new HashSet<>() {
    };
}
