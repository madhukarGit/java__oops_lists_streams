package com.oops.revisited.domain;

import java.time.LocalDate;

/*
* Composition
* */
public interface FlyerPilot {
    int commercialFlyingHours();

    String licence();

    String agency();

    LocalDate dateOfLicenceAchieved();
}
