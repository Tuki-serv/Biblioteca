package com.ofline.Biblioteca.Entities;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "UPDATE revista SET deleted = true WHERE id = ? AND version = ?")
public class Revista extends Publicacion{
    private int volumen;
    private int numero;
}
