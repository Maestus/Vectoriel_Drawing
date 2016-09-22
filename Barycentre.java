import java.util.ArrayList;

/**
 *@author CHARLES EMILE Ambinintsoa Fortunat, BEN SASSI Rached
 */
public class Barycentre{
   
    /**
     * tableau de PointR
     * @see PointR
     */
   public ArrayList<PointR> selectedPoint;
   
   /**
    * determine la position du barycentre 
    */
   public int x,y;
   
   /**
    * Constructeur 
    * Initialise le tableau de Point.
    */
   public Barycentre(){
      selectedPoint = new ArrayList<>();
   }
}