package dessin;

import java.awt.Graphics;

public class Dessin_Rectangle extends Dessin_Figure
{
  public Dessin_Rectangle(Rectangle_mine r)
  {
    super(r);
  }

  public void dessin(Graphics g,Figure fig)
  {
    int x_1=fig.get_x();
    int y_1=fig.get_y();
    int x_2=fig.get_p().get_x();
    int y_2=fig.get_p().get_y();

    int width=Math.abs(x_1-x_2);
    int height=Math.abs(y_1-y_2);

    int x=x_1;
    int y=y_1;

    if(x>x_2)
    {
      x=x_2;
    }
    if(y>y_2)
    {
      y=y_2;
    }

    g.setColor(fig.get_color());

    if(fig.get_plein())
    {
      g.fillRect(x,y,width,height);
    }else
    {
      g.drawRect(x,y,width,height);
    }

  }
}
