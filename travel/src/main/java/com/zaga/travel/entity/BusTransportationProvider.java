package com.zaga.travel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
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
public class BusTransportationProvider extends PanacheEntityBase {

    @Id
    private Long travelId;

    @NotBlank(message = "Provider's name is mandatory")
    @Size(max = 100, message = "Provider's name cannot exceed {max} characters")
    private String providerName;

    @NotBlank(message = "Provider's address is mandatory")
    @Size(max = 200, message = "Provider's address cannot exceed {max} characters")
    private String providerAddress;

    @NotBlank(message = "Provider's phone number is mandatory")
    @Size(max = 20, message = "Provider's phone number cannot exceed {max} characters")
    private String phoneNumber;

    @NotBlank(message = "Type of bus available is mandatory")
    @Size(max = 50, message = "Type of bus available cannot exceed {max} characters")
    private String busType;

}
