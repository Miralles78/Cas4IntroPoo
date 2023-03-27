public class Espectador {
  private String nom;
  private int edat;
  private double diners;

  public Espectador(String nom, int edat, double diners) {
      this.nom = nom;
      this.edat = edat;
      this.diners = diners;
  }

  public Espectador(int edat, double diners) {
      this("anonim", edat, diners);
  }

  public Espectador(double diners) {
      this("anonim", 99, diners);
  }

  public String getNom() {
      return nom;
  }

  public void setNom(String nom) {
      this.nom = nom;
  }

  public int getEdat() {
      return edat;
  }

  public void setEdat(int edat) {
      this.edat = edat;
  }

  public double getDiners() {
      return diners;
  }

  public void setDiners(double diners) {
      this.diners = diners;
  }

  public void pagarEntrada(double preuEntrada) {
      diners -= preuEntrada;
  }

  public boolean majorEdat() {
      return edat >= 18;
  }

  public boolean teDiners(double preuEntrada) {
      return diners >= preuEntrada;
  }

  public String toString() {
      return nom + " té " + edat + " anys i " + diners + " euros.";
  }
    public static void main(String[] args) {
        Espectador espectador1 = new Espectador("Jordi", 23, 50.0);
        Espectador espectador2 = new Espectador(17, 30.0);
        Espectador espectador3 = new Espectador(100.0);

        double preuEntrada = 10.0;

        if (espectador1.majorEdat() && espectador1.teDiners(preuEntrada)) {
            espectador1.pagarEntrada(preuEntrada);
            System.out.println(espectador1.getNom() + " ha comprat una entrada.");
        } else {
            System.out.println(espectador1.getNom() + " no pot comprar una entrada.");
        }

        if (espectador2.majorEdat() && espectador2.teDiners(preuEntrada)) {
            espectador2.pagarEntrada(preuEntrada);
            System.out.println(espectador2.getNom() + " ha comprat una entrada.");
        } else {
            System.out.println(espectador2.getNom() + " no pot comprar una entrada.");
        }

        if (espectador3.majorEdat() && espectador3.teDiners(preuEntrada)) {
            espectador3.pagarEntrada(preuEntrada);
            System.out.println(espectador3.getNom() + " ha comprat una entrada.");
        } else {
            System.out.println(espectador3.getNom() + " no pot comprar una entrada.");
        }
    }
}

