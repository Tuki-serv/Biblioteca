package com.ofline.Biblioteca.Entities.Publicaciones;

import com.ofline.Biblioteca.Entities.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@SQLDelete(sql = "UPDATE genero SET deleted = true WHERE id = ? AND version = ?")
public class Genero extends BaseEntity {
    private String nombre;
    private String descripcion;
}
