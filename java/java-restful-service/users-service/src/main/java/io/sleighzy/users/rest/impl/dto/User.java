package io.sleighzy.users.rest.impl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String name;
    private String email;
    private String role;

    public User(final String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
