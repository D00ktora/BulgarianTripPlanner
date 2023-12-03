package bg.BulgariaTripPlanner.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "confirmation_token")
public class ConfirmationToken extends BaseEntity {
    @Column(name="confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private UserEntity user;

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public ConfirmationToken() {
    }

    public ConfirmationToken(String confirmationToken, Date createdDate) {
        this.confirmationToken = confirmationToken;
        this.createdDate = createdDate;
    }

    public ConfirmationToken(UserEntity user) {
        this.user = user;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }

    public ConfirmationToken setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public ConfirmationToken setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ConfirmationToken setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
