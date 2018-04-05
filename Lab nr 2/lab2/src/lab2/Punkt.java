package lab2;

public class Punkt 
{ 
  public double masa ;       //masa punktu
  public double odl =0 ;       //odleglosc puktu od bieguna
  public Punkt()              // konstruktor domyslny
  {
	  this.masa=1;         
  }
  public Punkt(double masa)     //konstruktor pozwalajacy na nadanie masy 
  {
	  this.masa=masa;
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
  double Momentbez()              //metoda pozwalajaca obliczyc moment bezwladnosci
  {  
	  return this.masa*Math.pow(this.odl, 2);
  }
  double Momentbez(int steiner)     //metoda obliczajaca moment bezwladnosci z tw. Steinera(metoda przeciazona)
  {   
	  return this.masa*Math.pow(steiner, 2);
  }
  void opis()                 //opis punktu
  {
	  System.out.println("Punkt materialny");
	  System.out.println("Masa punktu: " +this.masa);
	  System.out.println("Glowny moment bezwladnosci wynosi: " +Momentbez());
  }
  void opis(int steiner)     //opis punktu(metoda przeciazona)
  { 
	  System.out.println("Moment bezwladnosci wzgledem nowej osi w odleglosci: " + steiner +" wynosi : " +Momentbez(steiner));
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
