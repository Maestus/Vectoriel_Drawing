import javax.swing.*;
/**
 *@author CHARLES EMILE Ambinintsoa Fortunat, BEN SASSI Rached
 */
public class PointR extends JPanel implements InterfPointR{
    /**
     * Le rayon du PointR
     */
   protected double rayon;
   /**
    * la position du PointR
    * @see Point
    */
   protected Point centre;
   /**
    * Informe si le point est selectionn� ou non.
    */
   protected boolean select;
   /**
    * Constructeur de PointR
    * @param x un entier
    * @param y un entier
    */
   public PointR(int x, int y){
      this.centre = new Point(x,y);
      this.rayon = 5;
      this.select = false;
   }
   /**
    * Vérifie si le Point donné en argument est inclu dans un PointR
    * @param p un Point
    * @return retourne un booléen
    * @see Point 
    */
   public boolean inclu(Point p){
      return (this.centre.distance2P(p) <= this.rayon);
   }
   
   public boolean incluMove(Point p){
      return (this.centre.distance2P(p) <= this.rayon*4);
   }
}