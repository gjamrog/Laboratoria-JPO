package lab2;

public class Pret extends Punkt {      //klasa pochodna
	public double dl;
	public Pret()                      //konstruktor domyslny przy uzyciu superklasy
	{ super();
	  this.dl = 1;
	}
	public Pret(int masa,  int dl)    //konstruktor z parametrami przy uzyciu superklasy
	{  super(masa);
	   super.setmasa(masa);
	   kontrolawartosci(dl);
	}
	double Momentbez(int steiner)    //metoda przeciazona z parametrem
	{   
		return (this.masa*Math.pow(this.dl, 2)/12)+super.Momentbez(steiner);
	}
	double Momentbez()                //metoda przeciazona bez parametrow
	{
		return this.masa*Math.pow(this.dl, 2)/12 ;
	}
	void kontrolawartosci(int dl)       //akcesor z kontrola wartosci
	{
		 if(dl>0)
			   this.dl = dl ; 
		   else
			   {System.out.println("Dlugosc nie moze byc mniejsza od zera. Ustawiam domyslna dlogosc rowna 1.");
		       this.dl=1;}
	}
	void opis()                       //przeciazona metoda opisu bez parametrow
	{
		System.out.println("Bryla : Pret");
		System.out.println("Masa: " +this.masa +" Dlugosc: " +this.dl);
		System.out.println("Moment bezwladnosci wgledem osi obrotu : " +Momentbez());
	}
	void opis(int steiner)          //przeciazona metoda opisu z parametrem
	{
		super.opis(steiner);
	}

}
