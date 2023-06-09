package com.zaga.hotel.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingTour extends PanacheEntity {

    @NotNull(message = "User ID is mandatory")
    private String guestId;

    @NotNull(message = "Tour ID is mandatory")
    @ManyToOne
    private Tour tourId;

    @NotNull(message = "Booking date is mandatory")
    private LocalDate bookingDate;

    @NotNull(message = "Total cost of the booking is mandatory")
    @Positive(message = "Total cost of the booking must be positive")
    private Double totalCost;
}
