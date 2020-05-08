package dessin;

import java.awt.Color;
public class Ellipse extends Cercle
{
  private int rayon2;

  public Ellipse(int x,int y,double rotation,int rayon,int rayon2,boolean plein,Color color)
  {
    super(x,y,rotation,rayon,plein,color);
    this.vue=new Dessin_Ellipse(this);
    this.rayon2=rayon2;
  }

  public int get_rayon2()
  {
    return this.rayon2;
  }

  public void set_rayon2()
  {
    this.rayon2=rayon2;
  }

  public String type()
  {
    return "Ellipse";
  }

}
