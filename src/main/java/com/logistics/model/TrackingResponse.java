package com.logistics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import java.time.OffsetDateTime;

@Data
@Builder
public class TrackingResponse {
    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
}
