package com.logistics.controller;

import com.logistics.model.TrackingRequest;
import com.logistics.model.TrackingResponse;
import com.logistics.service.TrackingNumberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TrackingNumberController {
    private final TrackingNumberService trackingNumberService;

    @GetMapping("/next-tracking-number")
    public TrackingResponse getNextTrackingNumber(@Valid @ModelAttribute TrackingRequest request) {
        return trackingNumberService.generateTrackingNumber(request);
    }
}