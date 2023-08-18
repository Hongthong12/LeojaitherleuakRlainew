package project_team_melody_is_error.la.leojaitherleuakRlai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category;
    private String category_eng;

    @OneToMany(mappedBy = "result")
    @JsonIgnore
    private List<Choice> choice;

    @OneToMany(mappedBy = "result")
    @JsonIgnore
    private List<History>histories;
}
