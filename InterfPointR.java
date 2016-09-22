/**
 *@author CHARLES EMILE Ambinintsoa Fortunat, BEN SASSI Rached
 */
public interface InterfPointR{
    /**
     * Test si un point est inclu pr�cis�ment dans un PointR
     * @param p un Point
     * @return retourne un booléen
     * @see Point
     * @see PointR
     */
      public boolean inclu(Point p);
      
   /**
     * Test si un point est inclu dans un PointR (sp�cial d�placement).
     * @param p un Point
     * @return retourne un booléen
     * @see Point
     * @see PointR
     */
      public boolean incluMove(Point p);
}