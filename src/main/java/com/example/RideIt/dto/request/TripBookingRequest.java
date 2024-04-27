package com.example.RideIt.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class TripBookingRequest {

    String pickup;

    String destination;

    double tripDistanceInKm;

    String customerEmailId;
}
