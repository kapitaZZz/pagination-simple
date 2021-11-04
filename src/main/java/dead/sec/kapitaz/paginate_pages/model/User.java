package dead.sec.kapitaz.paginate_pages.model;

import lombok.Data;

import javax.persistence.*;

@Table(name="users")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private Integer age;

    private String email;
}
