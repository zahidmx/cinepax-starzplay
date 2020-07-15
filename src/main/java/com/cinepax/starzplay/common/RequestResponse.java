/*
 * Copyright (c) 2020, 2021, Starzpay and/or its affiliates. All rights reserved.
 * CINEPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 */
package com.cinepax.starzplay.common;

import com.cinepax.starzplay.model.PaymentMethods;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @since 1.0
 */
public class RequestResponse {

    List<PaymentMethods> paymentMethods = new ArrayList<>();

    public RequestResponse() {

    }

    public RequestResponse(List<PaymentMethods> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    /**
     *
     * @return {@code List<PaymentMethods>} if a value is present, otherwise {@code empty list}
     */
    public List<PaymentMethods> getPaymentMethods() {
        return paymentMethods;
    }

    /**
     *
     * @param paymentMethods
     */
    public void setPaymentMethods(List<PaymentMethods> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
