package com.app.travel.service.payment.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "receipt")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Receipt {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "coupon_id")
    @NotNull(message = "You have to provide coupon information!")
    private Coupons coupon;

    @Column
    @NotNull(message = "Cost value has to be present.")
    private Float cost;


    @Column
    @NotBlank(message = "Currency has to be provided.")
    private String currency;


    @Column(name = "created_at")
    @JsonIgnore
    private Date createdAt;


    @Column(name = "booking")
    private Integer bookingRef;


}
