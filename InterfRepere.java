import java.awt.Graphics; 
/**
 *@author CHARLES EMILE Ambinintsoa Fortunat, BEN SASSI Rached
 */
public interface InterfRepere{
    /**
     * trace le repere
     * @param g un Graphics
     * @see Graphics
     */
   public void trace (Graphics g);
   /**
    * Transforme des coordonnées créé par rapport à la class Repere en coordonnées du repere de l'écran
    * @see Repere
    * @param x un double
    * @return retourne un entier
    */
   public int Iabs (double x);
   /**
    * Transforme des coordonnées créé par rapport à la class Repere en coordonnées du repere de l'écran
    * @see Repere
    * @param y un double
    * @return retourne un entier
    */
   public int Iord (double y);
   /**
    * Fait l'inverse de Iabs
    * @see #Iabs
    * @param X un int
    * @return retourne un double
    */
   public double Abs (int X);
   /**
    * Fait l'inverse de Iabs
    * @see #Iord
    * @param Y un int
    * @return retourne un double
    */
   public double Ord (int Y);
   /**
    * Met à jour le repere
    * @param X0 un entier
    * @param Y0 un entier
    * @param XMAX un entier
    * @param YMAX un entier
    * @param unite un double
    * @see Repere#Repere(int, int, int, int, double)
    */
   public void repere (int X0,int Y0,int XMAX,int YMAX,double unite);
}
