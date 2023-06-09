package com.zaga.hotel.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
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
public class Reservation extends PanacheEntityBase {

    @NotNull(message = "User ID is mandatory")
    @ManyToOne
    public Guest guestId;

    @NotNull(message = "Hotel ID is mandatory")
    @ManyToOne
    public Hotel hotelId;

    @NotNull(message = "Room roomNumber is mandatory")
    @ManyToOne
    public Room roomNumber;

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
