/**
 *@author CHARLES EMILE Ambinintsoa Fortunat, BEN SASSI Rached
 */
public interface InterfDV{
    /**
     * Configure la fenetre.
     * @see DessinVectorielPropre.Vue#maFenetre() 
     */
    public void maFenetre();  
    /**
     * Configure le menu 
     * @see DessinVectorielPropre.Vue#monMenu()
     */
    public void monMenu();
    /**
     * Configure la barre d'outils
     * @see DessinVectorielPropre.Vue#barreOutils()
     */
    public void barreOutils();
    /**
     * Construit le barycentre
     * @param b un barycentre
     * @see Barycentre
     */
    public void constructionBaryc(Barycentre b);
}