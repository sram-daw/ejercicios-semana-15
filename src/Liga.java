import java.util.*;

public interface Liga {

    ArrayList crearLiga();

    void calcularVueltas();

    void calcularJornadasFaltan();

    /*public List<AbstractMap.SimpleEntry<EquipoFutbol, EquipoFutbol>>  simularJornada(ArrayList<EquipoFutbol> listaEquipos, List<AbstractMap.SimpleEntry<EquipoFutbol, EquipoFutbol>> parejasJornadas);
    public EquipoFutbol simularPartido(EquipoFutbol e1, EquipoFutbol e2);
*/
    void consultarTabla();

    void recorrerEquiposliga();


}
