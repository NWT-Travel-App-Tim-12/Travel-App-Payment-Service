package com.app.travel.service.payment.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "coupons")
@AllArgsConstructor
@NoArgsConstructor
public class Coupons {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "cost_reduction")
    @Getter
    @Setter
    private Integer costReduction;

    @Getter
    @Setter
    @Column(name = "created_at")
    private Date createdAt;

    @Getter
    @Setter
    @Column(name = "valid_until")
    private Date validUntil;

    @Getter
    @Setter
    @Column(name = "automatic")
    private Boolean automatic;

}
