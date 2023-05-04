package com.zaga.hotel.entity.dto;

import java.time.LocalDate;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    @Id
    @NotNull(message = "Reservation ID is mandatory")
    public Long reservationId;

    @NotNull(message = "Check-in date is mandatory")
    public LocalDate checkInDate;

    @NotNull(message = "Check-out date is mandatory")
    public LocalDate checkOutDate;

    @NotNull(message = "Total cost of the reservation is mandatory")
    @Positive(message = "Total cost of the reservation must be positive")
    public Double totalCost;
}
