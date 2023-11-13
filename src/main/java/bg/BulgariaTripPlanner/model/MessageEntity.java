package bg.BulgariaTripPlanner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "messages")
public class MessageEntity extends BaseEntity {
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Column(columnDefinition = "text")
    private String message;

    public String getName() {
        return name;
    }

    public MessageEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public MessageEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessageEntity setMessage(String message) {
        this.message = message;
        return this;
    }
}
