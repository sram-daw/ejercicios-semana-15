import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public interface Liga {

    ArrayList crearLiga();

    void calcularVueltas();

    void calcularJornadasFaltan();

    public void  simularJornada(ArrayList<EquipoFutbol> listaEquipos);
    public EquipoFutbol simularPartido(EquipoFutbol e1, EquipoFutbol e2);

    void consultarTabla();


}
