package org.example.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Promocion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;

    @Enumerated(EnumType.STRING)
    private TipoPromocion tipoPromocion;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "promocion_id")
    @Builder.Default
    private Set<Imagen> promoImagen = new HashSet<>();
}


