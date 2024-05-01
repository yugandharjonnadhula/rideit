package com.example.RideIt.dto.response;

import com.example.RideIt.Enum.TripStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class TripBookingResponse {
    String bookingId;  // UUID

    String pickup;

    String destination;

    double tripDistanceInKm;

    double totalFare;

    TripStatus tripStatus;

    Date bookedAt;

    CustomerResponse customerResponse;

    DriverResponse driverResponse;
    String message;
}
