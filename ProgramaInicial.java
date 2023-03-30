import java.util.Scanner;
import Teatregrama.*;

public class ProgramaInicial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fila = 0;
        int columna = 0;

        // Crear una instància d'Obra de teatre
        System.out.println("Introdueix el títol de l'obra:");
        String titol = scanner.nextLine();

        System.out.println("Introdueix la durada de l'obra en minuts:");
        int durada = scanner.nextInt();

        Obra obra = new Obra(titol, durada);

        // Crear uns quants espectadors
        System.out.println("Introdueix la informació dels espectadors:");
        System.out.println("(nom, edat, té diners per pagar l'entrada?)");

        Espectador[] espectadors = new Espectador[3];

        for (int i = 0; i < espectadors.length; i++) {
            scanner.nextLine(); // netejar el buffer de l'entrada anterior
            System.out.println("Espectador " + (i + 1) + ":");
            String nom = scanner.nextLine();
            int edat = scanner.nextInt();
            boolean teDiners = scanner.nextBoolean();

            espectadors[i] = new Espectador(nom, edat, teDiners);
        }

        // Crear un array de sessions
        System.out.println("Introdueix la informació de les sessions:");
        System.out.println("(obra, preu, hora, dia, files, columnes)");

        Sessio[] sessions = new Sessio[2];

        for (int i = 0; i < sessions.length; i++) {
            scanner.nextLine(); // netejar el buffer de l'entrada anterior
            System.out.println("Sessió " + (i + 1) + ":");

            String obraSessio = scanner.nextLine();
            double preu = scanner.nextDouble();
            int hora = scanner.nextInt();
            int dia = scanner.nextInt();
            int files = scanner.nextInt();
            int columnes = scanner.nextInt();

            sessions[i] = new Sessio(obraSessio, preu, hora, dia, files, columnes);
        }
        // Assignar espectadors a seients
for (int i = 0; i < sessions.length; i++) {
    System.out.println("Assignant espectadors a la sessió " + (i + 1) + ":");
    int j = 0; // indice para llevar seguimiento de espectadores disponibles
    for (fila = 0; fila < sessions[i].getSeients().length; fila++) {
        for (columna = 0; columna < sessions[i].getSeients()[fila].length; columna++) {
            if (sessions[i].esSeientBuit(fila, columna)) {
                if (j < espectadors.length && espectadors[j].teDiners() && espectadors[j].getEdat() >= 18) {
                    sessions[i].assignarEspectador(fila, columna, espectadors[j]);
                    System.out.println(espectadors[j].getNom() + " assignat al seient (" + fila + ", " + columna + ")");
                    j++; // actualizamos el indice para el siguiente espectador disponible
                }
            }
        }
    }
}

// Mostrar el pati de butaques
System.out.println("Pati de butaques:");
for (int i = 0; i < sessions.length; i++) {
    System.out.println("Sessió " + (i + 1) + ":");
    for (fila = 0; fila < sessions[i].getSeients().length; fila++) {
        for (columna = 0; columna < sessions[i].getSeients()[fila].length; columna++) {
            if (sessions[i].esSeientBuit(fila, columna)) {
                System.out.print("O ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.println();
    }
}

// Llistar les persones que han entrat a l'obra
System.out.println("Espectadors que han entrat a l'obra:");
for (Sessio sessio : sessions) {
    for (fila = 0; fila < sessio.getSeients().length; fila++) {
        for (columna = 0; columna < sessio.getSeients()[fila].length; columna++) {
            Espectador espectador = sessio.getSeients()[fila][columna];
            if (espectador != null) {
                System.out.println("Nom: " + espectador.getNom() +
                        ", Edat: " + espectador.getEdat() +
                        ", Dinners: " + espectador.getDiners() +
                        ", Fila: " + fila +
                        ", Columna: " + columna);
            }
        }
    }
}

    }
}