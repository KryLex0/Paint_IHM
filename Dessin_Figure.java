package dessin;

import java.awt.Graphics;

public class Dessin_Figure
{
  private Figure f;

  public Dessin_Figure(Figure f)
  {
    this.f=f;
  }

  public Figure get_Figure()
  {
    return this.f;
  }

  public void dessin(Graphics g,Figure fig){}

}
