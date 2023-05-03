package com.zaga.hotel.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
public class Hotel extends PanacheEntity {

    @NotBlank(message = "Hotel name is mandatory")
    @Size(max = 100, message = "Hotel name cannot exceed {max} characters")
    private String name;

    @NotBlank(message = "Hotel address is mandatory")
    @Size(max = 200, message = "Hotel address cannot exceed {max} characters")
    private String address;

    @NotBlank(message = "Hotel phone number is mandatory")
    @Size(max = 20, message = "Hotel phone number cannot exceed {max} characters")
    private String phoneNumber;

    @NotNull(message = "Number of rooms available is mandatory")
    @Positive(message = "Number of rooms available must be positive")
    private Integer numRoomsAvailable;

    @NotNull(message = "Total Number of rooms available")
    private Integer TotalRooms;
}
