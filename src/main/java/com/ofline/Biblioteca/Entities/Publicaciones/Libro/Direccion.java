package com.ofline.Biblioteca.Entities.Publicaciones.Libro;

import com.ofline.Biblioteca.Entities.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "UPDATE direccion SET deleted = true WHERE id = ? AND version = ?")
public class Direccion extends BaseEntity {
    private String calle;
    private int numero;
    private String ciudad;
    private String codigoPostal;
}
