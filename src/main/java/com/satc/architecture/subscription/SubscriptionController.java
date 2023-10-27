package com.satc.architecture.subscription;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @PostMapping
    @RequestMapping("/create-subscription")
    public ResponseEntity createSubscription(
            @Valid @RequestBody SubscriptionRepresentation.CreateSubscription createSubscription
        ) {

        this.subscriptionService.createNewSubscription(createSubscription);

        return ResponseEntity.ok().build();
    }
}
