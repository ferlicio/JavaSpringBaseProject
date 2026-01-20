package com.example.javaSpringBase.models.base;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
// import org.springframework.data.annotation.CreatedBy;
// import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass // Indica que esta classe é uma superclasse mapeada
@EntityListeners(AuditingEntityListener.class) // Habilita o Listener de auditoria do JPA
@Getter @Setter
public abstract class AuditableEntity extends BaseEntity { // Usada para Entidades que precisam de auditoria (criação e modificação)

    // Para a hora e data de criação e modificação, você pode usar Instant ou LocalDateTime dependendo das suas necessidades
    // Caso o banco de dados suporte fuso horário, Instant é uma boa escolha
    // Caso contrário, LocalDateTime pode ser mais apropriado
    
    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    // @CreatedBy
    // @Column(name = "created_by", updatable = false, nullable = false)
    // private String createdBy;
    
    @LastModifiedDate
    @Column(name = "updated_at", updatable = true, nullable = true)
    private Instant updatedAt;


    // @LastModifiedBy
    // @Column(name = "updated_by", updatable = true, nullable = true)
    // private String updatedBy;
}
