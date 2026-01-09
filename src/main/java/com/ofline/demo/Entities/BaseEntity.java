package com.ofline.demo.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "publicId", unique = true,nullable = false,updatable = false)
    private UUID publicId;

    @Version
    private Long version;

    protected Boolean deleted = false;

    private LocalDateTime fecheCreacion;
    private LocalDateTime fechaModificacion;

    @PrePersist
    protected void onCreate(){
        if (this.publicId == null){
            this.publicId = UUID.randomUUID();
        }

        this.fecheCreacion = LocalDateTime.now();
        this.fechaModificacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.fechaModificacion = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(publicId, that.publicId) && Objects.equals(version, that.version) && Objects.equals(deleted, that.deleted) && Objects.equals(fecheCreacion, that.fecheCreacion) && Objects.equals(fechaModificacion, that.fechaModificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, publicId, version, deleted, fecheCreacion, fechaModificacion);
    }
}
