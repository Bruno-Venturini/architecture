package com.satc.architecture.account;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface AccountRepresentation {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class CreateAccount {
        @NotNull(message = "O nome não pode ser nulo")
        @NotEmpty(message = "O nome não pode ser nulo")
        private String name;

        @NotNull(message = "O email não pode ser nulo")
        @NotEmpty(message = "O email não pode ser nulo")
        private String email;

        @NotNull(message = "O documento não pode ser nulo")
        @NotEmpty(message = "O documento não pode ser nulo")
        private String document;

        @NotNull(message = "O usuário não pode ser nulo")
        @NotEmpty(message = "O usuário não pode ser nulo")
        private String username;

        @NotNull(message = "A senha não pode ser nulo")
        @NotEmpty(message = "A senha não pode ser nulo")
        private String password;

        @NotNull(message = "A confirmação não pode ser nulo")
        @NotEmpty(message = "A confirmação não pode ser nulo")
        private String passwordConfirmation;
    }
}
