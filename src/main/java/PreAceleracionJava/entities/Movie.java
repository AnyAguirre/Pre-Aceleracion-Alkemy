package PreAceleracionJava.entities;
import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;


@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String image; 
    
    private String title;
    
    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime creationDate;
        
    private Integer score;
    
    private boolean deleted = Boolean.FALSE;
    
    @ManyToMany(mappedBy = "movies")
    private Set<Character> characters = new HashSet<>();

    
    //NOMBRE DE LA TABLA INTERMEDIA
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @ManyToMany
    private Set<Genre> genres = new HashSet<>();
}