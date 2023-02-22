
public class EquipoFutbol extends Equipo implements Comparable<EquipoFutbol> {//necesario implementar la interfaz Comparable para ordenar los objetos del arraylist
    private int golesFavor;
    private int golesContra;


    public EquipoFutbol(int IdEquipo, String nombre, int partidosJugados, int victorias, int empates, int derrotas, int puntuacion, int golesFavor, int golesContra) {
        super(IdEquipo, nombre, partidosJugados, victorias, empates, derrotas, puntuacion);
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
    }

    //getters y setters
    public EquipoFutbol(int IdEquipo,String nombre) {
        super(IdEquipo,nombre);
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    //funciones
    @Override
    public int compareTo(EquipoFutbol o) {//método sobrecargado de la interfaz Comparable
        return o.getPuntuacion()-this.getPuntuacion(); //para ordenar descendentemente. Si quisiéramos ordenar ascendentemente invertimos la resta.
    }
}
