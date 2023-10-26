package com.satc.architecture.account.paymentinfo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class PaymentInfoEntity {

    @Id
    private Long id;
    @NotNull
    private PaymentType paymentType;

    private CreditCardEntity creditCard;

    private BankSlipEntity bankSlip;

}
