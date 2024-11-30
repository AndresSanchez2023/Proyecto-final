package com.gestionhumana.demo.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "dependencias")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dependencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "dependencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UsuarioNormal> usuarios;
}
