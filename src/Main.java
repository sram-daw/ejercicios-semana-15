import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//462 partidos en total
//231 partidos por vuelta
//21 jornadas por vueltas

        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        boolean isSalir = false;
        boolean isSalirLiga = false;
        int eleccionMenu = 0;
        String nombreLiga = "";
        boolean isLiga = false;
        LigaFutbol nuevaLiga = null;
        HashMap<EquipoFutbol, EquipoFutbol> parejasEquipos = new HashMap<>();//lleva la cuenta total de qué parejas de equipos han jugado entre sí
        HashMap<EquipoFutbol, EquipoFutbol> actualizadorParejasEquipos = new HashMap<>(); //se usa en el return de la función simularJornada para devolverlas parejas de equipos que jugaron una jornada concreta. Actualiza parejasEquipos
        while (!isSalir) {
            System.out.println("Bienvenid@ a La Liga. ¿Qué desea hacer? \n1. Crear una nueva liga \n2. Jugar liga \n3. Eliminar liga actual. \n4. Salir");
            eleccionMenu = inputInt.nextInt();

            if (eleccionMenu == 1) {
                if (!isLiga) {
                    System.out.println("Introduce el nombre de la liga: ");
                    nombreLiga = inputString.nextLine();
                    nuevaLiga = new LigaFutbol(nombreLiga);
                    System.out.println("Se ha creado la liga " + nuevaLiga.getNombre());
                    isLiga = true;
                    System.out.println(nuevaLiga);//test
                    nuevaLiga.recorrerEquiposliga();
                } else {
                    System.out.println("Ya existe una liga.");
                }
            } else if (eleccionMenu == 2) {
                isSalirLiga = false;
                while (!isSalirLiga) {
                    //jugar liga
                    if (isLiga) {
                        System.out.println("Elija una opción: \n1. Simular jornada \n2. Consultar tabla \n3. Pausar liga");
                        eleccionMenu = inputInt.nextInt();
                        if (eleccionMenu == 1) {

                            actualizadorParejasEquipos = nuevaLiga.simularJornada(nuevaLiga.equiposLiga, parejasEquipos);
                            parejasEquipos.putAll(actualizadorParejasEquipos); //se actualiza el hashmap con las parejas de equiposque ya han jugado, añadiendo los objetos almacenados en actualizadorParejasEquipos.

                            /* nuevaLiga.simularJornada(nuevaLiga.equiposLiga, parejasEquipos);*/
                            //test hash map
                         /*   for (Map.Entry<EquipoFutbol,EquipoFutbol> entrada: parejasEquipos.entrySet()) { //forma de iterar sobre un hashmap con un foreach
                                System.out.print(entrada.getValue().getNombre()+", ");
                                System.out.println();
                            }*/

                        }
                        if (eleccionMenu == 2) {
                       /* for (EquipoFutbol e : nuevaLiga.equiposLiga) {
                            e.setPuntuacion((int)(Math.random()*100));
                        }*/ //test sort
                            nuevaLiga.consultarTabla();
                        }
                        if (eleccionMenu == 3) {
                            System.out.println("Volviendo atrás...");
                            isSalirLiga = true;
                        }

                    } else {
                        System.out.println("No hay ninguna liga creada.");
                    }
                }

            } else if (eleccionMenu == 3) {
                nuevaLiga = null;
                isLiga = false;
                System.out.println("Liga eliminada con éxito.");
            } else if (eleccionMenu == 4) {
                isSalir = true;
            }
        }


    }
}