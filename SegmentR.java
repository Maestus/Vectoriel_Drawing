import javax.swing.*;
/**
 *@author CHARLES EMILE Ambinintsoa Fortunat, BEN SASSI Rached
 */
public class SegmentR extends JPanel{
    /**
     * Point du départ du Segment
     * @see Point
     */
   protected Point departSeg;
   /**
    * Point d'arrivé du Segment
    * @see Point
    */
   protected Point arriveSeg;
   /**
    * indice du départ
    */
   protected int indiceDepSeg;
   /**
    * indice du Segment
    */
   protected int indiceArrSeg;
   /**
    * Vrai si le segment a été testé pour une intersection
    * Faux Sinon
    */
   protected boolean estTestSeg;
   /**
    * Le point d'intersection
    * @see PointR
    */
   protected PointR intersectPoint;
   /**
    * Constructeur
    * @param departX un entier
    * @param departY un entier
    * @param arriveX un entier
    * @param arriveY un entier
    * @param indiceDepSeg un entier
    * @param indiceArrSeg un entier
    */
   public SegmentR(int departX, int departY, int arriveX, int arriveY, int indiceDepSeg, int indiceArrSeg){
      this.departSeg = new Point(departX, departY);
      this.arriveSeg = new Point(arriveX, arriveY);
      this.indiceDepSeg = indiceDepSeg;
      this.indiceArrSeg = indiceArrSeg;
      this.estTestSeg = false;
   }
   /**
    * Test si deux Segements s'intersectent
    * @param nvxSegment de type SegementR
    * @return retourne un booléen
    */
   public boolean intersectSeg(SegmentR nvxSegment){
      int thisArrY = -this.arriveSeg.getY();
      int thisDepY = -this.departSeg.getY();
      int nvxDepY = -nvxSegment.departSeg.getY();      
      int nvxArrY = -nvxSegment.arriveSeg.getY();
      double addCoeffAB = 0;
      double addAB = 0;
      
      double coeffDirA = ((double)(thisArrY - thisDepY) / (this.arriveSeg.getX()-this.departSeg.getX()));
      double pA = (-coeffDirA * this.departSeg.getX()) + thisDepY;
      
      double coeffDirB = ((double) (nvxArrY - nvxDepY) / (nvxSegment.arriveSeg.getX() - nvxSegment.departSeg.getX()));
      double pB = (-coeffDirB * nvxSegment.departSeg.getX()) + nvxDepY;
      
      double xCommun = ((double)(pB-pA) / (coeffDirA-coeffDirB));
      /*if(this.departSeg.getX() <= xCommun && xCommun >=thisArrY && nvxSegment.departSeg.getX() <= xCommun && xCommun >= nvxArrY){
         System.out.println("SE CROISENT !!");
         return true;
      }*/
      if(this.departSeg.getX() <= xCommun && nvxSegment.departSeg.getX() <= xCommun 
         && this.arriveSeg.getX() >= xCommun && nvxSegment.arriveSeg.getX() >= xCommun){
         System.out.println("SE CROISENT !!");
         return true;
      }
      System.out.println("NE SE CROISENT PAS !!");
      return false;
   }
   /**
    * Crée le PointR d'intersection
    * @param nvxSegment de type SegmentR
    * @return un PointR
    */
   public PointR ajoutPtIntersect(SegmentR nvxSegment){
      int thisArrY = -this.arriveSeg.getY();
      int thisDepY = -this.departSeg.getY();
      int nvxDepY = -nvxSegment.departSeg.getY();      
      int nvxArrY = -nvxSegment.arriveSeg.getY();
      double addCoeffAB = 0;
      double addAB = 0;
      
      double coeffDirA = ((double)(thisArrY - thisDepY) / (this.arriveSeg.getX()-this.departSeg.getX()));
      double pA = (-coeffDirA * this.departSeg.getX()) + thisDepY;
      
      double coeffDirB = ((double) (nvxArrY - nvxDepY) / (nvxSegment.arriveSeg.getX() - nvxSegment.departSeg.getX()));
      double pB = (-coeffDirB * nvxSegment.departSeg.getX()) + nvxDepY;
      
      coeffDirA = -coeffDirA;    //Pour le passage à l'autre membre dans l'equation
      pB = -pB;                  //Pour le passage à l'autre membre dans l'equation
      
      addCoeffAB = coeffDirA + coeffDirB;
      addAB = pA + pB;      
      int x = (int)(addAB / addCoeffAB);
      coeffDirA = -coeffDirA;
      int y = Math.abs((int)(coeffDirA * x) + (int)pA);
      System.out.println("Eq seg1 = "+coeffDirA+"x + "+pA);
      System.out.println("Eq seg2 = "+coeffDirB+"x + "+pB);
      System.out.println("INTERSECTION ("+x+";"+y+")");   
      return new PointR(x,y);
   }
   /**
    * Le main
    * @param args 
    */
   public static void main(String[]args){
      SegmentR s1 = new SegmentR(353,229,536,111,1,1);
      SegmentR s2 = new SegmentR(349,169,565,173,1,1);
      PointR p = s1.ajoutPtIntersect(s2);
      System.out.println(s1.intersectSeg(s2));
   }
}