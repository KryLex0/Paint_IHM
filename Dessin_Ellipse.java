package dessin;

import java.awt.Graphics;

public class Dessin_Ellipse extends Dessin_Figure
{
  public Dessin_Ellipse(Ellipse e)
  {
    super(e);
  }

  public void dessin(Graphics g,Figure fig)
  {
    System.out.println(fig.get_rayon());
    g.setColor(fig.get_color());
    if(fig.get_plein())
    {
      g.fillOval(fig.get_x(),fig.get_y(),fig.get_rayon(),fig.get_rayon2());
    }else
    {
      g.drawOval(fig.get_x(),fig.get_y(),fig.get_rayon(),fig.get_rayon2());
    }

  }

}
