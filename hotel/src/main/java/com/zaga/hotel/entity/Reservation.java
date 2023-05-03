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
@EqualsAndHashCode(callSuper = true)
public class Reservation extends PanacheEntity {

    @NotNull(message = "User ID is mandatory")
    private String guestId;

    @NotNull(message = "Hotel ID is mandatory")
    @ManyToOne
    private Hotel hotel;

    @NotNull(message = "Room ID is mandatory")
    @ManyToOne
    private Room room;

    @NotNull(message = "Check-in date is mandatory")
    private LocalDate checkInDate;

    @NotNull(message = "Check-out date is mandatory")
    private LocalDate checkOutDate;

    @NotNull(message = "Total cost of the reservation is mandatory")
    @Positive(message = "Total cost of the reservation must be positive")
    private Double totalCost;
}
