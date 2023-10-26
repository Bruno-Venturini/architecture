package com.satc.architecture.account.paymentinfo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public interface PaymentInfoRepresentation {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CreatePaymentInfo {

        @NotNull
        private PaymentType paymentType;

        @Valid
        private CreateCreditCardInfo creditCard;

        @Valid
        private CreateBankSlipInfo bankSlip;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CreateCreditCardInfo {

        @NotNull
        @NotEmpty
        private String cardHolder;

        @NotNull
        @NotEmpty
        private String cardNumber;

        @NotNull
        @NotEmpty
        private String cardCvv;

        @NotNull
        private LocalDate expirationDate;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CreateBankSlipInfo {
        @NotNull
        @NotEmpty
        private String name;

        @NotNull
        @NotEmpty
        private String email;

        @NotNull
        @NotEmpty
        private String document;
    }

}
