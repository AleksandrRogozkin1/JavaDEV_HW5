package org.example.ConstructorsForDBP;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class ProjectC {

    private int client_id;
    private LocalDate start_date;
    private LocalDate finish_date;

}
