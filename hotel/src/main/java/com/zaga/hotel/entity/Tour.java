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
public class Tour extends PanacheEntity {

    @NotBlank(message = "Tour provider's name is mandatory")
    @Size(max = 100, message = "Tour provider's name cannot exceed {max} characters")
    private String providerName;

    @NotBlank(message = "Tour name is mandatory")
    @Size(max = 100, message = "Tour name cannot exceed {max} characters")
    private String name;

    @NotBlank(message = "Tour description is mandatory")
    @Size(max = 500, message = "Tour description cannot exceed {max} characters")
    private String description;

    @NotNull(message = "Tour price is mandatory")
    @Positive(message = "Tour price must be positive")
    private Double price;

    @NotNull(message = "Tour duration is mandatory")
    @Positive(message = "Tour duration must be positive")
    private Integer duration;
}
