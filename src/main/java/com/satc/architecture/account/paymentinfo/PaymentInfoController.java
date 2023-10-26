package com.satc.architecture.account.paymentinfo;

import com.satc.architecture.account.paymentinfo.creditcard.CreditCardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account/{idAccount}/payment-info")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PaymentInfoController {

    private PaymentInfoService paymentInfoService;
    private PaymentInfoFactory paymentInfoFactory;

    private CreditCardService creditCardService;

    @PostMapping
    @RequestMapping("create")
    public ResponseEntity createPaymentInfo(@PathVariable("idAccount") Long idAccount,
            @Valid @RequestBody PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo) {

        log.info(createPaymentInfo.toString());
        return ResponseEntity.ok().build();
    }
}
