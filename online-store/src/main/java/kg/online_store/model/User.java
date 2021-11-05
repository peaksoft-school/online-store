package kg.online_store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(description = "Пользователь",value = "User ")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    Long id;

    @Schema(description = "username", example = "almazbekov25")
    @Column(name = "username")
    String username;
    
  
    @Schema(description = "имя", example = "айдар")
    @Column(name = "first_name")
    String firstName;

    @Schema(description = "фамилия", example = "алмазбеков")
    @Column(name = "last_name")
    String lastName;

    @Schema(description = "пол", example = "MALE")
    @Column(name = "gender")
    String gender;

    @Schema(description = "email", example = "03aid@gmail.com")
    @Column(name = "email")
    String email;

    @Schema(description = "пароль", example = "password")
    @Column(name = "password")
    String password;

    @Schema(description = "номер телефона", example = "+996709888777")
    @Column(name = "phone_number")
    String phoneNumber;

    @Schema(description = "фото профиля", example = "ссылка'")
    @Column(name = "profile_picture")
    String profilePicture = "";

    @Schema(description = "дата регистрации", example = "2021-07-31")
    @Column(name = "register_date")
    LocalDate registerDate;

    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    private boolean enabled;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    List<Comment> userComments;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}