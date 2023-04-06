package miu.edu.wwalab1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue
    long id;
    String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    List<Post> posts;

}
