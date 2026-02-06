package tacos.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.User;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationRequest {


    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String confirm;

    @NotBlank
    private String fullName;

    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(passwordEncoder.encode(this.password)); // encrypt password!
        user.setFullName(this.fullName);
        user.setStreet(this.street);
        user.setCity(this.city);
        user.setState(this.state);
        user.setZip(this.zip);
        user.setPhone(this.phone);
        return user;
    }

}
