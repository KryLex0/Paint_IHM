package dessin;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTabbedPane;

public class Fenetre extends JFrame
{
  private JPanel general;
  private Dessin dessin;
  private String forme;
  private int x;
  private int y;
  private boolean first_clic=false;
  private boolean second_clic=false;
  private int old_x;
  private int old_y;
  private int old_x_2;
  private int old_y_2;
  private int rayon;
  private int rayon2;
  private Vue zone;
  private JPanel jp;
  private JButton b_select;
  private JTabbedPane onglets;
  private JButton remplis;
  private boolean remplissage=false;
  private Color couleur;
  private JColorChooser tcc;
  BoutonListener blis=new BoutonListener();

  private static final JLabel figLabel = new JLabel("Figure");
  private static final String[] fig = {"Cercle", "Droite", "Ellipse", "Rectangle", "Triangle"};
  private static final JComboBox figure = new JComboBox(fig);

  private static final JLabel plein = new JLabel("Remplissage");
  private static final String[] rempli = {"Plein", "Vide"};
  private static final JComboBox choixRemplissage = new JComboBox(rempli);


  public Fenetre(Dessin dessin)
  {
    super("Fenetre de Dessin");

    this.dessin=dessin;
    this.setSize(800,600);
    this.initialise();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(true);
  }

  public void initialise()
  {
    onglets=new JTabbedPane();

    general=new JPanel();
    general.setLayout(new BorderLayout());
    initPanelNord();
    general.add(jp,BorderLayout.NORTH);

    zone=new Vue(dessin);
    CurseurListener mlis=new CurseurListener();
    zone.addMouseListener(mlis);
    MouveMouseListener mml=new MouveMouseListener();
    zone.addMouseMotionListener(mml);

    general.add(zone,BorderLayout.CENTER);

    onglets.add("Dessin",general);
    onglets.add("Couleurs",initPanelDroite());

    this.add(onglets);

    this.addKeyListener(new Clavier());
  }

  public void actualiser()
  {
    zone=new Vue(dessin);
    b_select.setBackground(null);
    repaint();
  }

  public JPanel initPanelDroite()
  {
    JPanel couleurs=new JPanel();

    tcc= new JColorChooser();
    CouleurListener cl=new CouleurListener();
    tcc.getSelectionModel().addChangeListener(cl);
    tcc.setBorder(BorderFactory.createTitledBorder("Choisissez votre couleur"));
    couleurs.add(tcc);
    return couleurs;
  }

  public void initPanelNord()
  {
    jp=new JPanel();;

    jp.add(figLabel);
    jp.add(figure);
    figure.addMouseListener(new CurseurListener());

    jp.add(plein);
    jp.add(choixRemplissage);

    JButton del=new JButton("Effacer");
    del.addActionListener(blis);
    jp.add(del);
  }


  class Clavier implements KeyListener {

      public void keyPressed (KeyEvent e){
        if (e.getKeyChar() == 'c'){
          figure.getModel().setSelectedItem("Cercle");
          forme = "Cercle";
          if(e.isControlDown()){
            choixRemplissage.getModel().setSelectedItem("Plein");
          }
          else{
            choixRemplissage.getModel().setSelectedItem("Vide");
          }
        }

  //-----------------------------------------------------------------------------------------------------------------------------------

        else if (e.getKeyChar()=='d'){
          figure.getModel().setSelectedItem("Droite");
          forme = "Droite";
          if(e.isControlDown()){
            choixRemplissage.getModel().setSelectedItem("Plein");
          }
          else{
            choixRemplissage.getModel().setSelectedItem("Vide");
          }
        }

  //-----------------------------------------------------------------------------------------------------------------------------------

        else if (e.getKeyChar()=='e'){
          figure.getModel().setSelectedItem("Ellipse");
          forme = "Ellipse";
          if(e.isControlDown()){
            choixRemplissage.getModel().setSelectedItem("Plein");
          }
          else{
            choixRemplissage.getModel().setSelectedItem("Vide");
          }
        }

  //-----------------------------------------------------------------------------------------------------------------------------------

        else if (e.getKeyChar()=='r'){
          figure.getModel().setSelectedItem("Rectangle");
          forme = "Rectangle";
          if(e.isControlDown()){
            choixRemplissage.getModel().setSelectedItem("Plein");
          }
          else{
            choixRemplissage.getModel().setSelectedItem("Vide");
          }
        }

  //-----------------------------------------------------------------------------------------------------------------------------------

        else if (e.getKeyChar()=='t'){
          figure.getModel().setSelectedItem("Triangle");
          forme = "Triangle";
          if(e.isControlDown()){
            choixRemplissage.getModel().setSelectedItem("Plein");
          }
          else{
            choixRemplissage.getModel().setSelectedItem("Vide");
          }
        }

      }

      public void keyReleased (KeyEvent e){}

      public void keyTyped (KeyEvent e){}
    }


  class CurseurListener extends MouseAdapter
  {
    int pos_x;
    int pos_y;
    int rayon;

    public void mouseReleased(MouseEvent e){

    }

    public void mouseClicked(MouseEvent e)
    {
      if(figure.getSelectedItem().toString() == "Cercle"){
          forme = "Cercle";
        }
      if (figure.getSelectedItem().toString() == "Droite"){
          forme = "Droite";
      }
      if (figure.getSelectedItem().toString() == "Ellipse"){
          forme = "Ellipse";
      }
      if (figure.getSelectedItem().toString() == "Rectangle"){
          forme = "Rectangle";
      }
      if (figure.getSelectedItem().toString() == "Triangle"){
          forme = "Triangle";
      }

      requestFocus();
      repaint();
      
      if(forme!=null)
      {
        x=e.getX();
        y=e.getY();
        switch(forme)
        {
          case "Cercle":
            if(!first_clic)
            {
              old_x=x;
              old_y=y;
              first_clic=true;
            }else
            {
              pos_x=old_x;
              pos_y=old_y;
              rayon=Math.abs(x-old_x);
              if(old_x>x)
              {
                pos_x=x;
              }
              if(old_y>y)
              {
                pos_y=y;
              }

              if(choixRemplissage.getSelectedItem().toString() == "Plein"){
                remplissage = true;
              }
              else{
                remplissage = false;
              }

              dessin.add(new Cercle(pos_x,pos_y,0,rayon,remplissage,couleur));
              forme=null;
              first_clic=false;
              actualiser();
            }
            break;

//-------------------------------------------------------------------------------------------------------------------------------

            case "Droite":
              if(!first_clic)
              {
                old_x=x;
                old_y=y;
                first_clic=true;
              }else
              {
                dessin.add(new Droite(old_x,old_y,0,x,y,couleur));
                first_clic=false;
                forme=null;
                actualiser();
              }
              break;

//-------------------------------------------------------------------------------------------------------------------------------

              case "Ellipse":
                if(!first_clic)
                {
                  old_x=x;
                  old_y=y;
                  first_clic=true;
                }else
                {
                  rayon=Math.abs(x-old_x);
                  rayon2=Math.abs(y-old_y);
                  if(old_x>x)
                  {
                    old_x=x;
                  }
                  if(old_y>y)
                  {
                    old_y=y;
                  }

                  if(choixRemplissage.getSelectedItem().toString() == "Plein"){
                    remplissage = true;
                  }
                  else{
                    remplissage = false;
                  }
                  dessin.add(new Ellipse(old_x,old_y,0,rayon,rayon2,remplissage,couleur));
                  first_clic=false;
                  forme=null;
                  actualiser();
                }
                break;

//-------------------------------------------------------------------------------------------------------------------------------

          case "Rectangle":
            if(!first_clic)
            {
              old_x=x;
              old_y=y;
              first_clic=true;
            }else
            {
              if(choixRemplissage.getSelectedItem().toString() == "Plein"){
                remplissage = true;
              }
              else{
                remplissage = false;
              }
              dessin.add(new Rectangle_mine(old_x,old_y,0,x,y,remplissage,couleur));
              first_clic=false;
              forme=null;
              actualiser();
            }
            break;

//-------------------------------------------------------------------------------------------------------------------------------

          case "Triangle":
            if(!first_clic)
            {
              old_x=x;
              old_y=y;
              first_clic=true;
            }else if(!second_clic)
            {
              old_x_2=x;
              old_y_2=y;
              second_clic=true;
            }else
            {
              if(choixRemplissage.getSelectedItem().toString() == "Plein"){
                remplissage = true;
              }
              else{
                remplissage = false;
              }
              dessin.add(new Triangle(old_x,old_y,0,old_x_2,old_y_2,x,y,remplissage,couleur));
              first_clic=false;
              second_clic=false;
              forme=null;
              actualiser();
            }
            break;




        }
      }

    }
  }

  class MouveMouseListener implements MouseMotionListener
  {
    java.awt.Point mp;
    boolean ajouter=false;

    public void mouseDragged(MouseEvent med)
    {
    }
    public void mouseMoved(MouseEvent med2){}

    public void mouseExited(MouseEvent e){}
  }

  class BoutonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String commande=e.getActionCommand();
      if(commande=="Remplissage")
      {
        if(remplissage)
        {
          remplissage=false;
          remplis.setBackground(null);
        }else
        {
          remplissage=true;
          remplis.setBackground(couleur);
        }
      }else
      {
        if(b_select!=null)
        {
          b_select.setBackground(null);
        }
        b_select=(JButton)e.getSource();
        b_select.setBackground(Color.RED);
        forme=commande;
      }


      dessin.remove(dessin.size()-1);
      actualiser();

      if(commande=="Effacer")
      {
        while (!dessin.isEmpty())
        {
          dessin.remove(dessin.size()-1);
        }
        actualiser();
      }
    }
  }

  class CouleurListener implements ChangeListener
  {
    public void stateChanged(ChangeEvent cou)
    {
      couleur=tcc.getColor();
      if(remplissage==true)
      {
        remplis.setBackground(couleur);
      }
    }
  }

  public static void main(String[] args)
  {
    Dessin dessin=new Dessin("Fenetre");
    Fenetre f=new Fenetre(dessin);
  }

}
