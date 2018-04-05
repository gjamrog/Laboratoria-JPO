package lab2;

public class Walec extends Punkt {              //klasa pochodna
	public double wys;
	public double prom;
	public Walec()                             //konstruktor domyslny przy uzyciu superklasy
	{ super();
	  this.wys = 1;                    
	  this.prom = 1;
	}
	public Walec(int masa, int wys, int prom)    //konstruktor z parametrami przy uzyciu superklasy
	{  super(masa);
	   super.setmasa(masa);
	   kontrolawartosci(wys,prom);
	}
	double Momentbez(int steiner)        //metoda przeciazona z parametrem
	{   
		return (this.masa*Math.pow(this.prom, 2)/2)+super.Momentbez(steiner);
	}
	double Momentbez()                   //metoda przeciazona bez parametrow
	{
		return this.masa*Math.pow(this.prom, 2)/2 ;
	}
	void kontrolawartosci(int wys, int prom)       //akcesor z kontrola wartosci
	{
		if(wys<=0)
		{
			System.out.println("Wysokosc nie moze byc mniejsza od zera. Ustawiam domyslna wysokosc rowna 1.");
		       this.wys=1;
		}
		if(prom<=0)
		{
			System.out.println("Promien nie moze byc mniejszy od zera. Ustawiam domyslny promien rowny 1.");
		    this.prom=1;
		}
		else
		{
			this.wys=wys;
			this.prom=prom;
		}
	}
	void opis()                           //przeciazona metoda opisu bez parametrow
	{
		System.out.println("Bryla : Walec");
		System.out.println("Wysokosc: " +this.wys +" Promien: " +this.prom +" Masa: " +this.masa );
		System.out.println("Moment bezwladnosci wgledem osi obrotu : " +Momentbez());
	}
	void opis(int steiner)              //przeciazona metoda opisu z parametrem
	{
		super.opis(steiner);
	}
	
	
	
	

}
