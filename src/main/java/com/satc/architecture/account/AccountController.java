package com.satc.architecture.account;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("account")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;
    private AccountRepository accountRepository;

    @PostMapping
    @RequestMapping("new-account")
    public ResponseEntity createNewAccount(
             @RequestBody @Valid AccountRepresentation.CreateAccount newAccount) {

        this.accountService.validateBusiness(accountRepository, newAccount);
        this.accountService.createAccount(accountRepository, newAccount);

        return ResponseEntity.ok().build();
    }
}
