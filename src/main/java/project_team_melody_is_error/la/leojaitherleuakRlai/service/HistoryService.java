package project_team_melody_is_error.la.leojaitherleuakRlai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.History;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Result;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.AccountRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.HistoryRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.ResultRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ResultRepository resultRepository;

//_______________________________________CreateHistory___________________________________________________________
    public ResponseEntity<String> createHistory(History history) {
        Account account = accountRepository.findById(history.getId_account()).orElse(null);
        Result result = resultRepository.findById(history.getId_Result()).orElse(null);
        if (account != null && result != null) {
            history.setAccount(account);
            history.setResult(result);
            History savedHistory = historyRepository.save(history);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("invalid account or result ID", HttpStatus.BAD_REQUEST);
        }
    }
    public History saveHistory(History history) {
        return historyRepository.save(history);
    }

//    __________________________________________________________________________________________________________________


//    _________________________________ดึงข้อมูลประวัติการใช้งานทั้งหมด____________________________________
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

//  _____________________________________________________________________________________________________________________

//    ________________________________ดึงข้อมูลประวัติการใช้งานตาม id_____________________________________________________________

//    public History getHistoryById(Long id) {
//    return historyRepository.findById(id).orElse(null);
//}

    public History getHistoryById(Long id) {
        Optional<History> optionalHistory = historyRepository.findById(id);
        if (optionalHistory.isPresent()) {
            History history = optionalHistory.get();
            if (history.isDeleted()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This ID has been deleted.");
            }
            return history;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This ID does not exist.");
        }
    }
//________________________________________________________________________________________________________________________


//    ________________________________ลบข้อมูลประวัติการใช้งาน___________________________________________________________________

    public ResponseEntity<String> deleteHistory(Long historyId) {
        historyRepository.deleteById(historyId);
        return new ResponseEntity<>("History has been deleted successfully.", HttpStatus.OK);
    }

//    ____________________________________________________________________________________________________________________
}
