/**
 *@author BEN SASSI Rached, CHARLES EMILE Ambinintsoa Fortunat
 */
public interface InterfPoint{
   /**
    * retourne la valeur contenu dans x
    * @return retourne un entier
    */
   public int getX();
   
   /**
    * retourne la valeur contenu dans y
    * @return retourne un entier
   */
   
   public int getY();
   
   /**
    * Modifie la valeur de x
    * @param nvxX un entier
    */
   
   public void setX(int nvxX);
   
   /**
    * Modifie la valeur de y
    * @param nvxY un entier
    */
   
   public void setY(int nvxY);
   /**
    * Donne la distance entre deux Points.
    * @param p un Point connu par ses coordonnées (x,y)
    * @see Point
    * @see PointR
    * @return retourne un double 
    */
   public double distance2P(Point p);
   
   /**
    * @return retourne un String
    */
    
   @Override
   public String toString();
}
   