package com.logistics.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class TrackingRequest {
    @NotNull(message = "Origin country is required")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Origin country must be in ISO 3166-1 alpha-2 format (e.g., US)")
    private String originCountryId;

    @NotNull(message = "Destination country is required")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Destination country must be in ISO 3166-1 alpha-2 format (e.g., GB)")
    private String destinationCountryId;

    @DecimalMin(value = "0.001", message = "Weight must be greater than 0")
    @DecimalMax(value = "999.999", message = "Weight cannot exceed 999.999 kg")
    @Digits(integer = 3, fraction = 3, message = "Weight must have up to 3 decimal places")
    private Double weight;

    private OffsetDateTime createdAt;

    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-4[0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$",
            message = "Invalid UUID format")
    private String customerId;

    @Size(min = 2, max = 100, message = "Customer name must be between 2 and 100 characters")
    private String customerName;

    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$",
            message = "Customer slug must be in kebab-case format")
    private String customerSlug;
}