package com.ofline.Biblioteca.Entities.Publicaciones.Libro;

import com.ofline.Biblioteca.Entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@SQLDelete(sql = "UPDATE editorial SET deleted = true WHERE id = ? AND version = ?")
public class Editorial extends BaseEntity {
    private String nombre;
    private String sitioWeb;

    @OneToOne
    @JoinColumn(name = "direccion_id", nullable = false)
    private Direccion direccion;
}
