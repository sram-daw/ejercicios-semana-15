import java.util.ArrayList;
import java.util.Collections;


public class LigaFutbol implements Liga {
    //22 equipos
    String nombre;
    ArrayList<EquipoFutbol> equiposLiga = new ArrayList<>();
    int vuelta;
    int jornadasFaltan;

    int partidosFaltan;

    //462 partidos en total
    //231 partidos por vuelta
    //21 jornadas por vueltas
    public LigaFutbol(String nombre) {
        this.nombre = nombre;
        this.equiposLiga = crearLiga();
        this.vuelta = 1;
        this.jornadasFaltan = 42;
        this.partidosFaltan = 462;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<EquipoFutbol> getEquiposLiga() {
        return equiposLiga;
    }

    public void setEquiposLiga(ArrayList<EquipoFutbol> equiposLiga) {
        this.equiposLiga = equiposLiga;
    }

    public int getVuelta() {
        return vuelta;
    }

    public void setVuelta(int vuelta) {
        this.vuelta = vuelta;
    }

    public int getJornadasFaltan() {
        return jornadasFaltan;
    }

    public void setJornadasFaltan(int jornadasFaltan) {
        this.jornadasFaltan = jornadasFaltan;
    }

    //funciones
    @Override
    public String toString() {
        return "LigaFutbol{" +
                "nombre='" + nombre + '\'' +
                ", equiposLiga=" + equiposLiga +
                ", vuelta=" + vuelta +
                ", jornadasFaltan=" + jornadasFaltan +
                '}';
    }

    @Override
    public ArrayList crearLiga() {
        String[] nombres = {"Almería", "Athletic", "Atlético", "Barça", "Betis", "Cádiz", "Celta",
                "Elche", "Espanyol", "Getafe", "Girona", "Mallorca", "Osasuna", "R.Sociedad", "Rayo",
                "R.Madrid", "R.Valladolid", "Sevilla", "Valencia", "Villarreal", "Deportivo C.", "Real Random"};

        ArrayList<EquipoFutbol> equipos = new ArrayList<>();

        for (int i = 0; i < nombres.length; i++) {
            EquipoFutbol nuevoEquipo = new EquipoFutbol(i, nombres[i]);
            equipos.add(nuevoEquipo);
        }

        return equipos;
    }

    @Override
    public void simularLigaEntera(ArrayList<EquipoFutbol> listaEquipos) {
        /*EquipoFutbol equipoGanador;
        EquipoFutbol equipoPerdedor;*/
        /*boolean isEmpate = false;*/
        for (int equipoRef = 0; equipoRef < listaEquipos.size(); equipoRef++) {
            for (int equipoRival = 0; equipoRival < listaEquipos.size(); equipoRival++) {
                if (listaEquipos.get(equipoRef) != listaEquipos.get(equipoRival)) {
                    simularPartido(listaEquipos.get(equipoRef), listaEquipos.get(equipoRival));

                }
            }
        }
    }

    //devuelve el equipo ganador o null en caso de empate
    @Override
    public EquipoFutbol simularPartido(EquipoFutbol e1, EquipoFutbol e2) {
        e1.setGolesFavor((int) (Math.random() * 5));
        e2.setGolesFavor((int) (Math.random() * 5));
        e1.setGolesContra(e2.getGolesFavor());
        e2.setGolesContra(e1.getGolesFavor());
        e1.setPartidosJugados(e1.getPartidosJugados() + 1);
        e2.setPartidosJugados(e2.getPartidosJugados() + 1);
        this.partidosFaltan = this.partidosFaltan - 1;
        calcularJornadasFaltan();
        calcularVueltas();

        if (e1.getGolesFavor() > e2.getGolesFavor()) {
            e1.setPuntuacion(e1.getPuntuacion() + 3);
            e1.setVictorias(e1.getVictorias() + 1);
            e2.setDerrotas(e2.getDerrotas() + 1);
            return e1;
        } else if (e1.getGolesFavor() < e2.getGolesFavor()) {
            e2.setPuntuacion(e2.getPuntuacion() + 3);
            e2.setVictorias(e2.getVictorias() + 1);
            e1.setDerrotas(e1.getDerrotas() + 1);
            return e2;
        } else if (e1.getGolesFavor() == e2.getGolesFavor()) {
            e2.setPuntuacion(e2.getPuntuacion() + 1);
            e1.setPuntuacion(e1.getPuntuacion() + 1);
            e1.setEmpates(e1.getEmpates() + 1);
            e2.setEmpates(e2.getEmpates() + 1);
            return null;
        } else return null;
    }


    @Override
    public void simularJornada() {

       /* if (this.jornadasFaltan > 0) {


        }*/

    }


    @Override
    public void calcularVueltas() {
        if (this.partidosFaltan <= 231) {
            this.vuelta = 2;
        }
    }

    @Override
    public void calcularJornadasFaltan() {
        if (this.partidosFaltan % 11 == 0){
            this.jornadasFaltan = this.partidosFaltan / 11;
        }
    }


    @Override
    public void consultarTabla() {
        Collections.sort(equiposLiga);//podemos usar el método sort de collections tras haber implementado la interfaz Comparable en EquipoFutbol
        for (EquipoFutbol e : this.equiposLiga) {
            /*System.out.println("ID: "+e.getIdEquipo()+" "+e.getNombre() + " " + e.getPuntuacion() + " puntos.");*/ //test id
            System.out.println(e.getNombre() + " " + e.getPuntuacion() + " puntos.");
        }


    }


}
