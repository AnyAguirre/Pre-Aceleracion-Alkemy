package PreAceleracionJava.entities;
import java.util.*;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Getter
@Setter
@Entity
@Table(name = "genres")
public class Genre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String image; 
    
    private String name;
    
    private boolean deleted = Boolean.FALSE;
    
    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies = new HashSet<>();
}
