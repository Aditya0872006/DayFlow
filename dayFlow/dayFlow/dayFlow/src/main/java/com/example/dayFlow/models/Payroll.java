package models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Employee employee;

    private Double basicSalary;
    private Double allowances;
    private Double deductions;
    private Double netSalary;

    private int month;
    private int year;

}
