import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//462 partidos en total
//231 partidos por vuelta
//21 jornadas por vueltas

        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        boolean isSalir = false;
        int eleccionMenu = 0;
        String nombreLiga = "";
        boolean isLiga = false;
        LigaFutbol nuevaLiga = null;

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
                    System.out.println(nuevaLiga.toString());//test
                } else {
                    System.out.println("Ya existe una liga.");
                }
            } else if (eleccionMenu == 2) {
                //jugar liga
                if (isLiga) {
                    System.out.println("Elija una opción: \n1. Jugar jornada \n2. Consultar tabla \n3. Pausar liga");
                    eleccionMenu = inputInt.nextInt();
                    if (eleccionMenu == 1) {
                        //de momento jugar toda la liga
                        nuevaLiga.simularLigaEntera(nuevaLiga.equiposLiga);
                    }
                    if (eleccionMenu == 2) {
                       /* for (EquipoFutbol e : nuevaLiga.equiposLiga) {
                            e.setPuntuacion((int)(Math.random()*100));
                        }*/ //test sort
                        nuevaLiga.consultarTabla();
                    }
                    if (eleccionMenu == 3) {
                        System.out.println("Volviendo atrás...");
                    }
                } else {
                    System.out.println("No hay ninguna liga creada.");
                }

            } else if (eleccionMenu == 3) {
                //eliminar liga actual
                System.out.println("eliminar liga");
            } else if (eleccionMenu == 4) {
                isSalir = true;
            }
        }


    }
}