package com.zaga.hotel.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
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
public class Room extends PanacheEntity {

    @NotBlank(message = "Room number is mandatory")
    private String roomNumber;

    @NotBlank(message = "Room type is mandatory")
    private String roomType;

    @NotNull(message = "Room rate is mandatory")
    @Positive(message = "Room rate must be positive")
    private Double roomRate;

    @NotNull(message = "Number of beds in the room is mandatory")
    @Positive(message = "Number of beds in the room must be positive")
    private Integer numBeds;
}
