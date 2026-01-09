package com.ofline.demo.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "UPDATE publicacion SET deleted = true WHERE id = ? AND version = ?")
public abstract class Publicacion extends BaseEntity{
    private String titulo;
    private int anio;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<Ejemplar> ejemplares = new ArrayList<>();
}
