package org.example;

import org.example.entidades.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class  Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        try {
            // Crear unidades de medida
            UnidadMedida unidad8Porciones = UnidadMedida.builder().denominacion("8 Porciones").build();
            UnidadMedida unidad4Porciones = UnidadMedida.builder().denominacion("4 Porciones").build();
            UnidadMedida unidad1Litro = UnidadMedida.builder().denominacion("1 Litro").build();

            // Crear imágenes
            Imagen imagen1 = Imagen.builder().name("imagen1").url("http://example.com/imagen1.jpg").build();
            Imagen imagen2 = Imagen.builder().name("imagen2").url("http://example.com/imagen2.jpg").build();
            Imagen imagen3 = Imagen.builder().name("imagen3").url("http://example.com/imagen3.jpg").build();
            Imagen imagen4 = Imagen.builder().name("imagen4").url("http://example.com/imagen4.jpg").build();
            Imagen imagen5 = Imagen.builder().name("imagen5").url("http://example.com/imagen5.jpg").build();
            Imagen imagen6 = Imagen.builder().name("imagen6").url("http://example.com/imagen6.jpg").build();
            Imagen imagen7 = Imagen.builder().name("imagen7").url("http://example.com/imagen7.jpg").build();
            Imagen imagen8 = Imagen.builder().name("imagen8").url("http://example.com/imagen8.jpg").build();
            Imagen imahappy1 = Imagen.builder().name("imahappy1").url("http://example.com/imahappy1.jpg").build();
            Imagen imahappy2 = Imagen.builder().name("imahappy2").url("http://example.com/imahappy2.jpg").build();
            Imagen verano1 = Imagen.builder().name("verano1").url("http://example.com/verano1.jpg").build();
            Imagen verano2 = Imagen.builder().name("verano2").url("http://example.com/verano2.jpg").build();
            Imagen invierno1 = Imagen.builder().name("invierno1").url("http://example.com/invierno1.jpg").build();
            Imagen invierno2 = Imagen.builder().name("invierno2").url("http://example.com/invierno2.jpg").build();

            // Crear artículos
            Articulo pizzaGrandeHawaiana = Articulo.builder()
                    .denominacion("Pizza grande Hawaiana")
                    .precioVenta(15.0)
                    .codigo("PZGH001")
                    .imagen(imagen1)
                    .unidadMedida(unidad8Porciones)
                    .build();

            Articulo pizzaChicaHawaiana = Articulo.builder()
                    .denominacion("Pizza chica Hawaiana")
                    .precioVenta(10.0)
                    .codigo("PZCH001")
                    .imagen(imagen4)
                    .unidadMedida(unidad4Porciones)
                    .build();

            Articulo pizzaGrandeNapolitana = Articulo.builder()
                    .denominacion("Pizza grande Napolitana")
                    .precioVenta(15.0)
                    .codigo("PZGN001")
                    .imagen(imagen2)
                    .unidadMedida(unidad8Porciones)
                    .build();

            Articulo pizzaGrandeMuzza = Articulo.builder()
                    .denominacion("Pizza grande Muzza")
                    .precioVenta(15.0)
                    .codigo("PZGM001")
                    .imagen(imagen3)
                    .unidadMedida(unidad8Porciones)
                    .build();

            Articulo pizzaChicaMuzza = Articulo.builder()
                    .denominacion("Pizza chica Muzza")
                    .precioVenta(10.0)
                    .codigo("PZCM001")
                    .imagen(imagen6)
                    .unidadMedida(unidad4Porciones)
                    .build();

            Articulo cervezaAndes = Articulo.builder()
                    .denominacion("Cerveza Andes")
                    .precioVenta(5.0)
                    .codigo("CRVAN001")
                    .imagen(imagen7)
                    .unidadMedida(unidad1Litro)
                    .build();

            Articulo cervezaQuilmes = Articulo.builder()
                    .denominacion("Cerveza Quilmes")
                    .precioVenta(5.0)
                    .codigo("CRVQL001")
                    .imagen(imagen8)
                    .unidadMedida(unidad1Litro)
                    .build();

            // Crear promociones
            Set<Articulo> articulosHappyHour = new HashSet<>();
            articulosHappyHour.add(pizzaGrandeHawaiana);
            articulosHappyHour.add(pizzaGrandeMuzza);
            articulosHappyHour.add(cervezaQuilmes);

            Set<Imagen> imagenesHappyHour = new HashSet<>();
            imagenesHappyHour.add(imahappy1);
            imagenesHappyHour.add(imahappy2);

            Promocion happyHourPromo = Promocion.builder()
                    .denominacion("Happy Hour")
                    .fechaDesde(LocalDate.now())
                    .fechaHasta(LocalDate.now().plusDays(7))
                    .horaDesde(LocalTime.of(18, 0))
                    .horaHasta(LocalTime.of(21, 0))
                    .descripcionDescuento("2x1 en pizzas y cervezas")
                    .precioPromocional(10.0)
                    .tipoPromocion(TipoPromocion.happyHour)
                    .articulos(articulosHappyHour)
                    .promoImagen(imagenesHappyHour)
                    .build();

            Set<Articulo> articulosVerano = new HashSet<>();
            articulosVerano.add(pizzaChicaHawaiana);
            articulosVerano.add(pizzaGrandeNapolitana);
            articulosVerano.add(cervezaQuilmes);
            articulosVerano.add(cervezaAndes);

            Set<Imagen> imagenesVerano = new HashSet<>();
            imagenesVerano.add(verano1);
            imagenesVerano.add(verano2);

            Promocion veranoPromo = Promocion.builder()
                    .denominacion("Verano")
                    .fechaDesde(LocalDate.now())
                    .fechaHasta(LocalDate.now().plusDays(30))
                    .horaDesde(LocalTime.of(12, 0))
                    .horaHasta(LocalTime.of(23, 0))
                    .descripcionDescuento("Descuento en pizzas y cervezas")
                    .precioPromocional(12.0)
                    .tipoPromocion(TipoPromocion.verano)
                    .articulos(articulosVerano)
                    .promoImagen(imagenesVerano)
                    .build();

            Set<Articulo> articulosInvierno = new HashSet<>();
            articulosInvierno.add(pizzaGrandeHawaiana);
            articulosInvierno.add(pizzaChicaMuzza);
            articulosInvierno.add(cervezaQuilmes);

            Set<Imagen> imagenesInvierno = new HashSet<>();
            imagenesInvierno.add(invierno1);
            imagenesInvierno.add(invierno2);

            Promocion inviernoPromo = Promocion.builder()
                    .denominacion("Invierno")
                    .fechaDesde(LocalDate.now())
                    .fechaHasta(LocalDate.now().plusDays(30))
                    .horaDesde(LocalTime.of(12, 0))
                    .horaHasta(LocalTime.of(23, 0))
                    .descripcionDescuento("Descuento en pizzas y cervezas")
                    .precioPromocional(12.0)
                    .tipoPromocion(TipoPromocion.invierno)
                    .articulos(articulosInvierno)
                    .promoImagen(imagenesInvierno)
                    .build();

            // Iniciar una transacción
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            // Guardar las entidades en la base de datos
            em.persist(unidad8Porciones);
            em.persist(unidad4Porciones);
            em.persist(unidad1Litro);
            em.persist(imagen1);
            em.persist(imagen2);
            em.persist(imagen3);
            em.persist(imagen4);
            em.persist(imagen5);
            em.persist(imagen6);
            em.persist(imagen7);
            em.persist(imagen8);
            em.persist(imahappy1);
            em.persist(imahappy2);
            em.persist(verano1);
            em.persist(verano2);
            em.persist(invierno1);
            em.persist(invierno2);
            em.persist(pizzaGrandeHawaiana);
            em.persist(pizzaChicaHawaiana);
            em.persist(pizzaGrandeNapolitana);
            em.persist(pizzaChicaMuzza);
            em.persist(cervezaAndes);
            em.persist(cervezaQuilmes);
            em.persist(happyHourPromo);
            em.persist(veranoPromo);
            em.persist(inviernoPromo);

            // Confirmar la transacción
            tx.commit();

            // Mostrar todas las promociones
            TypedQuery<Promocion> queryPromociones = em.createQuery("SELECT p FROM Promocion p", Promocion.class);
            List<Promocion> promociones = queryPromociones.getResultList();
            System.out.println("Todas las promociones:");
            for (Promocion promocion : promociones) {
                System.out.println(promocion);
            }

            // Mostrar todos los artículos
            TypedQuery<Articulo> queryArticulos = em.createQuery("SELECT a FROM Articulo a", Articulo.class);
            List<Articulo> articulos = queryArticulos.getResultList();
            System.out.println("Todos los artículos:");
            for (Articulo articulo : articulos) {
                System.out.println(articulo);
            }

            // Mostrar cada promoción por separado y los artículos relacionados y el precio de venta
            System.out.println("Detalles de cada promoción:");
            for (Promocion promocion : promociones) {
                System.out.println("Promoción: " + promocion.getDenominacion());
                System.out.println("Artículos relacionados:");
                for (Articulo articulo : promocion.getArticulos()) {
                    System.out.println(articulo.getDenominacion() + " - Precio de venta: $" + articulo.getPrecioVenta());
                }
                System.out.println("Precio promocional: $" + promocion.getPrecioPromocional());
                System.out.println();
            }

            // Mostrar el día y horario de la promoción Verano
            Promocion veranoPromoDetalle = em.find(Promocion.class, veranoPromo.getId());
            System.out.println("Detalles de la promoción Verano:");
            System.out.println("Fecha desde: " + veranoPromoDetalle.getFechaDesde());
            System.out.println("Fecha hasta: " + veranoPromoDetalle.getFechaHasta());
            System.out.println("Hora desde: " + veranoPromoDetalle.getHoraDesde());
            System.out.println("Hora hasta: " + veranoPromoDetalle.getHoraHasta());

            // Mostrar cuál es la promoción más económica de las 3
            Promocion promocionMasEconomica = promociones.stream()
                    .min((p1, p2) -> Double.compare(p1.getPrecioPromocional(), p2.getPrecioPromocional()))
                    .orElse(null);
            System.out.println("La promoción más económica es: " + promocionMasEconomica.getDenominacion());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}
