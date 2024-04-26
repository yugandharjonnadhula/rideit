package com.example.RideIt.dto.request;

import com.example.RideIt.Enum.CarType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabRequest {
    String company;

    String carModel;

    String cabNo;

    CarType carType;

    int numberOfSeats;

    double farePerKm;
}
