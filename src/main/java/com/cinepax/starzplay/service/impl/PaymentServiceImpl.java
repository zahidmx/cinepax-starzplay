/*
 * Copyright (c) 2020, 2021, Starzpay and/or its affiliates. All rights reserved.
 * CINEPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 */
package com.cinepax.starzplay.service.impl;

import com.cinepax.starzplay.model.PaymentMethods;
import com.cinepax.starzplay.repository.PaymentRepository;
import com.cinepax.starzplay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<PaymentMethods> fetchAllPaymentMethods() {
        return paymentRepository.findAll();
    }

    @Override
    public List<PaymentMethods> savePaymentMethods(List<PaymentMethods> paymentMethods) {
        return paymentRepository.saveAll(paymentMethods);
    }
}
