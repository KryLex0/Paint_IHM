package dessin;

import java.io.*;
import java.util.*;

public class Dessin extends java.util.ArrayList<Figure>
{
  private String nom;

  public Dessin(String nom)
  {
    this.nom=nom;
  }

  public String get_nom()
  {
    return this.nom;
  }

  public void set_nom(String nom)
  {
    this.nom=nom;
  }
}
