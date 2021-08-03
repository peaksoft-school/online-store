package kg.online_store.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "username")
    @NotEmpty
    @Size(min = 3,max = 15,message = "username should have at least 2 characters")
    String username;

    @NotEmpty
    @Size(min = 3,max = 15,message = " lastname should have at least 2 characters")
    @Column(name = "last_name")
    String lastName;

    @NotEmpty
    @Column(name = "gender")
    String gender;

    @NotEmpty
    @Email(message = "email should be valid")
    @Size(min = 5, message = " email should have at least 2 characters")
    @Column(name = "email")
    String email;

    @NotEmpty
    @Size(min = 8, message = "password should have at least 2 characters")
    @Column(name = "password")
    String password;


    @NotEmpty
    @Size(min = 10, max = 10)
    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "profile_picture")
    String profilePicture = "";

    @Column(name = "register_date")
    LocalDate registerDate;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "birth_date")
    LocalDate birthDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles;
}