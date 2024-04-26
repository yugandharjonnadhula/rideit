package com.example.RideIt.dto.request;

import com.example.RideIt.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {
    String name;
    int age;
    String emailId;
    String address;
    Gender gender;
}
