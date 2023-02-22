public abstract class Equipo {
    //Clase abstracta de la que heredarían otras hipotéticas clases de equipos de otros deportes.

    private int IdEquipo;
    private String nombre;
    private int partidosJugados;
    private int victorias;
    private int empates;
    private int derrotas;
    private int puntuacion;

    public Equipo() {
    }

    public Equipo(int IdEquipo, String nombre, int partidosJugados, int victorias, int empates, int derrotas, int puntuacion) {
        this.IdEquipo = IdEquipo;
        this.nombre = nombre;
        this.partidosJugados = partidosJugados;
        this.victorias = victorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.puntuacion = puntuacion;
    }

    public Equipo(int idEquipo, String nombre) {
        this.IdEquipo = idEquipo;
        this.nombre = nombre;
    }

    public int getIdEquipo() {
        return IdEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        IdEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
