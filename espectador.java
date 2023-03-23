public class espectador {
    private String nom;
    private int edat;
    private double diners;

  public void setName(String nom){
    this.nom = nom;
  }
  public void preuEntrada(int preu){
    preu = 5;
  }
    public static void main(String[] args) {
      espectador myObj = new espectador();
      myObj.setName("Miquel");
      myObj.edat = 14;
      myObj.diners = 1000;
      System.out.println("Nom: " + myObj.nom);
      System.out.println("Edat: " + myObj.edat);
      System.out.println("Diners:" + myObj.diners);
    }
  }