package com.zaga.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.zaga.hotel.entity.enumhotel.RoomType;

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
@EqualsAndHashCode(callSuper = true)
public class Room extends PanacheEntityBase {

    @Id
    public Long roomId;

    @NotBlank(message = "Room number is mandatory")
    private String roomNumber;

    @NotBlank(message = "Room type is mandatory")
    private RoomType roomType;

    @NotNull(message = "Room rate is mandatory")
    @Positive(message = "Room rate must be positive")
    private Double roomRate;

    @NotNull(message = "Number of beds in the room is mandatory")
    @Positive(message = "Number of beds in the room must be positive")
    private Integer numBeds;
}
