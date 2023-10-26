package com.satc.architecture.account.paymentinfo;

public class PaymentInfoFactory {

    public PaymentInfoEntity getPaymentInfoEntity(
            PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo) {
        return switch (createPaymentInfo.getPaymentType()){
            case CREDIT_CARD -> this.buildCreditCard(createPaymentInfo);
            case BANK_SLIP -> this.buildBankSlit(createPaymentInfo);

        };
    }

    private PaymentInfoEntity buildBankSlit(PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo) {
        return PaymentInfoEntity.builder().build();
    }

    private PaymentInfoEntity buildCreditCard(PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo) {
        return PaymentInfoEntity.builder().build();
    }
}
