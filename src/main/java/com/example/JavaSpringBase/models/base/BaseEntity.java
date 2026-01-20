package com.example.javaSpringBase.models.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass // Indica que esta classe é uma superclasse mapeada
@Getter @Setter
public abstract class BaseEntity { // Usada para Entidades que precisam de um ID padrão
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // use GenerationType.IDENTITY caso seja um sistema pequeno e centralizado 
    // ou use GenerationType.UUID caso seja um sistema grande, que rode em microserviços ou por segurança
    private Long id; // ou UUID 
}
