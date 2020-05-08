package dessin;

public class Point
{
  private int x;
  private int y;

  public Point(int x, int y)
  {
    this.x=x;
    this.y=y;
  }

  public int get_x()
  {
    return this.x;
  }

  public void set_x(int x)
  {
    this.x=x;
  }

  public int get_y()
  {
    return this.y;
  }

  public void set_y(int y)
  {
    this.y=y;
  }

  public String type()
  {
    return "Point";
  }
}
