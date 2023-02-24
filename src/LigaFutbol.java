import java.util.ArrayList;
import java.util.Collections;
import java.util.AbstractMap;
import java.util.List;

public class LigaFutbol implements Liga {
    //22 equipos
    String nombre;
    ArrayList<EquipoFutbol> equiposLiga = new ArrayList<>();
    int vuelta;
    int jornadasFaltan;

    int partidosFaltan;

    List<AbstractMap.SimpleEntry<EquipoFutbol, EquipoFutbol>> parejasEquipos = new ArrayList<>();//lleva la cuenta total de qué parejas de equipos han jugado entre sí
    List<AbstractMap.SimpleEntry<EquipoFutbol, EquipoFutbol>> actualizadorParejasEquipos = new ArrayList<>();//se usa en el return de la función simularJornada para devolverlas parejas de equipos que jugaron una jornada concreta.

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

    public int getPartidosFaltan() {
        return partidosFaltan;
    }

    public void setPartidosFaltan(int partidosFaltan) {
        this.partidosFaltan = partidosFaltan;
    }

    public List<AbstractMap.SimpleEntry<EquipoFutbol, EquipoFutbol>> getParejasEquipos() {
        return parejasEquipos;
    }

    public void setParejasEquipos(List<AbstractMap.SimpleEntry<EquipoFutbol, EquipoFutbol>> parejasEquipos) {
        this.parejasEquipos = parejasEquipos;
    }

    public List<AbstractMap.SimpleEntry<EquipoFutbol, EquipoFutbol>> getActualizadorParejasEquipos() {
        return actualizadorParejasEquipos;
    }

    public void setActualizadorParejasEquipos(List<AbstractMap.SimpleEntry<EquipoFutbol, EquipoFutbol>> actualizadorParejasEquipos) {
        this.actualizadorParejasEquipos = actualizadorParejasEquipos;
    }

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
                ", partidos por jugar= " + partidosFaltan +
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

    public List<AbstractMap.SimpleEntry<EquipoFutbol, EquipoFutbol>> simularJornada(ArrayList<EquipoFutbol> listaEquipos, List<AbstractMap.SimpleEntry<EquipoFutbol, EquipoFutbol>> parejasJornadas) {
        int contadorPartidos = 1;
        System.out.println("Resultados: ");
        while (contadorPartidos < 12 && (this.jornadasFaltan > 21 || this.vuelta == 2)) { //la condición de las jornadas determina por qué vuelta va la ejecución
            boolean isMismoEquipo = false;
            int equipoRef = (int) (Math.random() * listaEquipos.size()); //se generan números aleatorios dentro del tamaño del arraylist de equipos para que los enfrentamientos sean aleatorios también
            int equipoRival = (int) (Math.random() * listaEquipos.size());
            if (equipoRef == equipoRival) {
                isMismoEquipo = true; // para evitar que el equipo se enfrente a sí mismo
            }
            if (!isMismoEquipo && !(parejasJornadas.contains(new AbstractMap.SimpleEntry<>(listaEquipos.get(equipoRef), listaEquipos.get(equipoRival)))
                    || parejasJornadas.contains(new AbstractMap.SimpleEntry<>(listaEquipos.get(equipoRival), listaEquipos.get(equipoRef))))) {
                simularPartido(listaEquipos.get(equipoRef), listaEquipos.get(equipoRival));
                contadorPartidos++;
                parejasJornadas.add(new AbstractMap.SimpleEntry<>(listaEquipos.get(equipoRef), listaEquipos.get(equipoRival)));
                System.out.println(listaEquipos.get(equipoRef).getNombre() + " " + listaEquipos.get(equipoRef).getGolesFavor() + " - " + listaEquipos.get(equipoRival).getGolesFavor() + " " + listaEquipos.get(equipoRival).getNombre());
            }
        }
        if (this.jornadasFaltan == 21) {
            this.parejasEquipos.clear();//se limpia la lista de parejas de equipo para dar comienzo a la segunda vuelta
            System.out.println( "\033[42m" + "La primera vuelta ha finalizado. Para continuar con la segunda, simula una jornada. Esta es la clasificación hasta el momento: " + "\u001B[0m");
            consultarTabla();
        } else if (this.jornadasFaltan == 0) {
            System.out.println("\033[42m" + "La liga ha finalizado. Esta es la clasificación definitiva: " + "\u001B[0m");
            consultarTabla();
        }
        return parejasJornadas;
    }


    //devuelve el equipo ganador o null en caso de empate
    @Override
    public EquipoFutbol simularPartido(EquipoFutbol e1, EquipoFutbol e2) { //en caso de no usar qué equipo gana en cada partido, se puede hacer void esta función.
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
        ArrayList<EquipoFutbol> listaEquiposOrdenada = new ArrayList<>(); //es necesario crear una lista auxiliar para ordenar los equipos de forma provisional para consultar la tabla; de lo contrario cuando se quiere consultar estadísticas por equipo en la lista que se muestra salen desordenados los id.
        listaEquiposOrdenada.addAll(this.equiposLiga);
        Collections.sort(listaEquiposOrdenada);//podemos usar el método sort de collections tras haber implementado la interfaz Comparable en EquipoFutbol
        for (EquipoFutbol e : listaEquiposOrdenada) {
            /*System.out.println("ID: "+e.getIdEquipo()+" "+e.getNombre() + " " + e.getPuntuacion() + " puntos.");*/ //test id
            System.out.println(e.getNombre() + " " + e.getPuntuacion() + " puntos.");
        }
    }

    public void consultarEstadisticasEquipo(EquipoFutbol equipoAConsultar) {
        System.out.println("\033[42m" + "Estadísticas del " + equipoAConsultar.getNombre() + ": " + "\u001B[0m");
        System.out.println("Victorias: " + equipoAConsultar.getVictorias());
        System.out.println("Derrotas: " + equipoAConsultar.getDerrotas());
        System.out.println("Empates: " + equipoAConsultar.getEmpates());
        System.out.println("Partidos jugados: " + equipoAConsultar.getPartidosJugados());
        System.out.println("Puntuación: " + equipoAConsultar.getPuntuacion());
    }


}
