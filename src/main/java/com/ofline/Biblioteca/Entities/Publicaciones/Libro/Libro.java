package com.ofline.Biblioteca.Entities.Publicaciones.Libro;

import com.ofline.Biblioteca.Entities.Publicaciones.Publicacion;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@SQLDelete(sql = "UPDATE libro SET deleted = true WHERE id = ? AND version = ?")
public class Libro extends Publicacion {
    private String isbn;

    @OneToMany
    @JoinColumn(name = "autores_id",nullable = false)
    @Builder.Default
    private List<Autor> autores = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "editorial_id", nullable = false)
    private Editorial editorial;

}
