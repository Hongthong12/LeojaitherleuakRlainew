package project_team_melody_is_error.la.leojaitherleuakRlai.model;

import lombok.Data;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Result;

@Data
public class ChoiceModel {

    private Integer id;
    private String choiceEng;
    private String choiceThai;
    private String nameChoice;
    private String nameEng;
    private Result result;
}
