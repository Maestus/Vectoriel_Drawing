/**
 *@author CHARLES EMILE Ambinintsoa Fortunat, BEN SASSI Rached
 */
public interface InterfPointR{
    /**
     * Test si un point est inclu précisément dans un PointR
     * @param p un Point
     * @return retourne un boolÃ©en
     * @see Point
     * @see PointR
     */
      public boolean inclu(Point p);
      
   /**
     * Test si un point est inclu dans un PointR (spécial déplacement).
     * @param p un Point
     * @return retourne un boolÃ©en
     * @see Point
     * @see PointR
     */
      public boolean incluMove(Point p);
}