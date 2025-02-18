package com.satc.architecture.subscription;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Plan {
    MONTHLY(30),
    ANUAL(365),
    FREE(0);



    private final Integer value;
}
