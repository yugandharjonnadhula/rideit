package com.example.RideIt.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DriverResponse {
    String name;

    double rating;

    String mobNo;

    CabResponse cabResponse;
}
