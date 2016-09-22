import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *@author BEN SASSI Rached, CHARLES EMILE Ambinintsoa Fortunat
 */

public class DessinVectorielPropre{
   /**
    *@see DessinVectorielPropre#Vue#Vue()
    */
   protected Vue maVue;
   /**
    * La position X de la souris par rapport au repère.
    */
   protected int posMouseX = 0;
   /**
    * La position Y de la souris par rapport au repère.
    */
   protected int posMouseY = 0;
   /**
    * La position X de départ d'un segment créé à partir d'un point.
    */
   protected int posXDepSeg = 0;
   /**
    * La position Y de départ d'un segment créé à partir d'un point.
    */
   protected int posYDepSeg = 0;
   /**
    * La position X d'arrivée d'un segment créé à partir d'un point.
    */
   protected int posXArrSeg = 0;
   /**
    * La position Y d'arrivée d'un segment créé à partir d'un point.
    */
   protected int posYArrSeg = 0;
   /**
    * La position X de départ d'un segment créé sans l'aide de point existant.
    */
   protected int posXDepNvxSeg = 0;
   /**
    * La position Y de départ d'un segment créé sans l'aide de point existant.
    */
   protected int posYDepNvxSeg = 0;
   /**
    * La position X d'arrivée d'un segment créé sans l'aide de point existant.
    */
   protected int posXArrNvxSeg = 0;
   /**
    * La position Y d'arrivée d'un segment créé sans l'aide de point existant.
    */
   protected int posYArrNvxSeg = 0;
   /**
    * La position X de départ d'une droite créé à partir d'un point.
    */
   protected int posXDepDroite = 0;
   /**
    * La position Y de départ d'une droite créé à partir d'un point.
    */
   protected int posYDepDroite = 0;
   /**
    * La position X d'arrivée d'une droite créé à partir d'un point.
    */
   protected int posXArrDroite = 0;
   /**
    * La position Y d'arrivée d'une droite créé à partir d'un point.
    */
   protected int posYArrDroite = 0;
   /**
    * Tableau regroupant les points créés.
    */
   protected PointR[] points = new PointR[1000];
   /**
    * Tableau regroupant les points créés correspondant aux droites.
    */
   protected PointR[] pointsDroite = new PointR[1000];
   /**
    * Tableau regroupant les points d'intersection des droites.
    */
   protected PointR[] ptsInterDr = new PointR[1000];
   /**
    * Tableau regroupant les points des barycentres.
    */
   protected Barycentre[] baryc = new Barycentre[1000];
   /**
    * Tableau regroupant les segments créés.
    */
   protected SegmentR[] segments = new SegmentR[1000];
   /**
    * Tableau regroupant les droites créés.
    */
   protected DroiteR[] droites = new DroiteR[1000];
   /**
    * Indice des points dans le tableau "points".
    */
   protected static int indicePoint = 0;
   /**
    * Indice des points dans le tableau "baryc".
    */
   protected static int indicePointBaryc = 1;  
   /**
    * Indice des segments dans le tableau "segments".
    */
   protected static int indiceSegment = 0;
   /**
    * Indice des points dans le tableau "droites"
    */
   protected static int indicePointsDroite = 0;
   /**
    * Indice des points dans le tableau "ptsInterDr".
    */
   protected static int indicePtsInterDr = 0;
   /**
    * Indice des droites dans le tableau "droites".
    */
   protected static int indiceDroite = 0;
   /**
    * Indice des points de départ dans le tableau "points" destiné aux segments créé sans point existant.
    */
   protected int indiceDepSegDS = 0;
   /**
    * Indice des points d'arrivé dans le tableau "points" destiné aux segments créé sans point existant.
    */
   protected int indiceArrSegDS = 0; 
   /**
    * Indice des points de départ dans le tableau "points" destiné aux droites créé sans point existant.
    */
   protected int indiceDepDroiteDS = 0;
   /**
    * Indice des points d'arrivé dans le tableau "points" destiné aux droites créé sans point existant.
    */
   protected int indiceArrDroiteDS = 0;
   /**
    * Indique qu'au moins un point est créé.
    */
   protected boolean creationPoint=false;
   /**
    * Indique qu'au moins un point destiné à une droite est créé.
    */
   protected boolean creationPointDroite=false;
   /**
    * Indique la création d'au moins une droite.
    */
   protected boolean creationDroite=false;
   /**
    * Indique la création d'au moins un segment.
    */
   protected boolean creationSegment=false;
   /**
    * Autorise ou interdit la modification d'un point.
    */
   protected boolean modifPoint=false;
   /**
    * Autorise la modification des points d'un segment.
    */
   protected boolean modifSegment=false;
   /**
    * Indique la création d'au moins un barycentre.
    */
   protected boolean boolBaryc=false;
   /**
    * Autorise la création d'un segment sans l'aide de point déjà existant.
    */
   protected boolean nvxSegment=true;
   /**
    * Permet de se repérer dans la création de segment (1er ou 2nd point du segment).
    */
   protected int passageSeg = 1;
   /**
    * Indique le nombre de point sélectionné.
    */
   protected int nbPointSelected = 0;
   /**
    * Permet de se repérer dans la création de segment (1er ou 2nd point de la droite).
    */
   protected int cptDroite = 0;
   /**
    * Informe du nombre de points selectionn� pour le barycentre.
    */
   protected int cptPtBar = 0;
   protected Repere rep=null;
   protected Tableau tableau;
   protected int scale = 1;
   protected int x,y=0;

   /**
    * Constructeur DessinVectorielPropre
    */
   public DessinVectorielPropre(){
      maVue = new Vue();
      rep =new Repere(tableau.getWidth()/2,tableau.getHeight()/2,tableau.getWidth(),tableau.getHeight(),1.0);
   }
   
   /**
    * @author BEN SASSI Rached, CHARLES EMILE Ambinintsoa Fortunat
    */
   public class Tableau extends JPanel{
       /**
        * Met à jour l'affichage du JPanel
        * @param g 
        */
      @Override
      public void paintComponent(Graphics g){
         Graphics2D g2 = (Graphics2D) g;
         Graphics2D g2d = (Graphics2D) g2.create();
         super.paintComponent(g2);
         super.paintComponent(g2d);
         rep.repere(tableau.getWidth()/2,tableau.getHeight()/2,tableau.getWidth(),tableau.getHeight(),1.0*scale); // le scale fait tout baiser augmente l'echelle mais pas lors de la creation 
         //g2d.translate(x,y);
         g2d.translate(rep.X0,rep.Y0);
         g2d.scale(scale,scale);
         g2d.translate(-rep.X0,-rep.Y0);
         //g2d.translate(-x,-y);
         rep.trace(g2d);
         g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  //Pour lisser les bords
         g2d.setColor(Color.darkGray);     //Couleur gris fonce
         if(creationPoint){
            for(int i=0; i<indicePoint; i++){         //Pour l'affichage des points
               g2d.fillOval((int)(rep.Iabs(points[i].centre.getX()))-(int)points[i].rayon,(int)(rep.Iord(points[i].centre.getY()))-(int)points[i].rayon,(int)(points[i].rayon*2),(int)(points[i].rayon*2));
            }
            if(creationSegment){
               for(int i=0; i<indiceSegment; i++){    //Pour l'affichage des segments
                  g2d.drawLine(rep.Iabs(points[segments[i].indiceDepSeg].centre.getX()),rep.Iord(points[segments[i].indiceDepSeg].centre.getY()),rep.Iabs(points[segments[i].indiceArrSeg].centre.getX()),rep.Iord(points[segments[i].indiceArrSeg].centre.getY()));
               }
            }
         } 
         if(boolBaryc){
            g2d.setColor(new Color(60,127,127));    //Couleur vert-bleu leger
            for(int i = 0;i<indicePointBaryc-1;i++){
               //if(baryc[i].x!=0 && baryc[i].y !=0)
                  g2d.fillOval((int)(rep.Iabs(baryc[i].x)-3),(int)(rep.Iord(baryc[i].y)-3),(4*2),(4*2));
              // if(baryc[i].x == 0)
                 // g2d.fillOval((int)(rep.Iabs(baryc[i].x)-3),(int)(rep.Iord(baryc[i].y)-3),(4*2),(4*2));

            }
         }
        //DESSINER DROITE
         if(creationPointDroite){            
            g2d.setColor(new Color(168,127,127));
            for(int i=0; i<indicePointsDroite; i++){         //Pour l'affichage des points
               g2d.fillOval((int)(rep.Iabs(pointsDroite[i].centre.getX()))-(int)pointsDroite[i].rayon,(int)(rep.Iord(pointsDroite[i].centre.getY()))-(int)pointsDroite[i].rayon,(int)pointsDroite[i].rayon*2,(int)pointsDroite[i].rayon*2);
            }
            if(creationDroite){
               g2d.setColor(Color.darkGray);
               for(int i=0; i<indiceDroite; i++){    //Pour l'affichage des segments
                  //g2.drawLine(pointsDroite[droites[i].indiceDepDroite].centre.getX(),pointsDroite[droites[i].indiceDepDroite].centre.getY(),pointsDroite[droites[i].indiceArrDroite].centre.getX(),pointsDroite[droites[i].indiceArrDroite].centre.getY());
                  //g2d.drawLine(0,rep.Iord(Math.abs((int)droites[i].constante())),rep.Iabs(Math.abs(((int)(droites[i].constante()/droites[i].coeffDir())))),0);                 
                  //System.out.println("Y1 "+(int)droites[i].constante()+" X2 "+((int)(droites[i].constante()/droites[i].coeffDir())));
                  g2d.drawLine(rep.Iabs(pointsDroite[droites[i].indiceDepDroite].centre.getX()),rep.Iord(pointsDroite[droites[i].indiceDepDroite].centre.getY()),rep.Iabs(pointsDroite[droites[i].indiceArrDroite].centre.getX()),rep.Iord(pointsDroite[droites[i].indiceArrDroite].centre.getY()));
               }               
            }
         } 
         
         //INTERSECTION DROITES
         for(int i=0; i<indicePtsInterDr; i++){
            g2d.setColor(Color.YELLOW);
            g2d.fillOval(rep.Iabs(ptsInterDr[i].centre.getX())-(int)ptsInterDr[i].rayon,rep.Iord(ptsInterDr[i].centre.getY())-(int)ptsInterDr[i].rayon,(int)ptsInterDr[i].rayon*2,(int)ptsInterDr[i].rayon*2);
         }
      }         
   }
   /**
    * @author BEN SASSI Rached, CHARLES EMILE Ambinintsoa Fortunat
    */
   public class Vue extends JFrame implements MouseListener, MouseMotionListener,MouseWheelListener,InterfDV{
      private Container content;      //Le conteneur principal
      private JPanel choix;           //Le JPanel Barre d'outils
      private JPanel position;
      private JToolBar maBarreOutils;    //La barre d'outils
      private JToggleButton btnSegment, btnDroite, btnPoint,btnSelection;
      private JButton btnBarycentre,btnReset;  
      private JMenuItem information;   
      protected JLabel posSouris = new JLabel("Position souris"); //Position de la souris
      /**
       * Constructeur qui appel la méthode maFenetre qui permet la création de la fenetre
       * @see #maFenetre()
       */
      public Vue(){
         this.maFenetre();
      }
      /**
       * Création de tout les éléments de la fenetre. 
       * appel les méthodes monMenu() et barreOutils()
       * @see #monMenu() 
       * @see #barreOutils()
       */ 
      public final void maFenetre(){      
         setDefaultCloseOperation(EXIT_ON_CLOSE);  //Pour pouvoir fermer la fenetre  
         
         this.setTitle("Dessin Vectoriel"); 
         
         this.setSize(1024,700);       //Taille de la fen�tre
                   
         //**** Creation des conteneurs ****              
         this.content = getContentPane();  //Le conteneur principal
          
         tableau = new Tableau();
          
         this.choix = new JPanel();    
         
         this.position = new JPanel();  
   
         //**** Caracteristique conteneur ****  
         this.choix.setLayout(new GridLayout(1,1));
         
         tableau.setLayout(null);
         
         tableau.setSize(1024,650);
          
         this.position.add(posSouris, BorderLayout.CENTER);
         
         this.mouseListenerTableau();     //Appel fonction pour mettre des mouse listener au JPanel tableau
                           
         try{
            for(int i=0; i<=indicePoint; i++){
               tableau.add(points[i], BorderLayout.CENTER);
            }
         }catch(NullPointerException e){}
          
         //**** Ajout au conteneur principal ****          
         this.content.add(this.choix, BorderLayout.NORTH);
          
         this.content.add(tableau, BorderLayout.CENTER);   
         
         this.content.add(this.position, BorderLayout.SOUTH);          
          
         //**** Appel fonctions ****          
         this.monMenu();      //Creation de la barre de menu
         
         this.barreOutils();      //Creation de la barre d'outils   
         
         this.setVisible(true);        //Fenetre visible  
      }
      
      public void mouseListenerTableau(){      
         tableau.addMouseListener(this);
         tableau.addMouseMotionListener(this);   
         tableau.addMouseWheelListener(this);      
      }
      /**
       * Permet la création de la barre de menu
       */
      public void monMenu(){
         for(int i = 0; i<baryc.length;i++)
            baryc[i]=new Barycentre();

      
         //**** Creation de la barre de menu ****         
         JMenuBar menuBar = new JMenuBar();  
          
         setJMenuBar(menuBar);     //Insertion de la barre de menu dans la JFrame         
         
         //**** Creation du volet "About" ****
         JMenu about = new JMenu("About");
         
         information = new JMenuItem("Notice d'utilisation");      //Creation du bouton "Qui sommes nous"
         
         about.add(information);     //Ajout du bouton "Qui sommes nous" dans "About"
         
         
         //**** Ajout des volets dans la barre de menu ****         
         menuBar.add(about);
          
      }
      /**
       * Création de la barre d'outils ainsi que des listeners correspondant
       * à chaque élément de la barre d'outils
       * invoque la méthode repaint() qui permet de mettre à jour l'affichage
       * @see #repaint() 
       */
      
      public void barreOutils(){
         //**** Creation d'une barre d'outil ****
         maBarreOutils = new JToolBar();
          
         maBarreOutils.setBorderPainted(false);
         
         maBarreOutils.setFloatable(false);
          
         //**** Création des boutons de la barre d'outils ****
         ButtonGroup group = new ButtonGroup();
         
         btnPoint = new JToggleButton(new ImageIcon("Point.png"),true);	
          
         btnSegment = new JToggleButton(new ImageIcon("Segment.png")); 
         
         btnDroite = new JToggleButton(new ImageIcon("Droite.png"));

         btnSelection = new JToggleButton(new ImageIcon("Selection.png"));

         btnBarycentre = new JButton(new ImageIcon("Barycentre.png"));
         
         btnReset = new JButton(new ImageIcon("Reset.png"));
         
         btnBarycentre.setEnabled(false);
         
         btnSelection.setEnabled(false);

         
         //**** Ajout des boutons à la barre d'outils ****
         maBarreOutils.add(btnPoint); 
         
         maBarreOutils.add(btnSegment);
         
         maBarreOutils.add(btnDroite); 
         
         maBarreOutils.add(btnSelection);
         
         maBarreOutils.add(btnBarycentre);
         
         maBarreOutils.add(btnReset);

         //**** Ajout des boutons au ButtonGroup **** 
         group.add(btnPoint);
         
         group.add(btnSegment);
         
         group.add(btnDroite); 
         
         group.add(btnSelection);  

         group.add(btnBarycentre); 
         
         group.add(btnReset);
         
         //Ajout de la barre d'outils dans l'ensemble
         this.choix.add(maBarreOutils);
         
         //Listener de la barre d'outils (possible de le mettre ailleur)
         ActionListener actionListener,actionListener2;
         
         actionListener = new ActionListener() {         
            @Override
            public void actionPerformed(ActionEvent ae) {
               if(ae.getSource()== btnBarycentre){
                  boolBaryc=true;
                  cptPtBar = 0;
                  for(int i = 0 ; i<indicePoint; i++){                        
                     points[i].select = false; 
                  }
                  for(int i = 0;i<baryc[indicePointBaryc-1].selectedPoint.size();i++){
                     baryc[indicePointBaryc-1].x+=baryc[indicePointBaryc-1].selectedPoint.get(i).centre.getX();
                     baryc[indicePointBaryc-1].y+=baryc[indicePointBaryc-1].selectedPoint.get(i).centre.getY();
                  }
                  try{
                     baryc[indicePointBaryc-1].x/=baryc[indicePointBaryc-1].selectedPoint.size();
                     baryc[indicePointBaryc-1].y/=baryc[indicePointBaryc-1].selectedPoint.size();
                     indicePointBaryc++;
                     if(indicePointBaryc==baryc.length+1)
                        btnSelection.setEnabled(false);
                     btnBarycentre.setEnabled(false);
                  }catch(ArithmeticException e){
                     System.out.println("Vous n'avez pas s�l�ctionn� de point !");
                  } 
                  nbPointSelected = 0;
                  repaint();
               }
               if(ae.getSource() == information){
                  Thread thread = new Thread(){
                     public void run(){
                        System.out.println("Thread Running");
                        JFrame frame2 = new JFrame();
                        frame2.setTitle("About");
                        JPanel conteneur = new JPanel();
                        JLabel info = new JLabel();
                        info.setText("<html><body><table style=\"padding:3px;vertical-align:top;width:100%;marging:auto\" cellpadding=\"0\" cellspacing=\"0\"><tr><td colspan=\"2\"><u>Logiciel de Dessin Vectoriel</u></td></tr><tr><td colspan=\"2\">&nbsp;</td></tr><tr><td colspan=\"2\">Notice d'utilisation :</td></tr><tr><td colspan=\"2\">&nbsp;</td></tr><tr><td colspan=\"2\">&nbsp;</td></tr><tr><td style=\"width:15%;vertical-align:top;color:rgb(60,127,127);border:solid 1px rgb(214,214,214);padding:5px;\">Le Point</td><td style=\"font-weight:bolder;width:85%;border:solid 1px rgb(214,214,214);padding:5px;\">Le bouton \"Point\" une fois appuy� vous permet de cr�er et de bouger des points.<br> Les Points sont necessaires pour la cr�ation de Segment et pour la cr�ation de Barycentre.</td></tr><tr><td colspan=\"2\">&nbsp;</td></tr><tr><td style=\"width:15%;vertical-align:top;color:rgb(60,127,127);border:solid 1px rgb(214,214,214);padding:5px;\">Le Segment</td><td style=\"font-weight:bolder;border:solid 1px rgb(214,214,214);padding:5px;\">Lorsque vous appuyez sur le bouton \"Seg\" la cr�ation de Segment se fait lorsque vous tirez la souris d'un point � un autre point distinct mais aussi lorsque vous enfoncez et d�placez la souris directement sans l'aide de point d�j� existant. Ainsi le point de d�part est cr�e au moment du clic et le point d'arriv� au moment de relachement du clic de la souris.</td></tr><tr><td colspan=\"2\">&nbsp;</td></tr><tr><td style=\"width:15%;vertical-align:top;color:rgb(60,127,127);border:solid 1px rgb(214,214,214);padding:5px;\">La Droite</td><td style=\"font-weight:bolder;border:solid 1px rgb(214,214,214);padding:5px;\">Le bouton \"Dro\" permet la cr�ation des deux points de passage de la droite. Lorsque deux droites se croisent un point d'intersection de couleur jaune est alors cr��.</td></tr><tr><td colspan=\"2\">&nbsp;</td></tr><tr><td style=\"width:15%;vertical-align:top;color:rgb(60,127,127);border:solid 1px rgb(214,214,214);padding:5px;\">Le Barycentre</td><td style=\"font-weight:bolder;font-weight:bolder;border:solid 1px rgb(214,214,214);padding:5px;\">Vous devez selectionner les points qui seront pris en compte pour le barycentre en utilisant le bouton \"Selec\", puis lorsque votre choix de points est fait, en appuyant sur le bouton \"Baryc\" le point bleu/vert correspondant au barycentre sera cr��.</td></tr><tr><td colspan=\"2\">&nbsp;</td></tr><tr><td style=\"width:15%;vertical-align:top;color:rgb(60,127,127);border:solid 1px rgb(214,214,214);padding:5px;\">Le Zoom</td><td style=\"border:solid 1px rgb(214,214,214);padding:5px;font-weight: bolder\">Il est possible de zoomer et de d�zoomer � l'aide de la molette de la souris.</td></tr><tr><td colspan=\"2\">&nbsp;</td></tr><tr><td colspan=\"2\">&nbsp;</td></tr><tr><td colspan=\"2\">Logiciel developp� par Charles Emile Ambinintsoa et Ben sassi Rached dans le cadre d'un projet d'�tude.</td></tr></table></body></html>");          
                        conteneur.add(info);
                        info.setHorizontalTextPosition(conteneur.getHeight()/2);
                        info.setVerticalTextPosition(conteneur.getWidth()/2);
                        frame2.add(info);
                        frame2.setSize(700,565);
                        conteneur.setSize(300,300);
                        frame2.setVisible(true);
                     }
                  };
                  thread.start();
              }   
            }
         };

         actionListener2 = new ActionListener() {         
            @Override
            public void actionPerformed(ActionEvent ae) {
               if(ae.getSource()== btnReset){
                  creationPoint=false;
                  creationPointDroite=false;
                  creationDroite=false;
                  creationSegment=false;
                  modifSegment=false;
                  boolBaryc=false;
                  nvxSegment=true;
                  for(int i=0; i<indicePoint; i++){
                     points[i] = null;
                  }
                  for(int i=0; i<indicePointsDroite; i++){
                     pointsDroite[i] = null;
                  }                  
                  for(int i=0; i<indicePtsInterDr; i++){
                     ptsInterDr[i] = null;
                  }                  
                  for(int i = 0; i<baryc.length;i++)
                     baryc[i]=new Barycentre();
            
                  for(int i=0; i<indiceSegment; i++){
                     segments[i] = null;
                  }                  
                  for(int i=0; i<indiceDroite; i++){
                     droites[i] = null;
                  }
                  posMouseX = 0;
                  posMouseY = 0;
                  posXDepSeg = 0;
                  posYDepSeg = 0;
                  posXArrSeg = 0;
                  posYArrSeg = 0;
                  posXDepNvxSeg = 0;
                  posYDepNvxSeg = 0;
                  posXArrNvxSeg = 0;
                  posYArrNvxSeg = 0;
                  posXDepDroite = 0;
                  posYDepDroite = 0;
                  posXArrDroite = 0;
                  posYArrDroite = 0;
                  indicePoint = 0;
                  indicePointBaryc = 1; 
                  indiceSegment = 0;
                  indicePointsDroite = 0;
                  indicePtsInterDr = 0;
                  indiceDroite = 0;
                  indiceDepSegDS = 0;
                  indiceArrSegDS = 0;
                  indiceDepDroiteDS = 0;
                  indiceArrDroiteDS = 0;
                  passageSeg = 1;
                  nbPointSelected = 0;
                  cptDroite = 0;
                  cptPtBar = 0;
                  scale = 1;
                  btnPoint.setEnabled(true);
                  btnSegment.setEnabled(true);
                  btnDroite.setEnabled(true);
                  btnSelection.setEnabled(false);
                  repaint();
               }
            }
         };
         
         //Listener des outils
                  
         btnPoint.addActionListener(actionListener);
         
         btnSegment.addActionListener(actionListener);
         
         btnSelection.addActionListener(actionListener);
         
         btnBarycentre.addActionListener(actionListener);
         
         btnReset.addActionListener(actionListener2); 
         
         information.addActionListener(actionListener); 
             
         
      }
      /**
       * Cette méthode permet la création des barycentres elle est appelée
       * par la methode mouseDragged(MouseEvent)
       * pour mettre à jour la position du barycentre par rapport aux points.
       * @see #mouseDragged(MouseEvent me)
       * @param b variable de type Barycentre contient le tableau des points selectionnés
       * et le couple(x,y) désignant l'emplacement du barycentre.
       * @see Barycentre
       */
      public void constructionBaryc(Barycentre b){
         boolBaryc=true;
         b.x=0;
         b.y=0;               
         for(int i = 0;i<b.selectedPoint.size();i++){
            b.x+=b.selectedPoint.get(i).centre.getX();
            b.y+=b.selectedPoint.get(i).centre.getY();
         }
         try{
            b.x/=b.selectedPoint.size();
            b.y/=b.selectedPoint.size();
         }catch(Exception e){} 
      }
      
      protected int v = indicePoint-1;
      protected int r = 0;
      protected int s = 0;
      protected int u = indicePointsDroite-1;
      protected boolean mouvPoint = true;
      protected boolean mouvDroite = true;
      /**
       * Méthode invoquée lors ce que la souris est préssée et bougée.
       * Elle permet de gérer le mouvement des points existants et le début de la création des Segments.
       * Elle fait appel à la méthode constuctionBaryc(Barycentre b) si un point est bougé et s'il "appartient" à un barycentre.
       * @see #mouseReleased(MouseEvent me)
       * @see #constructionBaryc(Barycentre b) 
       * @param me Variable de type MouseEvent
       * @see java.awt.event.MouseEvent
       */
      @Override
      public void mouseDragged(MouseEvent me){
         if(scale <= 4){
            this.posSouris.setText("X = " + rep.Abs(me.getX())/scale + " | Y = " + rep.Ord(me.getY())/scale); 
            
            if(btnPoint.isSelected()){   //Si le bouton point est selectionne
               modifPoint = true;
               if(mouvPoint){
                  for(int i=r; i<=v; i++){
                     if(scale != 2){
                        if(creationPoint && points[i].incluMove(new Point((int)rep.Abs(me.getX())/scale,(int)rep.Ord(me.getY())/scale))){
                           v=i;
                           r=i;
                           boolean petiteDistancePt = false;
                           for(int j=0; j<indicePoint; j++){
                              if(scale >=3 && points[i] != points[j] && Math.sqrt(((points[i].centre.getX()-points[j].centre.getX())*(points[i].centre.getX()-points[j].centre.getX())) + ((points[i].centre.getY()-points[j].centre.getY())*(points[i].centre.getY()-points[j].centre.getY()))) < 20){
                                 petiteDistancePt = true; 
                              }
                           }
                           if(!petiteDistancePt){
                              points[i].centre.setX((int)rep.Abs(me.getX())/scale);
                              points[i].centre.setY((int)rep.Ord(me.getY())/scale);
                              repaint();
                              mouvDroite = false;
                           }
                           else{
                              this.posSouris.setText("D�zoomez pour bouger ce point !");  
                           }
                        }
                    }
                    else{
                        if(creationPoint && points[i].inclu(new Point((int)rep.Abs(me.getX())/scale,(int)rep.Ord(me.getY())/scale))){
                           v=i;
                           r=i;
                           boolean petiteDistancePt = false;
                           for(int j=0; j<indicePoint; j++){
                              if(scale >=3 && points[i] != points[j] && Math.sqrt(((points[i].centre.getX()-points[j].centre.getX())*(points[i].centre.getX()-points[j].centre.getX())) + ((points[i].centre.getY()-points[j].centre.getY())*(points[i].centre.getY()-points[j].centre.getY()))) < 20){
                                 petiteDistancePt = true; 
                              }
                           }
                           if(!petiteDistancePt){
                              points[i].centre.setX((int)rep.Abs(me.getX())/scale);
                              points[i].centre.setY((int)rep.Ord(me.getY())/scale);
                              repaint();
                              mouvDroite = false;
                           }
                           else{
                              this.posSouris.setText("D�zoomez pour bouger ce point !");  
                           }
                        }
                    }
                 }
               }   
               if(mouvDroite){ 
                  for(int i=s; i<=u; i++){
                     if(scale != 2){
                        if(creationPointDroite && pointsDroite[i].incluMove(new Point((int)rep.Abs(me.getX())/scale,(int)rep.Ord(me.getY())/scale))){
                           u=i;
                           s=u;
                           boolean petiteDistanceDr = false;
                           for(int j=0; j<indicePointsDroite; j++){
                              if(scale >=3 && pointsDroite[i] != pointsDroite[j] && Math.sqrt(((pointsDroite[i].centre.getX()-pointsDroite[j].centre.getX())*(pointsDroite[i].centre.getX()-pointsDroite[j].centre.getX())) + ((pointsDroite[i].centre.getY()-pointsDroite[j].centre.getY())*(pointsDroite[i].centre.getY()-pointsDroite[j].centre.getY()))) < 20){
                                 petiteDistanceDr = true; 
                              }
                           }
                           if(!petiteDistanceDr){
                              pointsDroite[u].centre.setX((int)rep.Abs(me.getX())/scale);
                              pointsDroite[u].centre.setY((int)rep.Ord(me.getY())/scale);
                              repaint();
                              mouvPoint=false;
                           }
                           else{
                              this.posSouris.setText("D�zoomez pour bouger ce point !");  
                           }                     
                      }
                    }
                    else{
                         if(creationPointDroite && pointsDroite[i].inclu(new Point((int)rep.Abs(me.getX())/scale,(int)rep.Ord(me.getY())/scale))){
                              u=i;
                              s=u;
                              boolean petiteDistanceDr = false;
                              for(int j=0; j<indicePointsDroite; j++){
                                 if(scale >=3 && pointsDroite[i] != pointsDroite[j] && Math.sqrt(((pointsDroite[i].centre.getX()-pointsDroite[j].centre.getX())*(pointsDroite[i].centre.getX()-pointsDroite[j].centre.getX())) + ((pointsDroite[i].centre.getY()-pointsDroite[j].centre.getY())*(pointsDroite[i].centre.getY()-pointsDroite[j].centre.getY()))) < 20){
                                    petiteDistanceDr = true; 
                                 }
                              }
                              if(!petiteDistanceDr){
                                 pointsDroite[u].centre.setX((int)rep.Abs(me.getX())/scale);
                                 pointsDroite[u].centre.setY((int)rep.Ord(me.getY())/scale);
                                 repaint();
                                 mouvPoint=false;
                              }
                              else{
                                 this.posSouris.setText("D�zoomez pour bouger ce point !");  
                              }                     
                         }
                    }
                 }       
               }
            }
            if(btnSegment.isSelected()){   //Si le bouton segment est selectionne
               modifPoint = false;  //On ne peut pas modifier les points 
                                                
               for(int i=0; i<indicePoint; i++){
                  if(!modifPoint && creationPoint && points[i].inclu(new Point((int)rep.Abs(me.getX())/scale,(int)rep.Ord(me.getY())/scale))){
                     modifSegment = true;
                     if(passageSeg==1){   //Si on est au 1er passage du segment (1er point)
                        posXDepSeg = points[i].centre.getX();
                        posYDepSeg = points[i].centre.getY();
                        indiceDepSegDS = i;
                        passageSeg++;
                        System.out.println("Départ("+rep.Abs(posXDepSeg)/scale+", "+rep.Abs(posYDepSeg)/scale+")");                     
                     }
                     nvxSegment = false;     //Quand on drag sur un point deja existant, on ne cree donc pas de segment sans l'aide d'un point
                  }                         
               }
            }
           if(boolBaryc && ! btnSegment.isSelected()){
               for(int i=0; i<indicePoint; i++){
                  if(points[i].inclu(new Point((int)rep.Abs(me.getX())/scale,(int)rep.Ord(me.getY())/scale))){
                     for(int j = 0; j < indicePointBaryc; j++){
                        for(int k = 0;k<baryc[j].selectedPoint.size();k++){
                           if(points[i].inclu(baryc[j].selectedPoint.get(k).centre)){
                              constructionBaryc(baryc[j]);       
                           }
                        }
                     }
                  }
               }                             
            }
         }
      }
      /**
       * Creation des Points.
       * Donc le point créé est de coordonnée (x,y)
       * @param x correspond à la coordonnée x de l'endroit où l'on click
       * @param y correspond à la coordonnée y de l'endroit où l'on click
       * @see #mouseClicked(MouseEvent me)
       * @see java.awt.event.MouseEvent
       */
      public void creationPoint(int x, int y){         
          modifPoint = true;            //On peut modifier les points
            try{
               System.out.println("new point : "+rep.Abs(x)+" , "+rep.Ord(y));
               points[indicePoint] = new PointR((int)(rep.Abs(x))/scale,(int)(rep.Ord(y))/scale);
               indicePoint++;
            }catch(ArrayIndexOutOfBoundsException e){
               System.out.println("Vous avez depasse la limite du nombre de point autorise !"+"("+points.length+" points maximum)");
            }         
            creationPoint = true;            
            repaint();
            if(indicePointBaryc==baryc.length+1)
                        btnSelection.setEnabled(false);
            else
               btnSelection.setEnabled(true);            
         }   
      /**
       * Est appelé si la souris est clické
       * Permet de créer des points en appelant creationPoint(int x,int y)
       * @see #creationPoint(int x,int y)
       * @param me type MouseEvent
       * @see java.awt.event.MouseEvent
       */
      @Override
      public void mouseClicked (MouseEvent me) {
         if(scale <= 4){
            posSouris.setText("Clic : X = "+rep.Abs(me.getX())/scale+" | Y = "+rep.Ord(me.getY())/scale);   //Info position souris         
            if(btnPoint.isSelected()){       //Si le bouton point est selectionne
              creationPoint(me.getX(),me.getY());
            }
            
            if(btnSegment.isSelected()){ 
               modifPoint = false;
            } 
            
            if(btnSelection.isSelected()){
               modifPoint = false;            
               for(int i = 0 ; i<indicePoint; i++){
                  if(points[i].inclu(new Point((int)rep.Abs(me.getX())/scale,(int)rep.Ord(me.getY())/scale)) && !points[i].select){ 
                     points[i].select = true;
                     posSouris.setText("SELECTION POINT No "+(++cptPtBar)+" : X = "+rep.Abs(me.getX())/scale+" | Y = "+rep.Ord(me.getY())/scale);
                     nbPointSelected++;
                     baryc[indicePointBaryc-1].selectedPoint.add(points[i]);
                  }
                  else if(points[i].inclu(new Point((int)rep.Abs(me.getX())/scale,(int)rep.Ord(me.getY())/scale)) && points[i].select){
                     posSouris.setText("DEJA SELECTIONNE : X = "+rep.Abs(me.getX())/scale+" | Y = "+rep.Ord(me.getY())/scale);
                  }
               }             
               if(nbPointSelected>=2)
                  btnBarycentre.setEnabled(true);     
            }
            
            if(btnDroite.isSelected()){
               modifPoint = true;
               cptDroite++;
               posSouris.setText("DROITE VERSION ALPHA | X = "+rep.Abs(me.getX())/scale+" | Y = "+rep.Ord(me.getY())/scale);
               
               if(cptDroite == 1){  //1er point de la droite
                  pointsDroite[indicePointsDroite] = new PointR((int)rep.Abs(me.getX())/scale,(int)rep.Ord(me.getY())/scale);
                  posXDepDroite = (int)rep.Abs(me.getX())/scale;
                  posYDepDroite = (int)rep.Ord(me.getY())/scale;
                  indiceDepDroiteDS = indicePointsDroite;
                  indicePointsDroite++;
                  creationPointDroite = true;
               }
               if(cptDroite == 2){  //2nd point de la droite
                  pointsDroite[indicePointsDroite] = new PointR((int)rep.Abs(me.getX())/scale,(int)rep.Ord(me.getY())/scale);
                  posXArrDroite = (int)rep.Abs(me.getX())/scale;
                  posYArrDroite = (int)rep.Ord(me.getY())/scale;
                  indiceArrDroiteDS = indicePointsDroite;
                  indicePointsDroite++;
                  cptDroite++;      //ici cptDroite = 3 donc on peut maintenant dessiner la droite
               }
               if(cptDroite == 3){
                  droites[indiceDroite] = new DroiteR(posXDepDroite,posYDepDroite,posXArrDroite,posYArrDroite,indiceDepDroiteDS,indiceArrDroiteDS);
                  indiceDroite++;               
                  cptDroite = 0;
                  creationDroite = true;
                  repaint();
               }
               
               //INTERSECTION DROITE
               modifPoint = true;
               int cptInterDr = 0;
               for(int i=0; i<indiceDroite; i++){     //i<indiceSegment-1
                  cptInterDr = 0;               
                           
                  while(!droites[i].estTestDr){
                     if(i != cptInterDr){
                        try{
                           ptsInterDr[indicePtsInterDr] = droites[i].ajoutPtIntersectDroite(droites[cptInterDr]);
                           indicePtsInterDr++;
                           repaint();
                        }catch(ArrayIndexOutOfBoundsException e){
                           System.out.println("Vous avez depasse la limite du nombre de point autorise !"+"("+points.length+" points maximum)");
                        }
                     }
                     if(cptInterDr == indiceDroite-1){
                        droites[i].estTestDr = true;
                     }
                     cptInterDr++;
                     repaint();
                  }
               }
            }  
         }
      }
      /**
       * Est appelé lors que la souris et préssée
       * Permet d'avoir les coordonnées du point de départ du Segment
       * @param me Variable de type MouseEvent
       * @see java.awt.event.MouseEvent
       */   
      
      @Override
      public void mousePressed (MouseEvent me) {
         if(scale <= 3){
            if(btnPoint.isSelected()){   //Si le bouton point est selectionne
               modifPoint = true;            
            }
            
            if(btnSegment.isSelected()){   //Si le bouton segment est selectionne
               modifPoint = false;
               modifSegment = true; 
               
               if(!creationPoint){
                  posXDepNvxSeg = me.getX();
                  posYDepNvxSeg = me.getY();
                  nvxSegment = true;  
                  System.out.println("DepartNVX("+rep.Abs(posXDepNvxSeg)/scale+", "+rep.Ord(posYDepNvxSeg)/scale+")");
               }
               else{
                  for(int i=0; i<indicePoint; i++){
                     if(!points[i].inclu(new Point((int)rep.Abs(me.getX())/scale,(int)rep.Abs(me.getY())/scale))){
                        posXDepNvxSeg = me.getX();
                        posYDepNvxSeg = me.getY();                        
                        nvxSegment = true;                     
                     }
                  }               
                  System.out.println("DepartNVX("+rep.Abs(posXDepNvxSeg)/scale+", "+rep.Ord(posYDepNvxSeg)/scale+")");
               }
            }
            repaint();
         }
      }
      
      /**
       * Creation des Segments.
       * le couple (x,y) correspond au point d'arrivé du Segment.
       * @param x correspond à la coordonnée x de l'endroit où l'on relache la souris
       * @param y correspond à la coordonnée y de l'endroit où l'on relache la souris
       * @see #mouseReleased(MouseEvent me)
       * @see java.awt.event.MouseEvent
       */
      
      public void creationSegment(int x, int y){
          modifPoint = false;
         if(!creationPoint){        //Quand aucun point n'est encore cree
            btnSelection.setEnabled(true);
            posXArrNvxSeg = x;
            posYArrNvxSeg = y;
            System.out.println("ArriveNVX("+posXArrNvxSeg+", "+posYArrNvxSeg+")");
            if(posXDepNvxSeg != posXArrNvxSeg && posYDepNvxSeg != posYArrNvxSeg){
               try{
                  points[indicePoint] = new PointR((int)rep.Abs(posXDepNvxSeg)/scale,(int)rep.Ord(posYDepNvxSeg)/scale);    //Point de d�part du segment new PointR((int)rep.Abs(posMouseX),(int)rep.Ord(posMouseY));

                  indiceDepSegDS = indicePoint;    //Indice du point de depart
                  indicePoint++;                   //Incremente le nombre de point en consequence
                  points[indicePoint] = new PointR((int)rep.Abs(posXArrNvxSeg)/scale,(int)rep.Ord(posYArrNvxSeg)/scale);    //Point d'arriv� du segment
                  indiceArrSegDS = indicePoint;    //Indice du point d'arrivee
                  indicePoint++;                   //Incremente le nombre de point en consequence
                  segments[indiceSegment] = new SegmentR((int)rep.Abs(posXDepNvxSeg)/scale,(int)rep.Ord(posYDepNvxSeg)/scale,(int)rep.Abs(posXArrNvxSeg)/scale,(int)rep.Ord(posYArrNvxSeg)/scale,indiceDepSegDS,indiceArrSegDS);   //On cr�e le segment
                  indiceSegment++;     //On incremente le nombre de segment en consequence
                  creationSegment = true;
               }catch(ArrayIndexOutOfBoundsException e){
                  System.out.println("Vous avez depasse la limite du nombre de point autorise !"+"("+points.length+" points maximum)");
               } 
            }        
            creationPoint = true;                            
            modifSegment = false;
            nvxSegment = false;
            repaint(); 
         }
         for(int i=0; i<indicePoint; i++){
            repaint();
            if(!modifPoint && modifSegment && creationPoint && points[i].inclu(new Point(((int)rep.Abs(x)/scale),((int)rep.Ord(y)/scale)))){
    
               if(passageSeg==2){   //Si on est au 2nd passage (2nd points)
                  posXArrSeg = points[i].centre.getX();
                  posYArrSeg = points[i].centre.getY();
                  indiceArrSegDS = i;
                  System.out.println("Arrive("+posXArrSeg+", "+posYArrSeg+")");
               }
               try{
                  segments[indiceSegment] = new SegmentR((int)rep.Abs(posXDepSeg)/scale,(int)rep.Ord(posYDepSeg)/scale,(int)rep.Abs(posXArrSeg)/scale,(int)rep.Ord(posYArrSeg)/scale,indiceDepSegDS,indiceArrSegDS);
                  indiceSegment++;
                  passageSeg = 1;   //Retour au 1er passage du segment
                  creationSegment = true;
               }catch(ArrayIndexOutOfBoundsException e){
                  System.out.println("Vous avez depasse la limite du nombre de segment autorise !"+"("+segments.length+" segments maximum)");
               } 
               repaint();
               modifSegment = false;
            }
            else if(!modifPoint && nvxSegment && !points[i].inclu(new Point((int)rep.Abs(x)/scale,(int)rep.Ord(y)/scale))){
               posXArrNvxSeg = x;
               posYArrNvxSeg = y;
               System.out.println("ArriveNVX("+posXArrNvxSeg+", "+posYArrNvxSeg+")");
               if(posXDepNvxSeg != posXArrNvxSeg && posYDepNvxSeg != posYArrNvxSeg){
                  try{
                     points[indicePoint] = new PointR((int)rep.Abs(posXDepNvxSeg)/scale,(int)rep.Ord(posYDepNvxSeg)/scale);
                     indiceDepSegDS = indicePoint;
                     indicePoint++;
                     points[indicePoint] = new PointR((int)rep.Abs(posXArrNvxSeg)/scale,(int)rep.Ord(posYArrNvxSeg)/scale);
                     indiceArrSegDS = indicePoint;
                     indicePoint++;
                     segments[indiceSegment] = new SegmentR((int)rep.Abs(posXDepNvxSeg)/scale,(int)rep.Ord(posYDepNvxSeg)/scale,(int)rep.Abs(posXArrNvxSeg)/scale,(int)rep.Ord(posYArrNvxSeg)/scale,indiceDepSegDS,indiceArrSegDS);
                     indiceSegment++;
                     creationSegment = true;
                  }catch(ArrayIndexOutOfBoundsException e){
                     System.out.println("Vous avez depasse la limite du nombre de point autorise !"+"("+points.length+" points maximum)");
                  }
               }         
               creationPoint = true;
               modifSegment = false;
               nvxSegment = false;            
               repaint();   
            }
         }
      }
      /**
       * Est appelé si la souris est relachée
       * Appel la méthode creationSegment(int,int) qui permet de créer des Segments
       * @see #creationSegment(int x,int y)
       * @param me Variable de type MouseEvent
       * @see java.awt.event.MouseEvent
       */
      @Override
      public void mouseReleased (MouseEvent me) {
         if(scale <= 3){
            v=indicePoint-1;
            r=0;
            u = indicePointsDroite-1;
            s = 0; 
            mouvDroite=true;
            mouvPoint=true;         
            if(btnPoint.isSelected()){   //Si le bouton point est selectionne
               modifPoint = true;
            }
            if(btnSegment.isSelected()){   //Si le bouton segment est selectionne
               creationSegment(me.getX(),me.getY());
            }
         }
      }
      /**
       * Donne la position de la souris par rapport au Repere 
       * @see Repere
       * @param me Variable de type MouseEvent
       * @see java.awt.event.MouseEvent
       */
      @Override
      public void mouseMoved(MouseEvent me) {
         repaint();
         this.posSouris.setText("X = " + ((int)rep.Abs(me.getX())/*scale*/) + " | Y = " + ((int)rep.Ord(me.getY()))/*scale*/);  //Info sur la position de la souris
         posMouseX = (int)rep.Abs(me.getX())/scale;
         posMouseY = (int)rep.Ord(me.getY())/scale;
         repaint();
      }  
      
      @Override
      public void mouseEntered (MouseEvent me) {}
      
      @Override
      public void mouseExited (MouseEvent me) {} 
      /**
       * Detecter si la molette de la souris est utilisée, si c'est le cas augement ou diminue selon le cas
       * la variable scale qui permet de parametrer le zoom.
       * @param me Variable de type MouseEvent
       * @see java.awt.event.MouseEvent
       */
      @Override
      public void mouseWheelMoved(MouseWheelEvent me){
         System.out.println("Wheel = "+me.getWheelRotation()+" && Scale = "+scale);
         if(me.getWheelRotation()<1 && scale >=1)
            scale -= (int)me.getWheelRotation();
         else if(me.getWheelRotation()>=1 && scale >1)
            scale -= (int)me.getWheelRotation(); 

         if(scale <= 3){
            btnPoint.setEnabled(true);
            btnSegment.setEnabled(true);
            btnDroite.setEnabled(true);
            if(creationPoint){
               btnSelection.setEnabled(true);
            }
         }
         else if(scale == 4){
            btnPoint.setEnabled(true);
            btnSegment.setEnabled(false);
            btnDroite.setEnabled(false);
            btnSelection.setEnabled(false);
         }
         else{
            btnPoint.setEnabled(false);
            btnSegment.setEnabled(false);
            btnDroite.setEnabled(false);
            btnSelection.setEnabled(false);
         }
         x=me.getX();
         y=me.getY();
         repaint();
      }          
   }    			   
}