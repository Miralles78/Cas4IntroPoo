import java.lang.reflect.Array;

public class Sessio {
    private String obra;
    private double preu;
    private int hora;
    private int dia;
    private Espectador[][] seients;

    public Sessio(String obra, double preu, int hora, int dia, int files, int columnes) {
        this.obra = obra;
        this.preu = preu;
        this.hora = hora;
        this.dia = dia;
        this.seients = new Espectador[files][columnes];
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

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public boolean esSeientBuit(int fila, int columna) {
        return seients[fila][columna] == null;
    }

    public boolean assignarSeient(int fila, int columna, Espectador espectador) {
        if (esSeientBuit(fila, columna) && espectador != null && espectador.potEntrar(preu)) {
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
    public static void main(String[] args){
        Espectador espectador1 = new Espectador(null, 0, 0);
        System.out.println(espectador1);
    }
}
