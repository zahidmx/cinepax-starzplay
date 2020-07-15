/*
 * Copyright (c) 2020, 2021, Starzpay and/or its affiliates. All rights reserved.
 * CINEPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 */
package com.cinepax.starzplay.controller;

import com.cinepax.starzplay.common.RequestResponse;
import com.cinepax.starzplay.model.PaymentMethods;
import com.cinepax.starzplay.model.PaymentPlans;
import com.cinepax.starzplay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1.0/configuration/payment-methods/")
public class PaymentMethodController {

    /**
     * Autowiring PaymentService .
     */
    @Autowired
    PaymentService paymentService;

    /**
     *
     * @param name
     * @param id
     * @return
     */
    @GetMapping
    public RequestResponse getPaymentMethods(@RequestParam Optional<String> name, @RequestParam Optional<Integer> id) {

        return
                id.isPresent()
                        ? ifPaymentPlanIdProvided(id.get())
                        : name
                            .map(this::ifPaymentMethodNameProvided)
                            .orElse(fetchAllPaymentMethods());
    }

    /**
     *
     * @param requestObject
     * @return
     */
    @PostMapping
    public RequestResponse addPaymentMethod(@RequestBody RequestResponse requestObject){
        return new RequestResponse(paymentService.savePaymentMethods(requestObject.getPaymentMethods()));
    }

    /**
     *
     * @param requestObject
     * @param id
     * @return
     */
    @PutMapping
    public ResponseEntity<Object> updateStudent(@RequestBody RequestResponse requestObject, @RequestParam Integer id) {

        Optional<PaymentMethods> paymentMethod = paymentService.fetchAllPaymentMethods()
                .stream()
                .filter(p -> p.getPaymentPlans().stream().allMatch(m -> m.getId() == id))
                .filter(p -> !p.getPaymentPlans().isEmpty())
                .findFirst();

        if (!paymentMethod.isPresent())
            return ResponseEntity.notFound().build();

        PaymentMethods method = requestObject.getPaymentMethods().get(0);
        method.setPaymentMethodId(paymentMethod.get().getPaymentMethodId());

        paymentService.savePaymentMethods(requestObject.getPaymentMethods());

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     *
     * @param name
     * @return
     */
    private RequestResponse ifPaymentMethodNameProvided(String name) {
        return new RequestResponse(
                paymentService.fetchAllPaymentMethods()
                        .stream()
                        .filter(p -> p.getName().equals(name))
                        .collect(Collectors.toList())
        );

    }

    /**
     *
     * @param id
     * @return
     */
    private RequestResponse ifPaymentPlanIdProvided(int id) {
        return new RequestResponse(
                paymentService.fetchAllPaymentMethods()
                        .stream()
                        .filter(p -> p.getPaymentPlans().stream().anyMatch(a -> a.getId() == id))
                        .filter(p -> !p.getPaymentPlans().isEmpty())
                        .collect(Collectors.toList())
        );
    }

    /**
     *
     * @return
     */
    private RequestResponse fetchAllPaymentMethods() {
        return new RequestResponse(paymentService.fetchAllPaymentMethods());
    }

}
