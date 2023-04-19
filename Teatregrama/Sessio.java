package Teatregrama;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Sessio {
    private String obra;
    private static double preu;
    private static LocalTime horaInici;
    private static String dataFormatada;
    private Espectador[][] seients;
    private Butaca[][] butaques;

    public Sessio(String obra, double preu, int files, int columnes) {
        this.obra = obra;
        this.preu = preu;
        this.seients = new Espectador[files][columnes];
    }

    public Sessio(String dataFormatada, float preu2) {
    }

    public Sessio(String dataFormatada, LocalTime horaInici, double preu2) {
    }

    public Sessio(LocalDate data2, LocalTime hora2, double preu2) {
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
    public Espectador[][] getSeients() {
        return seients;
    }

    public boolean esSeientBuit(int fila, int columna) {
        return seients[fila][columna] == null;
    }

    public boolean assignarEspectador(int fila, int columna, Espectador espectador) {
        if (esSeientBuit(fila, columna)) {
            seients[fila][columna] = espectador;
            return true;
        } else {
            return false;
        }
    }

    public double calcularRecaptacio() {
        double recaptacio = 0;
        for (Espectador[] fila : seients) {
            for (Espectador espectador : fila) {
                if (espectador != null) {
                    recaptacio += preu;
                }
            }
        }
        return recaptacio;
    }

    public boolean esObraPerAdults() {
        return obra.contains("adults");
    }

    public boolean potEntrar(Espectador espectador) {
        return espectador != null && espectador.majorEdat() && (!esObraPerAdults() || espectador.esObraPerAdults());
    }
            public static void main(String[] args) {
            // Crear una sessió de teatre amb 3 files i 4 columnes de seients
            Sessio sessio = new Sessio(dataFormatada, horaInici, preu);
    
            // Crear espectadors i assignar-los a seients disponibles
            Espectador e1 = new Espectador("John", 25, false);
            Espectador e2 = new Espectador("Mary", 18, true);
            Espectador e3 = new Espectador("Bob", 35, true);
    
            sessio.assignarEspectador(0, 0, e1);
            sessio.assignarEspectador(1, 2, e2);
            sessio.assignarEspectador(2, 1, e3);
    
            // Mostrar la recaptació de la sessió
            System.out.println("Recaptació: " + sessio.calcularRecaptacio());
    
            // Provar la funció esObraPerAdults
            System.out.println("És obra per adults? " + sessio.esObraPerAdults());
    
            // Crear un espectador menor d'edat i comprovar si pot entrar a la sessió
            Espectador e4 = new Espectador("Alex", 16, true);
            System.out.println("Pot entrar el espectador Alex? " + sessio.potEntrar(e4));
        }

            public Espectador[] getEspectadors() {
                return null;
            }

            public String getDia() {
                return dataFormatada;
            }
            
            public LocalTime getHora() {
                return horaInici;
            }

            public void setEspectadors(Espectador[] espectadors) {
            }

            public boolean isPermesAcces(Espectador espectador) {
                return false;
            }

            public void afegirEspectador(Espectador espectador) {
            }

            public void setEspectadors(List<Espectador> espectadorsSessio) {
            }

            public Butaca[][] getButaques() {
                return this.butaques;
              }
              

            
    }
