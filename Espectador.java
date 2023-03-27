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
  public static void main(String[] args){
    Espectador espectador1 = new Espectador("Navarro", 18, 1000);
    System.out.println(espectador1.toString());
    Espectador espectador2 = new Espectador(30, 2000);
    System.out.println(espectador2.toString());
    Espectador espectador3 = new Espectador(14, 100);
    System.out.println(espectador3.toString());
  }
}

