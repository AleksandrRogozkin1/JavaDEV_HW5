package org.example.ConstructorsForDBP;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WorkersC {

    private String name;
    private LocalDate birthday;
    private String level;
    private int salary;

}
