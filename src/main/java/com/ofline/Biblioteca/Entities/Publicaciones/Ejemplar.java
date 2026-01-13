package com.ofline.Biblioteca.Entities.Publicaciones;

import com.ofline.Biblioteca.Entities.BaseEntity;
import com.ofline.Biblioteca.Entities.Biblioteca;
import com.ofline.Biblioteca.Entities.Enums.EstadoEjemplar;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "UPDATE ejemplar SET deleted = true WHERE id = ? AND version = ?")
public class Ejemplar extends BaseEntity {
    private String codigo;

    @Enumerated(EnumType.STRING)
    private EstadoEjemplar estado;

    @ManyToOne
    @JoinColumn(name = "publicacion_id", nullable = false)
    private Publicacion publicacion;


    @ManyToOne
    @JoinColumn(name = "biblioteca_id", nullable = false)
    private Biblioteca biblioteca;

    private Boolean disponible;
}
