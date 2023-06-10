package com.app.travel.service.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "coupons")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coupons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cost_reduction")
    @Min(value = 0, message = "Cost reduction value can't be negative.")
    private Integer costReduction;

    @Column(name = "created_at")
    @JsonIgnore
    private Date createdAt;

    @Column(name = "valid_until")
    @JsonIgnore
    private Date validUntil;

    @Column(name = "automatic")
    @NotNull(message = "Automatic value has to be sent.")
    private Boolean automatic;

    @OneToOne(mappedBy = "coupon")
    @JsonIgnore
    private Receipt receipt;


}
