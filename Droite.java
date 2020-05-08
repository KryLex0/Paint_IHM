package dessin;

import java.awt.Color;
public class Droite extends Rectangle_mine
{
  public Droite(int x,int y,int rotation,int p1_x,int p1_y,Color color)
  {
    super(x,y,rotation,p1_x,p1_y,false,color);
    this.vue=new Dessin_Droite(this);
  }

  public String type()
  {
    return "Droite";
  }
}
