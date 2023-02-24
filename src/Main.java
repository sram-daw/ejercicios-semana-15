import java.util.Scanner;
import java.util.AbstractMap;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        boolean isSalir = false;
        boolean isSalirLiga = false;
        int eleccionMenu = 0;
        String nombreLiga = "";
        boolean isLiga = false; //true si existe una liga creada y false si no
        LigaFutbol nuevaLiga = null;
        int idEquipo = 0;

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
                    System.out.println("\033[43m" + "Ya existe una liga." + "\u001B[0m");
                }
            }
            if (eleccionMenu == 2) {//jugar liga. Solo se puede entrar al submenú si hay una liga creada.
                isSalirLiga = false;
                if (isLiga) {
                    while (!isSalirLiga) {
                        System.out.println("Elija una opción: \n1. Simular jornada \n2. Consultar tabla clasificatoria \n3. Estadísticas por equipo \n4. Consultar datos de la liga \n5. Pausar liga"); //añadir opción para consultar estadísticas por equipo
                        eleccionMenu = inputInt.nextInt();
                        if (eleccionMenu == 1) {
                            if (nuevaLiga.getJornadasFaltan() != 0 && isLiga == true) {
                                System.out.println(("\033[42m" + "Jornada disputada." + "\u001B[0m")); //códigos para el fondo verde y para finalizar el estilo aplicado, respectivamente
                                nuevaLiga.actualizadorParejasEquipos = nuevaLiga.simularJornada(nuevaLiga.equiposLiga, nuevaLiga.parejasEquipos); //el actualizador pasa a contener las entradas que devuelve el método simularJornada
                                nuevaLiga.parejasEquipos.addAll(nuevaLiga.actualizadorParejasEquipos);//se añaden las entradas del actualizador a parejasEquipos
                            } else {
                                System.out.println("\033[43m" + "No se pueden disputar más partidos porque la liga ha finalizado. Elimínala y crea otra para continuar." + "\u001B[0m");
                                isSalirLiga = true;
                            }
                        }
                        if (eleccionMenu == 2) {
                            nuevaLiga.consultarTabla();
                        }

                        if (eleccionMenu == 3) {
                            System.out.println("Escriba el ID del equipo que quiere consultar: ");
                            for (EquipoFutbol e : nuevaLiga.equiposLiga) {
                                System.out.println(e.getIdEquipo() + ". " + e.getNombre());
                            }
                            idEquipo = inputInt.nextInt();
                            nuevaLiga.consultarEstadisticasEquipo(nuevaLiga.equiposLiga.get(idEquipo));
                        }
                        if (eleccionMenu == 4) {
                            System.out.println(nuevaLiga.toString());
                        }
                        if (eleccionMenu == 5) {
                            System.out.println("Volviendo atrás...");
                            isSalirLiga = true;
                        }
                    }
                } else {
                    System.out.println("\033[41m" + "No hay ninguna liga creada." + "\u001B[0m");
                }
            }
            if (eleccionMenu == 3) {
                if (isLiga) {
                    nuevaLiga = null;
                    isLiga = false;
                    System.out.println("\033[42m" + "Liga eliminada con éxito." + "\u001B[0m");
                } else {
                    System.out.println("\033[41m" + "No hay ninguna liga creada." + "\u001B[0m");
                }
            }
            if (eleccionMenu == 4) {
                isSalir = true;
            }
        }
    }
}