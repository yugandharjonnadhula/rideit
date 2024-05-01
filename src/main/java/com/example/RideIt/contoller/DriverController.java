package com.example.RideIt.contoller;

import com.example.RideIt.dto.request.DriverRequest;
import com.example.RideIt.model.Driver;
import com.example.RideIt.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")

public class DriverController {
//    @Autowired
//    DriverService driverService;

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

        @PostMapping
        public ResponseEntity<String> addDriver(@RequestBody DriverRequest driverRequest) {
            String response = driverService.addDriver(driverRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

    @GetMapping("/mob-no/{mob-no}")
    public Driver getDriver(@PathVariable("mob-no") String mobNo) {
        return driverService.getDriver(mobNo);
    }

}
