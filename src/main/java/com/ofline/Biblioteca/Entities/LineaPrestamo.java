package com.ofline.Biblioteca.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "UPDATE lineaPrestamo SET deleted = true WHERE id = ? AND version = ?")
public class LineaPrestamo extends BaseEntity{
    private Date fechaDevolucionEstimada;

    @ManyToOne
    @JoinColumn(name = "prestamo_id", nullable = false)
    private Prestamo prestamo;

    private Ejemplar ejemplar;
}
