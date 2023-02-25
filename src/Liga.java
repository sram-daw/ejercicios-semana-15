import java.util.*;

public interface Liga <EquipoGenerico extends Equipo>{ /*lo que va entre <> indica que "EquipoGenerico" (que se usa en los métodos simularJornada y simularPartido) representa un objeto que
                                                hereda de la clase abstracta Equipo. Permite usar distintos objetos que hereden de dicha clase en cada implementación de forma más concreta.
                                                 Podría usarse, por ejemplo, un objeto EquipoBaloncesto en su implementación en una clase LigaBaloncesto. En cada implementación es necesario indicar
                                                 qué tipo de objeto se va a usar (ver comentario en LigaFutbol)*/

    ArrayList crearLiga();

    void calcularVueltas();

    void calcularJornadasFaltan();

    List<AbstractMap.SimpleEntry<EquipoGenerico, EquipoGenerico>> simularJornada(ArrayList<EquipoGenerico> listaEquipos, List<AbstractMap.SimpleEntry<EquipoGenerico, EquipoGenerico>> parejasJornadas);

    void simularPartido(EquipoGenerico e1, EquipoGenerico e2);

    void consultarTabla();

    void recorrerEquiposliga();


}
