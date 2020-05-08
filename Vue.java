package dessin;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import java.io.*;

public class Vue extends JPanel
{
  private Dessin dessin;

  public Vue(Dessin dessin)
  {
    super();
    this.dessin=dessin;
  }
  public void paint(Graphics g)
  {
    aff(g);
  }


  public void aff(Graphics g)
  {
    Iterator<Figure> ite=dessin.iterator();
    Figure fig;
    String type;
    int x;
    int y;
    int width;
    int height;
    int temp_x;
    int temp_y;

    while(ite.hasNext())
    {
      fig=ite.next();
      fig.vue.dessin(g,fig);
    }
  }

}
