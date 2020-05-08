package dessin;

import java.awt.Graphics;

public class Dessin_Triangle extends Dessin_Figure
{
  public Dessin_Triangle(Triangle t)
  {
    super(t);
  }

  public void dessin(Graphics g, Figure fig)
  {
    g.setColor(fig.get_color());
    if(fig.get_plein())
    {
      g.fillPolygon(fig.get_x_triangle(fig),fig.get_y_triangle(fig),3);
    }else
    {
      g.drawPolygon(fig.get_x_triangle(fig),fig.get_y_triangle(fig),3);
    }

  }
}
