package com.ofline.Biblioteca.Entities.Usuario;

import com.ofline.Biblioteca.Entities.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "UPDATE usuario SET deleted = true WHERE id = ? AND version = ?")
public class Usuario extends BaseEntity {
    private String nombre;
    private String apellido;
    private String dni;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<Prestamo> prestamos;
}
