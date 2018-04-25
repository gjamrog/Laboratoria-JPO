package lab5;


public class SimEngine {
	private double masa;  //prywatne pola
	private double Lo;
	private double k;
	private double c;
	public  double polozenie;
	private double v;
	private double xz;
	private double g;
	private double przyspieszenie;
	private double sila;
	public SimEngine(double mz, double kz, double cz, double Loz, double xz, double vz, double xzz, double gz) //konstruktor z parametrami
	{
		this.masa = mz;
		this.k =kz;
		this.c = cz;
		this.Lo = Loz;
		this.polozenie=xz;
		this.v=vz;
		this.xz=xzz;
		this.g=gz;
		if(masa <=0)
		{
			System.out.println("Masa musi byc wieksza od 0! Ustawiam wartosc domyslna 1");
			this.masa = 1;
		}
	}
	public void symulacja(double krok) //metoda obliczajaca przebieg symulacji
	{
	    sila=masa*g-k*(xz+polozenie)-c*v;
	    przyspieszenie = sila/masa;
		this.v=v+przyspieszenie*krok;
		this.polozenie=polozenie+v*krok+przyspieszenie*krok*krok/2;
	}
	public Vector2D przyspieszenie()
	{
		Vector2D wektor_przyspieszenia = new Vector2D(0, masa*przyspieszenie);
		return wektor_przyspieszenia;
	}
	public Vector2D predkosc()
	{
		Vector2D wektor_predkosci = new Vector2D(0, v);
		return wektor_predkosci;
	}
	public Vector2D polozenie()
	{
		Vector2D wektor_polozenia = new Vector2D(0, polozenie);
		return wektor_polozenia;
	}
	public double reset()   //metoda resetujaca symulacje
	{
		this.v=0;
		return 0;
	}
	


}


