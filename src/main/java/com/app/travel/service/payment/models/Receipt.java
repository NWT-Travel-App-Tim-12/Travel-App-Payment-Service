package com.app.travel.service.payment.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "receipt")
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID id;

    @Getter
    @Setter
    @OneToOne(optional = false)
    @JoinColumn(name = "coupon_id")
    private UUID couponId;

    @Getter
    @Setter
    @Column
    private Float cost;


    @Getter
    @Setter
    @Column
    private String currency;


    @Getter
    @Setter
    @Column(name = "created_at")
    private Date createdAt;


}
