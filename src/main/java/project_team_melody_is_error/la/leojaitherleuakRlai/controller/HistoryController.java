package project_team_melody_is_error.la.leojaitherleuakRlai.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.History;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Result;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.AccountRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.HistoryRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.ResultRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.service.AccountService;
import project_team_melody_is_error.la.leojaitherleuakRlai.service.HistoryService;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    private HistoryRepository historyRepository;

    @Autowired
    private AccountService accountService;
    private AccountRepository accountRepository;

    @Autowired
    private ResultRepository resultRepository;




//____________________________________________เพิ่มข้อมูลประวัติการใช้งาน___________________________________________________________________
//    @PostMapping("/post")
//    public ResponseEntity<History> saveHistory(@RequestBody History history) {
//        History savedHistory = historyService.saveHistory(history);
//        return new ResponseEntity<>(savedHistory, HttpStatus.CREATED);
//
//    }

    @PostMapping("/post")
    public ResponseEntity<String> createHistory(@RequestBody History history) {
        return historyService.createHistory(history);
    }
//______________________________________________________________________________________________________________________


    //    ________________________________________________________ดึงข้อมูลประวัติการใช้งานทั้งหมด____________________________________________
    @GetMapping("/")
    public List<History> getAllHistory() {
        return historyService.getAllHistory();
    }

//    ______________________________________________________________________________________________________________________


//_________________________________________ดึงข้อมูลประวัติการใช้งานตาม id__________________________________________



//    @GetMapping("/{id}")
//    public ResponseEntity<History> getHistoryById(@PathVariable Long id) {
//        History history = historyService.getHistoryById(id);
//        if (history != null) {
//            return ResponseEntity.ok(history);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHistoryById(@PathVariable Long id) {
        try {
            History history = historyService.getHistoryById(id);
            return ResponseEntity.ok(history);
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
        }
    }
//    ___________________________________________________________________________________________________________________


//_______________________________________ อัพเดตข้อมูลประวัติการใช้งาน__ยังใช้ไม่ได้___________________________________________________________


    @PutMapping("/{id}")
    public ResponseEntity<History> updateHistory(@PathVariable(value = "id") Long historyId,
                                                 @RequestBody History historyDetails) {
        History history = historyRepository.findById(historyId).orElse(null);
        if (history == null) {
            return ResponseEntity.notFound().build();
        }
        history.setDate(historyDetails.getDate());
        history.setTime(historyDetails.getTime());
        history.setAccount(historyDetails.getAccount());
        history.setResult(historyDetails.getResult());

        History updatedHistory = historyRepository.save(history);
        return ResponseEntity.ok(updatedHistory);
    }

//_______________________________________ลบข้อมูลประวัติการใช้งาน_______________________________________________________________


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHistory(@PathVariable(value = "id") Long historyId) {
        return historyService.deleteHistory(historyId);
    }

//________________________________________________________________________________________________________________________


}