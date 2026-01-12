package com.ofline.Biblioteca.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@SQLDelete(sql = "UPDATE biblioteca SET deleted = true WHERE id = ? AND version = ?")
public class Biblioteca extends BaseEntity{
    private String nombre;
    private Direccion direccion;

    @OneToMany(mappedBy = "biblioteca")
    private List<Ejemplar> ejemplares = new ArrayList<>();
}
