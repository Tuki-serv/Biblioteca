package com.ofline.Biblioteca.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "UPDATE libro SET deleted = true WHERE id = ? AND version = ?")
public class Libro extends Publicacion{
    private String isbn;

    @OneToMany
    @JoinColumn(name = "autores_id",nullable = false)
    @Builder.Default
    private List<Autor> autores = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "editorial_id", nullable = false)
    @Builder.Default
    private Editorial editorial;

}
