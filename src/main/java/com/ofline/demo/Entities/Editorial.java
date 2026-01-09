package com.ofline.demo.Entities;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "UPDATE editorial SET deleted = true WHERE id = ? AND version = ?")
public class Editorial extends BaseEntity{
    private String nombre;
    private String sitioWeb;
    private Direccion direccion;
}
