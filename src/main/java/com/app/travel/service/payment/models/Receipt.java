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
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @Getter
    @Setter
    private String bookingRef;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "uuid", name = "coupon_id")
    private Coupons couponRef;

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
