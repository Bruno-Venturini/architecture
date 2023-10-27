package com.satc.architecture.subscription.concrete;

import com.satc.architecture.subscription.Subscription;
import com.satc.architecture.subscription.behaviors.ICancelBehavior;
import com.satc.architecture.subscription.behaviors.IRenewBehavior;

public class TryBuy extends Subscription implements IRenewBehavior, ICancelBehavior {

    public TryBuy(Subscription subscription) {
        super(subscription);
    }

    /**
     * No caso de renew de uma assinatura trybuy sem PaymentInfo, deverá ser cancelado a assinatura
     */
    @Override
    public void performRenew() {
        this.renew();
    }

    @Override
    public void renew() {
        this.performCancel();
    }
}
