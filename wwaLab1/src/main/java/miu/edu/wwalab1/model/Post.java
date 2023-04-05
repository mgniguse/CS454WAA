package miu.edu.wwalab1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Post {
    @Id
    @GeneratedValue
    long id;
    String title;
    String content;
    String author;

}
