package project_team_melody_is_error.la.leojaitherleuakRlai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Value;
import org.apache.catalina.User;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_history")
    private Long id;

    private Date date;
    private Time time;


    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "id_Result")
    private Result result;


    @OneToMany(mappedBy = "history")
    @JsonIgnore
    private  List<History_Detail>history_details;


    public Long getId_account() {
        return account.getId();
    }

    public void setId_account(Long id_account) {
        Account account = new Account();
        account.setId(id_account);
        this.account = account;
    }

    public Long getId_Result() {
        return result.getId();
    }

    public void setId_Result(Long id_Result) {
        Result result = new Result();
        result.setId(id_Result);
        this.result = result;
    }

    private boolean isDeleted; // เพิ่ม field นี้เพื่อบอกว่าประวัติการใช้งานนี้ถูกลบหรือไม่
}
