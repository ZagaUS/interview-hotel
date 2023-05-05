package com.zaga.hotel.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingTravel extends PanacheEntityBase {

    @Id
    public Long bookingId;

    @NotNull(message = "User ID is mandatory")
    private String guestId;

    @NotNull(message = "travelId ID is mandatory")
    @ManyToOne
    public BusTransportationProvider travelId;

    @NotNull(message = "Provider's name is mandatory")
    @Size(max = 100, message = "Provider's name cannot exceed {max} characters")
    private String providerName;

    @NotNull(message = "Type of bus available is mandatory")
    @Size(max = 50, message = "Type of bus available cannot exceed {max} characters")
    private String busType;

    @NotNull(message = "travel date is mandatory")
    private LocalDate travelDate;

    @NotNull(message = "Total cost of the booking is mandatory")
    @Positive(message = "Total cost of the booking must be positive")
    private Double totalCost;
}
