package com.example.RideIt.service;

import com.example.RideIt.dto.request.DriverRequest;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Driver;
import com.example.RideIt.repository.DriverRepository;
import com.example.RideIt.transformer.CabTransformer;
import com.example.RideIt.transformer.DriverTransformer;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
//    @Autowired
//       DriverRepository driverRepository;

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }


    public String addDriver(DriverRequest driverRequest) {

        // driver request -> driver
        // cab Request -> cab
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        Cab cab = CabTransformer.cabRequestToCab(driverRequest.getCab());

        // set the relationship attributrs
        driver.setCab(cab);
        cab.setDriver(driver);

        driverRepository.save(driver);  // save both driver and cab
        return "Driver and Cab saved successfully";
    }

    public Driver getDriver(String mobNo) {
        return driverRepository.findByMobNo(mobNo);
    }
}

