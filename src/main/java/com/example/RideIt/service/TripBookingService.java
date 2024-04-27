package com.example.RideIt.service;

import com.example.RideIt.dto.request.TripBookingRequest;
import com.example.RideIt.dto.response.TripBookingResponse;
import com.example.RideIt.exception.CabNotAvailableException;
import com.example.RideIt.exception.CustomerNotFoundException;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Customer;
import com.example.RideIt.model.TripBooking;
import com.example.RideIt.repository.CabRepository;
import com.example.RideIt.repository.CustomerRepository;
import com.example.RideIt.repository.DriverRepository;
import com.example.RideIt.repository.TripBookingRepository;
import com.example.RideIt.transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripBookingService {

    private final TripBookingRepository tripBookingRepository;

    private final CabRepository cabRepository;
    private final DriverRepository driverRepository;

    private CustomerRepository customerRepository;


    public TripBookingResponse bookCab(boolean applyCoupon,
                                       TripBookingRequest tripBookingRequest) {

        // validate email id of the customer
        Customer customer = customerRepository.findByEmailId(tripBookingRequest
                .getCustomerEmailId());

        if(customer == null) {
            throw new CustomerNotFoundException("Invalid email id");
        }

        // check if a cab is available or not for booking
        // get a random available cab
        Cab cab = cabRepository.getRandomAvailableCab();
        if(cab == null) {
            throw new CabNotAvailableException("Sorry! All drivers are busy right now!!");
        }

        // prepare the booking entity
        TripBooking tripBooking = BookingTransformer.bookingRequestToBooking(tripBookingRequest);
        tripBooking.setTotalFare(cab.getFarePerKm() * tripBookingRequest.getTripDistanceInKm());
        tripBooking.setCustomer(customer);
        tripBooking.setDriver(cab.getDriver());

        // save booking
        TripBooking savedTripBooking = tripBookingRepository.save(tripBooking);

        customer.getBookings().add(savedTripBooking);
        cab.setAvailable(false);
        cab.getDriver().getBookings().add(savedTripBooking);

        // customer and booking
        customerRepository.save(customer); // customer + savedBooking
        driverRepository.save(cab.getDriver()); // driver + cab + savedBooking

        // last step -> prepare booking response
        return BookingTransformer.tripBookingToTripBookingResponse(savedTripBooking);

    }
}
