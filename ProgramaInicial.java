import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Teatregrama.*;

public class ProgramaInicial {
    public static void main(String[] args) {
        String[][] butaca = new String[10][10];
        Scanner scanner = new Scanner(System.in);
        LocalDate data = LocalDate.now();
        String dataFormatada;
        String horaInici = "";
        int numEspectadors;
        float preu = 0;
        int columna;
        int fila;
        int edat = 0;

        // Crear obra
        System.out.println("Introdueix les dades de l'obra:");
        System.out.print("Títol: ");
        String titol = scanner.nextLine();
        System.out.print("Durada (en minuts): ");
        int durada = scanner.nextInt();
        scanner.nextLine(); // Consumir la línia en blanc
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Per a majors de 18 anys (s/n): ");
        boolean perAdults = scanner.nextLine().equalsIgnoreCase("s");
        Obra obra = new Obra(titol, durada, autor, perAdults);
       
        // Crear sessions
        System.out.print("Quantes sessions vols crear? ");
        int numSessions = scanner.nextInt();
        scanner.nextLine(); // Consumir la línia en blanc
        Sessio[] sessions = new Sessio[numSessions];
        for (int i = 0; i < numSessions; i++) {
            System.out.println("Introdueix les dades de la sessió " + (i + 1) + ":");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataFormatada = data.format(dateFormatter);
            System.out.println("Dia (dd/mm/aaaa): " + dataFormatada);
            System.out.print("Hora d'inici (format 24 hores, hh:mm): ");
            horaInici = scanner.nextLine();
            //DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            //horaInici = LocalTime.parse(horaIniciString, timeFormatter);
            System.out.print("Preu de l'entrada: ");
            preu = scanner.nextFloat();
            scanner.nextLine(); // Consumir la línia en blanc
            sessions[i] = new Sessio(dataFormatada, preu);
        }

        // Crear espectadors
        System.out.print("Quants espectadors vols crear? ");
        numEspectadors = scanner.nextInt();
        scanner.nextLine(); // Consumir la línia en blanc
        Espectador[] espectadorsInserits = new Espectador[numEspectadors];
        Espectador[] espectadorsAdults = new Espectador[numEspectadors]; // Nuevo arreglo para espectadores mayores de edad
        int numEspectadorsAdults = 0; // Nuevo contador para llevar la cuenta de espectadores mayores de edad
        for (int i = 0; i < numEspectadors; i++) {
            System.out.println("Introdueix les dades de l'espectador " + (i + 1) + ":");
            System.out.print("Nom: ");
            String nom = scanner.nextLine();
            System.out.print("Edat: ");
            edat = scanner.nextInt();
            System.out.print("Diners que té: ");
            float diners = scanner.nextFloat();
            scanner.nextLine(); // Consumir la línia en blanc
            
            
            if (diners < preu){
            System.out.println("No té diners suficients per pagar l'entrada");
                continue;
            }
            Espectador espectador = new Espectador(nom, edat, diners);
            if (edat >= 18 || !perAdults) { // Comprobar si el espectador es mayor de edad y si la obra es para mayores de 18 años
                espectadorsAdults[numEspectadorsAdults] = espectador; // Agregar al arreglo de espectadores mayores de edad
                numEspectadorsAdults++;
                diners = diners - preu;
                System.out.println("Ara te queden " + diners + "€"); // Incrementar el contador de espectadores mayores de edad
                // Aplicar el preu de l'entrada al diner de l'espectador
                // Aplicar el preu de l'entrada al diner de l'espectador
                
            } else {
                System.out.println("L'espectador " + nom + " no pot veure aquesta obra.");
            }
            espectadorsInserits[i] = espectador;
        }
        System.out.println("Posicio Butaca: ");
        if (perAdults = true) {
    for (int j = 0; j < espectadorsInserits.length; j++) {
        while (true) {
            System.out.print("Fica una fila entre el valor 0 i " + (butaca.length - 1) + "): ");
            fila = scanner.nextInt();
            System.out.print("Fica una columna entre el valor 0 i  " + (butaca[0].length - 1) + "): ");
            columna = scanner.nextInt();
            if (fila >= 0 && fila < butaca.length && columna >= 0 && columna < butaca[0].length) {
                if (butaca[fila][columna] != null) {
                    System.out.println("¡La butaca ya está ocupada!");
                    continue; // Reiniciamos el bucle sin ejecutar la asignación
                }
                if (edat >= 18) {
                    butaca[fila][columna] = String.valueOf(j+1);
                    break; // Salimos del bucle si la asignación ha sido exitosa
                }
            } else {
                System.out.println("Ubicación inválida.");
                continue;
            }
        }
    }
} else if(perAdults = false){
    for (int j = 0; j < espectadorsInserits.length; j++) {
        while (true) {
            System.out.print("Fica una fila entre el valor 0 i " + (butaca.length - 1) + "): ");
            fila = scanner.nextInt();
            System.out.print("Fica una columna entre el valor 0 i  " + (butaca[0].length - 1) + "): ");
            columna = scanner.nextInt();

            if (fila >= 0 && fila < butaca.length && columna >= 0 && columna < butaca[0].length) {
                if (butaca[fila][columna] != null) {
                    System.out.println("¡La butaca ya está ocupada!");
                    continue; // Reiniciamos el bucle sin ejecutar la asignación
                }
                butaca[fila][columna] = String.valueOf(j+1);
                break; // Salimos del bucle si la asignación ha sido exitosa
            } else {
                System.out.println("Ubicación inválida.");
                continue;
            }
        }
    }
}

        for (Sessio sessio : sessions) {
            dataFormatada = sessio.getDia();
            dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println("Llista d'espectadors per a la sessió del " + dataFormatada + " a les " + horaInici + ":");
            
            

        }
        if (perAdults){
            for (int i = 0; i < numEspectadorsAdults; i++) {
                System.out.println("- " + espectadorsAdults[i].getNom() + " (" + espectadorsAdults[i].getEdat() + " anys)");
              }
        }

        else if(espectadorsInserits != null) {
            System.out.println("Els espectadors introduïts són:");
            for (int i = 0; i < numEspectadors; i++) {
                System.out.println("- " + espectadorsInserits[i].getNom() + " (" + espectadorsInserits[i].getEdat() + " anys)");
              }
    } else{
        System.out.println("- No hi ha espectadors per a aquesta sessió");
    }
    System.out.println();
    System.out.println("Butaca ocupada o sense ocupar: ");

    for(fila = 0;fila<butaca.length;fila++)
    {
        for ( columna = 0; columna < butaca[fila].length; columna++) {
            if (butaca[fila][columna] != null) {
                System.out.print("X ");
            } else {
                System.out.print("O ");
            }
        }
        System.out.println();
    }
}

}