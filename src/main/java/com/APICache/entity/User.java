package com.APICache.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name="User_With-Security2")
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Data
public class User implements Serializable {

    @Id
    private String id;
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role;
}
