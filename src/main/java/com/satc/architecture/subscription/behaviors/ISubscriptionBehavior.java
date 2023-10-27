package com.satc.architecture.subscription.behaviors;

import com.satc.architecture.subscription.ISubscription;
import com.satc.architecture.subscription.Plan;

public interface ISubscriptionBehavior {
    ISubscription subscription(Long idAccount, Plan plan);
}
