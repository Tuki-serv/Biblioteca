package com.ofline.Biblioteca.Entities.Publicaciones.Libro;

import com.ofline.Biblioteca.Entities.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@SQLDelete(sql = "UPDATE autor SET deleted = true WHERE id = ? AND version = ?")
public class Autor extends BaseEntity {
    private String nombre;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
}
