package project_team_melody_is_error.la.leojaitherleuakRlai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Choice;

import java.util.Optional;
import java.util.Scanner;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice,Integer> {





    Optional<Choice> findById(Integer Id);
}
