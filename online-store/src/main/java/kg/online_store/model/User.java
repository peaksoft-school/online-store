package kg.online_store.model;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
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
@ApiModel(description = "Пользователь",value = "User ")
//@Schema(description = "Пользователь")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    Long id;

    @Schema(description = "username", example = "almazbekov25")
    @NotEmpty
    @Size(min = 3,max = 15,message = "username should have at least 2 characters")
    @Column(name = "username")
    String username;

    @Schema(description = "фамилия", example = "алмазбеков")

    @NotEmpty
    @Size(min = 3,max = 15,message = " lastname should have at least 2 characters")
    @Column(name = "last_name")
    String lastName;

    @Schema(description = "пол", example = "MALE")
    @Column(name = "gender")
    String gender;

    @Schema(description = "email", example = "03aid@gmail.com")
    @NotEmpty
    @Email(message = "email should be valid")
    @Size(min = 5, message = " email should have at least 2 characters")
    @Column(name = "email")
    String email;

    @Schema(description = "пароль", example = "password")
    @NotEmpty
    @Size(min = 8, message = "password should have at least 2 characters")
    @Column(name = "password")
    String password;

    @Schema(description = "номер телефона", example = "+996709888777")
    @Size(min = 10, max = 10)
    @Column(name = "phone_number")
    String phoneNumber;

    @Schema(description = "фото профиля", example = "ссылка'")
    @Column(name = "profile_picture")
    String profilePicture = "";

    @Schema(description = "дата регистрации", example = "2021-07-31")
    @Column(name = "register_date")
    LocalDate registerDate;

    @Schema(description = "дата рождения", example = "2000-07-31")
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