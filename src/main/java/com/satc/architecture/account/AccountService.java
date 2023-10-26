package com.satc.architecture.account;

import com.satc.architecture.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    /**
     * Method which will validate business's integrity
     * @param newAccount
     */
    public void validateBusiness(AccountRepository repository, AccountRepresentation.CreateAccount newAccount) {
        if(!newAccount.getPassword().equals(newAccount.getPasswordConfirmation())) {
            throw new BusinessException("A senha e a confirmação não são iguais");
        }

        if (repository.existsByEmail(newAccount.getEmail())) {
            throw new BusinessException("Esse email já foi cadastrado.");
        }

        if (repository.existsByUsername(newAccount.getUsername())) {
            throw new BusinessException("Esse username já foi cadastrado.");
        }

        if (repository.existsByDocument(newAccount.getDocument())) {
            throw new BusinessException("Esse documento já foi cadastrado.");
        }
    }


    public AccountEntity createAccount(AccountRepository accountRepository, AccountRepresentation.CreateAccount newAccount) {
        return accountRepository.save(AccountEntity.builder()
                .name(newAccount.getName())
                .username(newAccount.getUsername())
                .password(newAccount.getPassword())
                .document(newAccount.getDocument())
                .email(newAccount.getEmail())
                .build());
    }
}
