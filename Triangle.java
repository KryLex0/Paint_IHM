package dessin;

import java.awt.Color;
public class Triangle extends Figure
{
  private Point p1;
  private Point p2;

  public Triangle(int x,int y,int rotation,int p1_x,int p1_y,int p2_x,int p2_y,boolean plein,Color color)
  {
    super(x,y,rotation,plein,color);
    this.p1=new Point(p1_x,p1_y);
    this.p2=new Point(p2_x,p2_y);
    this.vue=new Dessin_Triangle(this);
  }

  public Point get_p1()
  {
    return this.p1;
  }

  public void set_p1(int x, int y)
  {
    this.p1.set_x(x);
    this.p1.set_y(y);
  }

  public Point get_p2()
  {
    return this.p2;
  }

  public void set_p2(int x, int y)
  {
    this.p2.set_x(x);
    this.p2.set_y(y);
  }

  public int[] get_x_triangle(Figure t)
  {
    int[] tab=new int[3];

    tab[0]=t.get_p1().get_x();
    tab[1]=t.get_p2().get_x();
    tab[2]=t.get_x();

    return tab;
  }

  public int[] get_y_triangle(Figure t)
  {
    int[] tab=new int[3];

    tab[0]=t.get_p1().get_y();
    tab[1]=t.get_p2().get_y();
    tab[2]=t.get_y();

    return tab;
  }

  public String type()
  {
    return "Triangle";
  }
}
