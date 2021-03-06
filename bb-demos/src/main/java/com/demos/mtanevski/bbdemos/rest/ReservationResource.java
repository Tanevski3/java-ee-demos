package com.demos.mtanevski.bbdemos.rest;

import com.demos.mtanevski.bbdemos.model.ReservationResponse;
import com.demos.mtanevski.bbdemos.model.request.ReservationRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<ReservationResponse> getAvailableRooms(
            @RequestParam(value="checkin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkin,
            @RequestParam(value="checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkout){

        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);

    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest){
        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.CREATED);
    }

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> updateReservation(@RequestBody ReservationRequest reservationRequest){
        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable long reservationId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
