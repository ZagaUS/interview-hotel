package com.zaga.hotel.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
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
public class ScenicTourProvider extends PanacheEntity {

    @NotBlank(message = "Tour provider's name is mandatory")
    @Size(max = 100, message = "Tour provider's name cannot exceed {max} characters")
    private String providerName;

    @NotBlank(message = "Provider's address is mandatory")
    @Size(max = 200, message = "Provider's address cannot exceed {max} characters")
    private String address;

    @NotBlank(message = "Provider's phone number is mandatory")
    @Size(max = 20, message = "Provider's phone number cannot exceed {max} characters")
    private String phoneNumber;

    @NotBlank(message = "Type of tour available is mandatory")
    @Size(max = 50, message = "Type of tour available cannot exceed {max} characters")
    private String tourType;

    @NotBlank(message = "Tour duration is mandatory")
    @Positive(message = "Tour duration must be positive")
    private Integer duration;
}
