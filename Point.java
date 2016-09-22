/**
 *@author CHARLES EMILE Ambinintsoa Fortunat, BEN SASSI Rached
 */
public class Point implements InterfPoint{
   /**
   * determine la position x du Point 
   */
   private int x;
   /**
    * determine la position y du Point 
    */
   private int y;
   /**
    * Constructeur qui crée un Point de coordonnée le couple (x,y)
    * @param x un entier
    * @param y un entier
    */
   public Point(int x,int y){
      this.x = x;
      this.y = y;
   }
   /**
    * Retourne x
    * @return retourne un entier
    */
   public int getX(){
      return this.x;
   }
   /**
    * Retourne y
    * @return retourne un entier
    */
   public int getY(){
      return this.y;
   }
   /**
    * Modifie la valeur de x
    * @param nvxX un entier
    */
   public void setX(int nvxX){
      this.x = nvxX;
   }
   /**
    * Modifie la valeur de x
    * @param nvxY un entier
    */
   public void setY(int nvxY){
      this.y = nvxY;
   }
   /**
    * Calcul la distance entre deux Point
    * @param p un Point
    * @return retourne un double
    * @see Point
    * @see PointR
    */
   public double distance2P(Point p){
      return Math.sqrt((p.x - this.x)*(p.x - this.x)+(p.y - this.y)*(p.y - this.y));
   }
   /**
    * décrit le Point
    * @return retourne un String
    */
   @Override
   public String toString(){
      return ("Point("+this.x+", "+this.y+")");
   }
}