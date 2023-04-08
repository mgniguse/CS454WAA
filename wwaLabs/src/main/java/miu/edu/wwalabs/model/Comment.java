package miu.edu.wwalabs.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Comment {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    List<Comment> comments;

}
