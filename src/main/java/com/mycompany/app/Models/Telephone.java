package com.mycompany.app.Models;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Telephone {

    private int id;
    private String number;
    private int contactId;

}
