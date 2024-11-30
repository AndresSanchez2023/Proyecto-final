package com.gestionhumana.demo.modelo;

import com.gestionhumana.demo.modelo.enumeracion.Cargo;
import com.gestionhumana.demo.modelo.enumeracion.NivelOrganizacional;
import com.gestionhumana.demo.modelo.enumeracion.Sede;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "usuario_normal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioNormal extends User {

    @Enumerated(EnumType.STRING)
    private NivelOrganizacional nivelOrganizacional;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Enumerated(EnumType.STRING)
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "dependencia_id")
    private Dependencia dependencia;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EncuestaUsuario> userSurveys;
}
