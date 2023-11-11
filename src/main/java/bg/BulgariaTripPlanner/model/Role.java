package bg.BulgariaTripPlanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    private String role;
    private Roles roleEnum;

    public String getRole() {
        return role;
    }

    public Role setRole(String role) {
        this.role = role;
        return this;
    }

    public Roles getRoleEnum() {
        return roleEnum;
    }

    public Role setRoleEnum(Roles roleEnum) {
        this.roleEnum = roleEnum;
        return this;
    }
}
