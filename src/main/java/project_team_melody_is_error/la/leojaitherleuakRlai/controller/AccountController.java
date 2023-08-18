package project_team_melody_is_error.la.leojaitherleuakRlai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;
import project_team_melody_is_error.la.leojaitherleuakRlai.service.AccountService;

import java.util.Map;

public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/account/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) {
        Account account = new Account();
        account.setId(1L);
        return account;
    }
}
