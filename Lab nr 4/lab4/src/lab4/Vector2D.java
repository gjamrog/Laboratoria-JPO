package lab4;
import static java.lang.Math.sqrt;
public class Vector2D {
	//publiczne pola wspolrzedne punktow  x y
	public double x;  
	public double y;
	// konstruktor domyslny
	public Vector2D()
	{
		this.x=1;
		this.y=1;
	}
	//konstruktor z parametrami
	public Vector2D(double xp, double yp)
	{
		this.x=xp;
		this.y=yp;
	}
	//metoda z  parametrem zwracajaca nowy obiekt bedacy suma wektorow
	public Vector2D dodaj(Vector2D wektorek) {
		Vector2D wektor =  new Vector2D(this.x+wektorek.x,this.y+wektorek.y);
		return wektor;
	}
	//metoda z parametrem zwracajaca nowy obiekt bedacy roznica wektorow
	public Vector2D odejmij(Vector2D wektorek) {
		Vector2D wektor =  new Vector2D(this.x-wektorek.x,this.y-wektorek.y);
		return wektor;
	}
	//metoda z parametrem zwracajaca nowy obiekt bedacy wektorem przemnozonym przez stala
	public Vector2D mnoz(double stala) {
		Vector2D wektor =  new Vector2D(this.x*stala,this.y*stala);
		return wektor;
	}
	//metoda bez parametru zwracajaca dlugosc	
	public double dlugosc() {
	  return sqrt(this.x*this.x+this.y*this.y);	
	}
	//metoda bez parametru zwracajaca nowy obiekt bedacy wektorem znormalizowanym
    public Vector2D znormalizuj(){
    	Vector2D wektor = new Vector2D(this.x/dlugosc(),this.y/dlugosc());
    	return wektor;
    }}
