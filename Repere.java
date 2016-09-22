import java.awt.Graphics ;

/**
 * Definit un repere orthogonal.
 * Le point de coordonnees reelles (x, y) a pour position dans la fenetre d'affichage (X, Y)
 * où l'entier X varie de 0 a XMAX et Y de 0 à YMAX (vers le bas).
 * (XO, YO) donne la position de l'origine sur l'�cran et unitex, unitey fixent les unités sur les
 * deux axes.
 */

public class Repere implements InterfRepere
{

/**
 * Abscisse de l'origine du repere dans la fenetre d'affichage.
 */

  public int X0 ;

/**
 * Ordonnee de l'origine du repere dans la fenetre d'affichage.
 */

  public int Y0 ;

/**
 * Abscisse maximale.
 */

   public int XMAX ;

/**
 *
 * Ordonnee maximale.
 */

   public int YMAX ;

/**
 * Valeur en points "ecran" de l'unité suivant l'axe des x ; unitex = unitey pour un repere orthonormal.
 */

  public double unite;

/**
 * Valeur en points "ecran" de l'unité suivant l'axe des y.
 */


/**
 * Construit le repere orthogonal.
 */

  public Repere (int X0,int Y0,int XMAX,int YMAX,double unite)
  { this.X0 = X0; this.Y0 = Y0;
    this.XMAX = XMAX ; this.YMAX = YMAX ;
    this.unite = unite;
  }

/**
 * Trace le repere.
 */

  public void trace (Graphics g)
  { int UX = X0 + new Double (unite) . intValue () ;
    int UY = Y0 - new Double (unite) . intValue () ;
    if ((Y0 >= 0) && (Y0 <= YMAX)) { g.drawLine (0, Y0, XMAX, Y0) ;
                                        if ((UX >= 0) && (UX <= XMAX))
                                              g.drawLine (UX, Y0, UX, Y0) ;
                                      } 
    if ((X0 >= 0) && (X0 <= XMAX)) { g.drawLine (X0, 0, X0, YMAX) ;
                                        if ((UY >= 0) && (UY <= YMAX))
                                              g.drawLine (X0 , UY, X0 , UY);
                                      }
    }

/**
 * Trace un cadre.
 */

/**
 * Retourne la position X sur l'ecran d'un point d'abscisse x.
 */

  public int Iabs (double x)
  { return (int) (x * unite + X0); }

/**
 * Retourne la position Y sur l'ecran d'un point d'abscisse y.
 */

  public int Iord (double y)
  { return (int) (- y * unite + Y0); }

/**
 * Retourne l'abscisse x d'un point place en position (X, Y) sur l'ecran.
 */

  public double Abs (int X)
  { return (X - X0) / unite ; }

/**
 * Retourne l'ordonnée y d'un point placé en position (X, Y) sur l'écran.
 */

  public double Ord (int Y)
  { return (Y0 - Y) / unite ; }


/**
 * Mise à jour du repere orthogonal.
 */

  public void repere (int X0,int Y0,int XMAX,int YMAX,double unite)
  { this.X0 = X0; this.Y0 = Y0;
    this.XMAX = XMAX ; this.YMAX = YMAX ;
    this.unite = unite ;
  }

}
