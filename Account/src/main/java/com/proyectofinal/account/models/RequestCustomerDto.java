package com.proyectofinal.account.models;

import lombok.Data;
import lombok.NonNull;


@Data
public class RequestCustomerDto{
    @NonNull
    private String customerId;
    private boolean state;
}
