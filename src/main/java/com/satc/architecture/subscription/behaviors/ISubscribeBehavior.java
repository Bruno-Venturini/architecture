package com.satc.architecture.subscription.behaviors;

import com.satc.architecture.subscription.Plan;

public interface ISubscribeBehavior {
    void performSubscribe(Long idAccount, Plan plan);
}
