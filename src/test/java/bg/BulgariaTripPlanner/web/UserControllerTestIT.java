package bg.BulgariaTripPlanner.web;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTestIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testLoginGet() throws Exception {
        mockMvc.perform (
                MockMvcRequestBuilders.get("/login")
        ).andExpect(status().isOk());
    }

    @Test
    void testUserProfileGet() throws Exception {
        UserDetails userDetails = new User("test", "test", List.of(new SimpleGrantedAuthority("ADMIN")));
        mockMvc.perform(
                MockMvcRequestBuilders.get("/users/profile")
                        .flashAttr("model", Model.class)
                        .flashAttr("userDetails", User.class)
                        .flashAttr("httpSession", HttpSession.class)
        ).andExpect(status().is3xxRedirection());
    }
}
