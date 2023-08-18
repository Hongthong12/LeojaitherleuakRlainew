package project_team_melody_is_error.la.leojaitherleuakRlai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.AccountRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found."));
    }

//    private Map<String, String> userInfo = new HashMap<>();
//
//    public void saveUserInfo(OAuth2User principal) {
//        userInfo.put("email", principal.getAttribute("email"));
//        userInfo.put("firstname", principal.getAttribute("given_name"));
//        userInfo.put("lastname", principal.getAttribute("family_name"));
//        userInfo.put("birthday", principal.getAttribute("birthday"));
//        userInfo.put("datetime", LocalDateTime.now().toString());
//    }
//
//    public Map<String, String> getUserInfo() {
//        return userInfo;
//    }
}
