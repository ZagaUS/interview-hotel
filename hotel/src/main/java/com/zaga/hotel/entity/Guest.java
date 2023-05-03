package com.zaga.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import io.vertx.core.cli.annotations.Description;

@Entity
@Table(name = "Guest")
@Description("Guest information are manages here ")
public class Guest extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

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

    @Lob
    @NotNull
    @Column(name = "id_proof")
    private byte[] idProof;

}
