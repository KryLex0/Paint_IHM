package dessin;

import java.awt.Graphics;

public class Dessin_Droite extends Dessin_Figure
{
  public Dessin_Droite(Droite s)
  {
    super(s);
  }

  public void dessin(Graphics g,Figure fig)
  {
    g.setColor(fig.get_color());
    g.drawLine(fig.get_x(),fig.get_y(),fig.get_p().get_x(),fig.get_p().get_y());
  }
}
