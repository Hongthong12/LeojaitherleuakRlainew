package project_team_melody_is_error.la.leojaitherleuakRlai.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "historyDetail")
public class History_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_historyDetail")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_history")
    private History history;

    @ManyToOne
    @JoinColumn(name = "id_Choice")
    private Choice choice;
}