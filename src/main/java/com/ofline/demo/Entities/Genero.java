package com.ofline.demo.Entities;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "UPDATE genero SET deleted = true WHERE id = ? AND version = ?")
public class Genero extends BaseEntity{
    private String nombre;
    private String descripcion;
}
