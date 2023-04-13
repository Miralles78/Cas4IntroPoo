import java.util.Scanner;
import Teatregrama.*;

public class ProgramaInicial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

// Crear espectadors
System.out.print("Quants espectadors vols crear? ");
int numEspectadors = scanner.nextInt();
scanner.nextLine(); // Consumir la línia en blanc
Espectador[] espectadors = new Espectador[numEspectadors];
for (int i = 0; i < numEspectadors; i++) {
  System.out.println("Introdueix les dades de l'espectador " + (i+1) + ":");
  System.out.print("Nom: ");
  String nom = scanner.nextLine();
  System.out.print("Edat: ");
  int edat = scanner.nextInt();
  System.out.print("Diners que té: ");
  float diners = scanner.nextFloat();
  scanner.nextLine(); // Consumir la línia en blanc
  espectadors[i] = new Espectador(nom, edat, diners);
}

// Crear sessions
System.out.print("Quantes sessions vols crear? ");
int numSessions = scanner.nextInt();
scanner.nextLine(); // Consumir la línia en blanc
Sessio[] sessions = new Sessio[numSessions];
for (int i = 0; i < numSessions; i++) {
  System.out.println("Introdueix les dades de la sessió " + (i+1) + ":");
  System.out.print("Dia (dd/mm/aaaa): ");
  
    }
}
}