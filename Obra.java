public class Obra {
    private String titol;
    private int durada;
    private String autor;
    private boolean MajorEdat;

    public Obra(String titol, int durada, String autor, boolean MajorEdat) {
        this.titol = titol;
        this.durada = durada;
        this.autor = autor;
        this.MajorEdat = MajorEdat;
    }
    public Obra(String titol, int durada, String autor) {
        this(titol, durada, autor,true);
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
        return MajorEdat;
    }

    public void setPerMajorEdat(boolean perMajorEdat) {
        this.MajorEdat = perMajorEdat;
    }


    @Override
    public String toString() {
        return "Obra|" +
                "Titol:'" + titol + '\'' +
                ", Durada:" + durada +
                ", Autor:'" + autor + '\'' +
                ", Per a Majors d'Edat=" + MajorEdat +
                '|';
    }
    
    public static void main(String[] args) {
        Obra obra1 = new Obra("La casa de Bernarda Alba", 90, "Federico García Lorca");
        Obra obra2 = new Obra("El pati", 120, "Jordi Galceran");
        obra1.setPerMajorEdat(false);
        System.out.println(obra1);

        obra2.setPerMajorEdat(true);
        System.out.println(obra2);
    }
}

