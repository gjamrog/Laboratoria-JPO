package lab1;

public class punkt 
{ 
  private double masa ;       //masa punktu
  private double odl ;        //odleglosc puktu od bieguna
  public punkt()              // konstruktor domyslny
  {
	  this.masa=10;
	  this.odl = 6; 
  }
  public punkt(int masa)     //konstruktor pozwalajacy na nadanie masy 
  {
	  this.masa=masa;
	  this.odl= 6;
  }
  void setmasa(double nmasa) //metoda sluzaca do zmiany masy punktu
  {   if (nmasa>0)
  {
	  this.masa = nmasa; 
  }
  else 
  {
	  System.out.println("Masa musi byc wieksza od 0 !!. Ustawiam domyslna mase rowna 1");
	  this.masa=1;
  }
  }
  void momentbez()              //metoda pozwalajaca obliczyc moment bezwladnosci
  {
	  double moment = this.masa*Math.pow(odl,2);
	  System.out.println("Moment bezwladnowsci wzgledem bieguna w zerze: " +moment);
  }
  void steiner(int biegun)     //metoda obliczajaca moment bezwladnosci z tw. Steinera
  {   
	  double os = this.odl + Math.abs(biegun);
	  double Momst= this.masa*Math.pow(os, 2);
	  System.out.println("Moment bezwladnosci punktu wzgledem nowej osi w: " + biegun + " wynosi : " +Momst);	  
  }
  void opis()                 //opis punktu
  {
	  System.out.println("Punkt materialny");
	  System.out.println("Masa punktu: " +this.masa);
  }
  double Masa()             //metoda zwracajaca mase
  {
	  return this.masa;
  }
  double Odleglosc()       //metoda zwracajaca odleglosc od osi 0
  {
	  return this.odl;
  }
}
