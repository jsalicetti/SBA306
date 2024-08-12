package sba.sms.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * annotations
 */

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@ToString
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "course")


public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    int id;
    @NonNull
    @Column(length = 50, name = "name")
    String name;
    @NonNull
    @Column(length = 50, name="instructor")
    String instructor;

    @ToString.Exclude
    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},fetch = FetchType.EAGER)
    private Set<Student> students = new LinkedHashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id, name, instructor);
    }
}




