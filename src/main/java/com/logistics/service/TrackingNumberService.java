package com.logistics.service;

import com.logistics.generator.TrackingNumberGenerator;
import com.logistics.model.TrackingRequest;
import com.logistics.model.TrackingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class TrackingNumberService {
    private final TrackingNumberGenerator generator;
    private final ConcurrentHashMap<String, Boolean> usedNumbers = new ConcurrentHashMap<>();

    public TrackingResponse generateTrackingNumber(TrackingRequest request) {
        String trackingNumber;
        do {
            trackingNumber = generator.generate(
                request.getOriginCountryId(),
                request.getDestinationCountryId()
            );
        } while (usedNumbers.putIfAbsent(trackingNumber, true) != null);

        return TrackingResponse.builder()
                .trackingNumber(trackingNumber)
                .createdAt(OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build();
    }
}