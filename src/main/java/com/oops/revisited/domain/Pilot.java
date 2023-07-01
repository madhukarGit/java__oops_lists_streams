package com.oops.revisited.domain;

import java.time.LocalDate;

public record Pilot(int commercialFlyingHours, String licence, String agency, LocalDate dateOfLicenceAchieved) implements FlyerPilot {
    @Override
    public String toString() {
        return String.format("flying hours: %s, licence:  %s,agency: %s," +
                "dateOfLicenceAchieved: %s",commercialFlyingHours, licence, agency, dateOfLicenceAchieved);
    }
}
