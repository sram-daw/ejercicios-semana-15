import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


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
        return "Datos de la liga{" +
                "nombre= '" + nombre + '\'' +
                ", vuelta= " + vuelta +
                ", jornadas por jugar= " + jornadasFaltan +
                '}';
    }

    public void recorrerEquiposliga() {
        System.out.println("Equipos de la liga: ");
        for (EquipoFutbol e : this.equiposLiga) {
            if (e.getNombre().equals("Real Random")) {
                System.out.print(e.getNombre() + ". ");
            } else
                System.out.print(e.getNombre() + ", ");
        }
        System.out.println();
    }

    @Override
    public ArrayList crearLiga() {
        String[] nombres = {"Almería", "Athletic", "Atlético", "Barça", "Betis", "Cádiz", "Celta",
                "Elche", "Espanyol", "Getafe", "Girona", "Mallorca", "Osasuna", "R.Sociedad", "Rayo",
                "R.Madrid", "R.Valladolid", "Sevilla", "Valencia", "Villarreal", "Deportivo C.", "Real Random"};

        ArrayList<EquipoFutbol> equipos = new ArrayList<>();

        for (int i = 0; i < nombres.length; i++) {
            EquipoFutbol nuevoEquipo = new EquipoFutbol(i, nombres[i]); //parámetros: id y nombre
            equipos.add(nuevoEquipo);
        }

        return equipos;
    }

    @Override
    public void simularJornada(ArrayList<EquipoFutbol> listaEquipos) {
        /*EquipoFutbol equipoGanador; //esto es por si se usa qué equipo gana en cada partido para dar la información al usuario
        /*EquipoFutbol equipoPerdedor;
        boolean isEmpate = false;*/
        int contadorPartidos = 0;
        System.out.println("Resultados: ");
        for (int equipoCasa = 0; equipoCasa < listaEquipos.size(); equipoCasa++) {
            for (int equipoRival = 0; equipoRival < listaEquipos.size(); equipoRival++) {
                if (listaEquipos.get(equipoCasa) != listaEquipos.get(equipoRival)) {
                    simularPartido(listaEquipos.get(equipoCasa), listaEquipos.get(equipoRival));
                }
            }
        }
    }

    //devuelve el equipo ganador o null en caso de empate
    @Override
    public EquipoFutbol simularPartido(EquipoFutbol e1, EquipoFutbol e2) { //en caso de no usar qué equipo gana en cada partido, se puede hacer void esta función
        e1.setGolesFavor((int) (Math.random() * 5));
        e2.setGolesFavor((int) (Math.random() * 5));
        /*System.out.println("Goles "+e1.getNombre()+": "+e1.getGolesFavor());
        System.out.println("Goles "+e2.getNombre()+": "+e2.getGolesFavor());*/ //mostrar resultados
        e1.setGolesContra(e2.getGolesFavor());
        e2.setGolesContra(e1.getGolesFavor());
        e1.setPartidosJugados(e1.getPartidosJugados() + 1);
        e2.setPartidosJugados(e2.getPartidosJugados() + 1);
        this.partidosFaltan--;
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
        } else {
            e2.setPuntuacion(e2.getPuntuacion() + 1);
            e1.setPuntuacion(e1.getPuntuacion() + 1);
            e1.setEmpates(e1.getEmpates() + 1);
            e2.setEmpates(e2.getEmpates() + 1);
            return null;
        }
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
        if (this.partidosFaltan % 11 == 0) {
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
