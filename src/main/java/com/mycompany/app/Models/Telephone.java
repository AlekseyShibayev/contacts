package com.mycompany.app.Models;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Telephone {

    private int id;
    private String number;
    private Contact contact;

}
