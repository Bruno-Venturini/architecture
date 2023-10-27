package com.satc.architecture.subscription;

import com.satc.architecture.account.AccountEntity;
import com.satc.architecture.account.AccountRepository;

import java.util.Optional;

public class SubscriptionService {

    private AccountRepository accountRepository;
    public void createNewSubscription(SubscriptionRepresentation.CreateSubscription createSubscription) {
        Optional<AccountEntity> account = this.accountRepository.findById(createSubscription.getIdAccount());

        if (account.isEmpty()) return;

        Subscription newSub = new Subscription(createSubscription, account.get());

    }
}
