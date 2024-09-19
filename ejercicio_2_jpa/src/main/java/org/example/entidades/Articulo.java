package org.example.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@Builder

public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String denominacion;
    private  Double precioVenta;
    private  String codigo;

    @OneToOne
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;

    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private UnidadMedida unidadMedida;


}
