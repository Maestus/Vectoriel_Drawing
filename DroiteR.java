import javax.swing.*;

public class DroiteR extends JPanel{
   /**
    *Point de départ de la droite
    */
   protected Point departDroite;
   /**
    *Point d'arrivé de la droite
    */
   protected Point arriveDroite;
   /**
    *Indice de départ de la droite
    */
   protected int indiceDepDroite;
   /**
    *Point d'arrivé de la droite
    */
   protected int indiceArrDroite;
   /**
    *Informe si la droite a été testé.
    */
   protected boolean estTestDr;
   
   /**
    *Constructeur de DroiteR
    */
   public DroiteR(int depXDroite, int depYDroite, int arrXDroite, int arrYDroite, int indiceDepDroite, int indiceArrDroite){
      this.departDroite = new Point(depXDroite,depYDroite);
      this.arriveDroite = new Point(arrXDroite,arrYDroite);
      this.indiceDepDroite = indiceDepDroite;
      this.indiceArrDroite = indiceArrDroite;
      this.estTestDr = false;
   }
   
   /**
    *Permet d'obtenir le coefficient directeur d'une droite pour son equation.
    *@return Retourne un double
    */
   public double coeffDir(){
      int posArrY = -this.arriveDroite.getY();
      int posDepY = -this.departDroite.getY();
      
      return ((double)(posArrY - posDepY) / (this.arriveDroite.getX()-this.departDroite.getX()));
   }
   
   /**
    *Permet d'obtenir la constante d'une droite pour son equation.
    *@return Retourne un double
    */
   public double constante(){
      int thisDepY = -this.departDroite.getY();
      return (-this.coeffDir() * this.departDroite.getX()) + thisDepY;
   }
   
   /**
    *Permet d'obtenir le point d'intersection de deux droites.
    *@return Retourne un PointR
    *@param DroiteR
    */
   public PointR ajoutPtIntersectDroite(DroiteR nvxDroite){
      int thisArrYDR = -this.arriveDroite.getY();
      int thisDepYDR = -this.departDroite.getY();
      int nvxDepYDR = -nvxDroite.departDroite.getY();      
      int nvxArrYDR = -nvxDroite.arriveDroite.getY();
      double addCoeffABDR = 0;
      double addABDR = 0;
      
      double coeffDirADR = ((double)(thisArrYDR - thisDepYDR) / (this.arriveDroite.getX()-this.departDroite.getX()));
      double pADR = (-coeffDirADR * this.departDroite.getX()) + thisDepYDR;
      
      double coeffDirBDR = ((double) (nvxArrYDR - nvxDepYDR) / (nvxDroite.arriveDroite.getX() - nvxDroite.departDroite.getX()));
      double pBDR = (-coeffDirBDR * nvxDroite.departDroite.getX()) + nvxDepYDR;
      
      coeffDirADR = -coeffDirADR;    //Pour le passage Ã  l'autre membre dans l'equation
      pBDR = -pBDR;                  //Pour le passage Ã  l'autre membre dans l'equation
      
      addCoeffABDR = coeffDirADR + coeffDirBDR;
      addABDR = pADR + pBDR;      
      int x = (int)(addABDR / addCoeffABDR);
      coeffDirADR = -coeffDirADR;
      int y = Math.abs((int)(coeffDirADR * x) + (int)pADR);
      System.out.println("Eq seg1 = "+coeffDirADR+"x + "+pADR);
      System.out.println("Eq seg2 = "+coeffDirBDR+"x + "+pBDR);
      System.out.println("INTERSECTION ("+x+";"+y+")");   
      return new PointR(x,y);
   }
   
   public static void main(String[] args){
      /*DroiteR d1 = new DroiteR(353,229,536,111,1,1);
      DroiteR d2 = new DroiteR(349,169,565,173,1,1);
      System.out.println("Coeff Dir 1 : "+d1.coeffDir()+" + "+d1.constante());
      System.out.println("Coeff Dir 2 : "+d2.coeffDir()+" + "+d2.constante());
      PointR p = d1.ajoutPtIntersectDroite(d2);
      System.out.println("("+p.centre.getX()+","+p.centre.getY()+")");*/
   }
}