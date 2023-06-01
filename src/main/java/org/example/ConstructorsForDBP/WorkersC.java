package org.example.ConstructorsForDBP;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data @AllArgsConstructor
public class WorkersC {

    private String name;
    private LocalDate birthday;
    private String level;
    private int salary;

}
