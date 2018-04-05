package lab2;

public class Kula extends Punkt{      //klasa pochodna
    public double prom;
	public Kula()                     //konstruktor domyslny przy uzyciu superklasy
	{ super();
	  this.prom = 1;
	}
	public Kula(int masa, int prom)   //konstruktor z parametrami przy uzyciu superklasy
	{  super(masa);
	   super.setmasa(masa);
	   kontrolawartosci(prom); 
	}
	double Momentbez(int steiner)     //metoda przeciazona z parametrem
	{  
		return (2*this.masa*Math.pow(this.prom, 2)/5)+super.Momentbez(steiner);
	}
	double Momentbez()                  //metoda przeciazona bez parametrow
	{
		return 2*this.masa*Math.pow(this.prom, 2)/5 ;
	}
	void kontrolawartosci(int prom)     //akcesor z kontrola wartosci
	{
		 if(prom>0)
			   this.prom = prom ; 
		   else
			   {System.out.println("Promien nie moze byc mniejszy od zera. Ustawiam domyslny promien rowny 1.");
		       this.prom=1;}
	}
	void opis()                        //przeciazona metoda opisu bez parametrow
	{
		System.out.println("Bryla : Kula");
		System.out.println("Promien: " +this.prom +" Masa: " +this.masa );
		System.out.println("Moment bezwladnosci wgledem osi obrotu : " +Momentbez());
	}
	void opis(int steiner)            //przeciazona metoda opisu z parametrem
	{
		super.opis(steiner);
	}
}
