import java.util.ArrayList;

public interface Liga {

    ArrayList crearLiga();

    void calcularVueltas();

    void calcularJornadasFaltan();

    public void simularLigaEntera(ArrayList<EquipoFutbol> listaEquipos);
    public EquipoFutbol simularPartido(EquipoFutbol e1, EquipoFutbol e2);
    void simularJornada();

    void consultarTabla();

}
