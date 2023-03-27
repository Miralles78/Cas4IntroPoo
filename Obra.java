public class Obra {
    private String titol;
    private int durada;
    private String autor;
    private boolean perMajorEdat;

    public Obra(String titol, int durada, String autor, boolean perMajorEdat) {
        this.titol = titol;
        this.durada = durada;
        this.autor = autor;
        this.perMajorEdat = perMajorEdat;
    }

    public Obra(String titol, int durada, String autor) {
        this(titol, durada, autor, false);
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPerMajorEdat() {
        return perMajorEdat;
    }

    public void setPerMajorEdat(boolean perMajorEdat) {
        this.perMajorEdat = perMajorEdat;
    }

    @Override
    public String toString() {
        return "Obra{" +
                "titol='" + titol + '\'' +
                ", durada=" + durada +
                ", autor='" + autor + '\'' +
                ", perMajorEdat=" + perMajorEdat +
                '}';
    }
    
    public static void main(String[] args) {
        Obra obra1 = new Obra("La casa de Bernarda Alba", 90, "Federico García Lorca", true);
        Obra obra2 = new Obra("El pati", 120, "Jordi Galceran");

        System.out.println(obra1);
        System.out.println(obra2);

        obra2.setPerMajorEdat(true);
        System.out.println(obra2.isPerMajorEdat());
    }
}

