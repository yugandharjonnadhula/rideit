package com.example.RideIt.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class CabResponse {
    String cabNo;

    String carModel;

    double farePerKm;
}
