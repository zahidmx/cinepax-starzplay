/*
 * Copyright (c) 2020, 2021, Starzpay and/or its affiliates. All rights reserved.
 * CINEPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 */
package com.cinepax.starzplay.service;

import com.cinepax.starzplay.model.PaymentMethods;

import java.util.List;

/**
 *
 * @since 1.0
 */
public interface PaymentService {

    /**
     * Returns an {@code List<PaymentMethods>} describing the given value, if
     * non-{@code null}, otherwise returns an empty {@code List<PaymentMethods>}.
     */
    public List<PaymentMethods> fetchAllPaymentMethods();

    /**
     *
     * @param paymentMethods
     * Returns an {@code List<PaymentMethods>} describing the given value, if
     * non-{@code null}, otherwise returns an empty {@code List<PaymentMethods>}.
     */
    public List<PaymentMethods> savePaymentMethods(List<PaymentMethods> paymentMethods);
}
