package com.ofline.Biblioteca.Entities.Usuario;

import com.ofline.Biblioteca.Entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@SQLDelete(sql = "UPDATE pretamo SET deleted = true WHERE id = ? AND version = ?")
public class Prestamo extends BaseEntity {
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "prestamo", cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<LineaPrestamo> lineas = new ArrayList<>();
}
