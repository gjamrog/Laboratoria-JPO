package lab3;
import javax.swing.JApplet;
import java.awt.*;
public class SpringApplet extends JApplet {
	void rysujwektor(Vector2D wektor, Graphics g,int id)
	{
	  int xo=250;             //wyliczam polozenia na osi appletu
	  int yo=250;
	  double xy=250+10*Math.round(wektor.x*10)/10;
	  double yy=250-10*Math.round(wektor.y*10)/10;
	  int xk= (int)xy;
	  int yk= (int)yy;
	  g.drawLine(xo,yo,xk,yk);    //rysuje wektory
	  if(wektor.x>0&&wektor.y>00) {
		  g.drawLine(xk-5,yk,xk,yk);
		  g.drawLine(xk,yk,xk,yk+5);}
	  if ((wektor.x<0&&wektor.y>0)) {
		  g.drawLine(xk,yk,xk+5,yk);
		  g.drawLine(xk,yk,xk,yk+5);  
	  }
	  if ((wektor.x<0&&wektor.y<0)) {
		  g.drawLine(xk,yk,xk+5,yk);
		  g.drawLine(xk,yk,xk,yk-5);  
	  }
	  if ((wektor.x>0&&wektor.y<0)) {
		  g.drawLine(xk,yk,xk-5,yk);
		  g.drawLine(xk,yk,xk,yk-5);  
	  }
	  g.drawString("Wektor nr " +id +"     x:      " +wektor.x +"  y:      " +wektor.y +"      Dlugosc: " +Math.round(wektor.dlugosc()*100)/100,10,520+id*12);
	}
	public void init() {
		//Tworze obiekty klasy Vector2D za pomocy konstruktora z parametrami
				Vector2D w1 = new Vector2D(10,10);    
				Vector2D w2 = new Vector2D(20,20);
		//Dodaje, odejmuje podajac obiekt jako argument
				Vector2D w3 = w1.dodaj(w2);           
				Vector2D w4 = w1.odejmij(w2);
				Vector2D w5 = w1.znormalizuj();
				Vector2D w6 = w2.znormalizuj();
				Vector2D w7 = w3.znormalizuj();
				Vector2D w8 = w4.znormalizuj();
		//Przypisuje dlugosci do zmiennych
				double dl1 = w1.dlugosc();     
				double dl2 = w2.dlugosc();
				double dl3 = w3.dlugosc();
				double dl4 = w4.dlugosc();
				double dl5 = w5.dlugosc();
				double dl6 = w6.dlugosc();
				double dl7 = w7.dlugosc();
				double dl8 = w8.dlugosc();
		//Mnoze wektor przez stala
				Vector2D w9 = w1.mnoz(8);          
				System.out.println("Wektor o parametrach: ");         //Wypisuje dane wektorow
				System.out.println("x :" +w1.x +" y: " +w1.y);
				System.out.println("Dlugosc: " +w1.dlugosc());
				System.out.println("Wektor o parametrach: ");
				System.out.println("x :" +w2.x +" y: " +w2.y);
				System.out.println("Dlugosc: " +w2.dlugosc());
				System.out.println("Wektor o parametrach: ");
				System.out.println("x :" +w3.x +" y: " +w3.y);
				System.out.println("Dlugosc: " +w3.dlugosc());
				System.out.println("Wektor o parametrach: ");
				System.out.println("x :" +w4.x +" y: " +w4.y);
				System.out.println("Dlugosc: " +w4.dlugosc());
				System.out.println("Wektor o parametrach: ");
				System.out.println("x :" +w5.x +" y: " +w5.y);
				System.out.println("Dlugosc: " +w5.dlugosc());
				System.out.println("Wektor o parametrach: ");
				System.out.println("x :" +w6.x +" y: " +w6.y);
				System.out.println("Dlugosc: " +w6.dlugosc());
				System.out.println("Wektor o parametrach: ");
				System.out.println("x :" +w7.x +" y: " +w7.y);
				System.out.println("Dlugosc: " +w7.dlugosc());
				System.out.println("Wektor o parametrach: ");
				System.out.println("x :" +w8.x +" y: " +w8.y);
				System.out.println("Dlugosc: " +w8.dlugosc());
				System.out.println("Wektor o parametrach: ");
				System.out.println("x :" +w9.x +" y: " +w9.y);
				System.out.println("Dlugosc: " +w9.dlugosc());

	}
	public void paint(Graphics g) {
//ustawiam wielkosc okna apletu 550x700
		setSize(550,700);  //rysuje linie osi x, y       
		g.drawLine(250, 0 , 250, 500);        
		g.drawLine(10, 250, 500, 250);
		g.drawLine(245,10,250,0);
		g.drawLine(250, 0, 255, 10);
		g.drawLine(490, 245, 500, 250);
		g.drawLine(500, 250, 490, 255);
		g.drawString("x", 500, 260);
		g.drawString("y", 260, 10); //tworze obiekty
		Vector2D w1 = new Vector2D(5,-5);           
		Vector2D w2 = new Vector2D(12,12);
		Vector2D w3 = w1.dodaj(w2);
		Vector2D w4 = w1.odejmij(w2); //rysuje wektory za pomoca metody
		g.setColor(Color.blue);
		rysujwektor(w1, g,1); 
		g.setColor(Color.green);
		rysujwektor(w2,g,2);
		g.setColor(Color.red);
		rysujwektor(w3,g,3);
		g.setColor(Color.pink);
		rysujwektor(w4,g,4);
		
		
	}
	public void init(int a) {}
	public void paint(int a) {}
}

