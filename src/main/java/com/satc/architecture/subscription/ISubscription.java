package com.satc.architecture.subscription;

public interface ISubscription {

    void performCancel();
    void performCharge();
    void performRenew();
    void performSubscribe(Long idAccount, Plan plan);

}
