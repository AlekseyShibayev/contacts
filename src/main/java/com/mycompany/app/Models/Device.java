package com.mycompany.app.Models;

import lombok.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "contactSet")
@ToString(exclude =  "contactSet")
public class Device {

    private int id;
    private String name;
    private Set<Contact> contactSet;

}
