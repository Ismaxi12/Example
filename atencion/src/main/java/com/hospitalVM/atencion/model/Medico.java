package com.hospitalVM.atencion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity


public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="medico_id")
    private Long medico_id;
    @Column(unique = true,nullable = false)
    @NotBlank(message = "El campo no puede estar vacio")
    @Pattern(regexp= "//d(1,8)-[//dKk]}", message = "El formato del run debe ser xxxxxxxx-x")
    private String run;

    @Column(name ="nombre_completo", nullable = false)
    @NotBlank(message = "El campo nombre completo no puede estar vacio")
    private String nombreCompleto;
    @Column(name = "jefe_turno",nullable = false)
    private String jefeTurno;
    @Embedded
    private Audit audit = new Audit();
}
