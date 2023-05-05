package com.zaga.travel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import io.vertx.core.cli.annotations.Description;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Guest")
@Description("Guest information are manages here ")
public class Guest extends PanacheEntityBase {

    @Id
    private String guestId;

    @NotBlank(message = "Name is mandatory")
    @Length(max = 50, message = "Name cannot exceed {max} characters")
    private String name;

    @NotNull
    private String email;

    @NotNull
    @Length(max = 15, message = "Number cannot exceed {max} characters")
    private String phone;

    @NotNull
    @Column(name = "billing_info")
    private String billingInfo;

    @NotNull
    private String address;

    @Lob
    @NotNull
    @Column(name = "id_proof")
    public byte[] idProof;

}
