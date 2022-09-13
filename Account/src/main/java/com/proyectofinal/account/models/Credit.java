package com.proyectofinal.account.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class Credit {
    @Id
    private Long id;
    private String customerid;
    private String typecredit;
    private float creditAmount;
    private float amountUsed;
    private Date createdAt;
}
