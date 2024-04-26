package com.example.RideIt.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.annotation.processing.Generated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponse {
    String name;
    String emailId;

}
