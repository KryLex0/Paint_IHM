package dessin;

import java.awt.Color;
public class Rectangle_mine extends Figure
{
  private Point p;

  public Rectangle_mine(int x,int y,int rotation,int p_x,int p_y,boolean plein,Color color)
  {
    super(x,y,rotation,plein,color);
    this.p=new Point(p_x,p_y);
    this.vue=new Dessin_Rectangle(this);
  }

  public Point get_p()
  {
    return this.p;
  }

  public void set_p(int x, int y)
  {
    this.p.set_x(x);
    this.p.set_y(y);
  }

  public String type()
  {
    return "Rectangle";
  }

}
