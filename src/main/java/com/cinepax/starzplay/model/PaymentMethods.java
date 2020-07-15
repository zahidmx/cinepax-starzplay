/*
 * Copyright (c) 2020, 2021, Starzpay and/or its affiliates. All rights reserved.
 * CINEPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 */
package com.cinepax.starzplay.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "paymentmethods")
public class PaymentMethods implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentmethodid")
    @JsonIgnore
    private int paymentMethodId;

    @Column(name = "name")
    private String name;

    @Column(name = "displayName")
    private String displayName;

    @Column(name = "paymentType")
    private String paymentType;

    @ManyToMany
    @JoinTable(
            name = "methodplans",
            joinColumns = @JoinColumn(name = "paymentmethodid"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    List<PaymentPlans> paymentPlans;


    public PaymentMethods() {
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<PaymentPlans> getPaymentPlans() {
        return paymentPlans;
    }

    public void setPaymentPlans(List<PaymentPlans> paymentPlans) {
        this.paymentPlans = paymentPlans;
    }
}