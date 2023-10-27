package com.satc.architecture.subscription;

import com.satc.architecture.account.AccountEntity;
import com.satc.architecture.account.AccountRepository;
import com.satc.architecture.exceptions.BehaviorException;
import com.satc.architecture.subscription.behaviors.ICancelBehavior;
import com.satc.architecture.subscription.behaviors.ISubscriptionBehavior;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "subscription")
public class Subscription implements ISubscription, ISubscriptionBehavior, ICancelBehavior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @Column(name = "plan")
    @Enumerated(EnumType.STRING)
    private Plan plan;

    @Column(name = "subscription_date")
    private LocalDate subscriptionDate;

    @Column(name = "renew_date")
    private LocalDate renewDate;

    @Column(name = "cancel_date")
    private LocalDate cancelDate;

    @Column(name = "subscription_status")
    private Boolean subscriptionStatus;

    @Column(name = "subscription_type")
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;

    public Subscription(Subscription subscription) {
        this.id = subscription.id;
        this.account = subscription.account;
        this.plan = subscription.plan;
        this.subscriptionDate = subscription.subscriptionDate;
        this.renewDate = subscription.renewDate;
        this.cancelDate = subscription.cancelDate;
        this.subscriptionStatus = subscription.subscriptionStatus;
        this.subscriptionType = subscription.subscriptionType;
    }

    public Subscription(SubscriptionRepresentation.CreateSubscription createSubscription, AccountEntity accountEntity) {
        this.subscriptionStatus = true;
        this.account = accountEntity;
        this.subscriptionDate = LocalDate.now();
        this.plan = Plan.FREE;
        this.subscriptionStatus = Boolean.TRUE;
    }

    @Override
    public void performCancel() {
        this.cancel();
    }

    @Override
    public void performCharge() {
        throw new BehaviorException("Assinatura do tipo FREE, não contem charge");
    }

    @Override
    public void performRenew() {
        throw new BehaviorException("Assinatura do tipo FREE, não contem renewDate");
    }

    @Override
    public ISubscription performSubscribe(Long idAccount, Plan plan) {
        return this.subscription(idAccount, plan);
    }

    @Override
    public ISubscription subscription(Long idAccount, Plan plan) {
        Subscription subscription = new Subscription();

        AccountEntity account = new AccountEntity();
        account.setId(idAccount);

        subscription.setSubscriptionStatus(Boolean.TRUE);
        subscription.setAccount(account);
        subscription.setPlan(plan);
        subscription.setSubscriptionDate(LocalDate.now());
        return subscription;
    }

    @Override
    public void cancel() {
        this.cancelDate = LocalDate.now();
        this.subscriptionStatus = Boolean.FALSE;
    }

}
