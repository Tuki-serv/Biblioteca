package com.ofline.Biblioteca.Entities;

import com.ofline.Biblioteca.Entities.Publicaciones.Ejemplar;
import com.ofline.Biblioteca.Entities.Publicaciones.Libro.Direccion;
import com.ofline.Biblioteca.Entities.Usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@SQLDelete(sql = "UPDATE biblioteca SET deleted = true WHERE id = ? AND version = ?")
public class Biblioteca extends BaseEntity{
    private String nombre;

    @OneToOne
    @JoinColumn(name = "direccion_id", nullable = false)
    private Direccion direccion;

    @OneToMany(mappedBy = "biblioteca")
    private List<Ejemplar> ejemplares = new ArrayList<>();
}
