package models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attendence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;
    private LocalDate date;

    private LocalTime checkIn;

    private LocalTime checkOut;

    @Enumerated(EnumType.STRING)
    private Status status;
}
