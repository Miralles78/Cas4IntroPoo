import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Teatregrama.*;

public class ProgramaInicial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate data = LocalDate.now();
        String dataFormatada;
        LocalTime horaInici;
        int numEspectadors;
        float preu = 0;

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
            String horaIniciString = scanner.nextLine();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            horaInici = LocalTime.parse(horaIniciString, timeFormatter);
            System.out.print("Preu de l'entrada: ");
            preu = scanner.nextFloat();
            scanner.nextLine(); // Consumir la línia en blanc
            sessions[i] = new Sessio(dataFormatada, horaInici, preu);
        }

        // Crear espectadors
        System.out.print("Quants espectadors vols crear? ");
        numEspectadors = scanner.nextInt();
        scanner.nextLine(); // Consumir la línia en blanc
        Espectador[] espectadorsInserits = new Espectador[numEspectadors];
        for (int i = 0; i < numEspectadors; i++) {
            System.out.println("Introdueix les dades de l'espectador " + (i + 1) + ":");
            System.out.print("Nom: ");
            String nom = scanner.nextLine();
            System.out.print("Edat: ");
            int edat = scanner.nextInt();
            System.out.print("Diners que té: ");
            float diners = scanner.nextFloat();
            scanner.nextLine(); // Consumir la línia en blanc
            Espectador espectador = new Espectador(nom, edat, diners);
            espectadorsInserits[i] = espectador;
            if (edat >= 18 || !perAdults) { // Comprobar si el espectador es mayor de edad y si la obra es para mayores de 18 años
                espectadorsInserits[i] = espectador;
                // Aplicar el preu de l'entrada al diner de l'espectador
                diners = diners - preu;
                System.out.println("Ara te queden " + diners + "€");
            } else {
                System.out.println("L'espectador " + nom + " no pot veure aquesta obra.");
            }
        }

        for (Sessio sessio : sessions) {
            dataFormatada = sessio.getDia();
            dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            horaInici = sessio.getHora();
            System.out.println("Llista d'espectadors per a la sessió del " + dataFormatada + " a les " + horaInici + ":");
            Espectador[] espectadorsSessio = sessio.getEspectadors();
            if (espectadorsSessio != null) {
                for (Espectador espectador : espectadorsSessio) {
                    System.out.println("- " + espectador.getNom() + " (" + espectador.getEdat() + " anys)");
                }
            } else {
                System.out.println("- No hi ha espectadors per a aquesta sessió");
            }
            System.out.println();

        }
    }
}