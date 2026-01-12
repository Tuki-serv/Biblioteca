package com.ofline.Biblioteca.Entities;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "UPDATE autor SET deleted = true WHERE id = ? AND version = ?")
public class Autor extends BaseEntity{
    private String nombre;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
}
