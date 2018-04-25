package lab4;
import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
public class SpringApplet extends JApplet {
    private SimEngine silnik;
    private SimTask obiekt;
    private Timer timer;
    private Graphics Buffer; //buffer
    private Image Screen;    //przechowany obraz
    
	
	public void init() {
		setSize(200,600);
		silnik = new SimEngine(1,6,0.1,1,5,1,1,10);
		obiekt = new SimTask(silnik,this,0.05);
		Timer timer = new Timer();
	    timer.scheduleAtFixedRate(obiekt,40,50);
	    Screen = createImage( this.getWidth(), this.getHeight() ); //podwojne bufferowanie
        Buffer = Screen.getGraphics();

		
	}
	public void paint(Graphics g) {
	 Graphics2D g1=(Graphics2D) Buffer; //rozszerzenie klasy graphics
	 g.drawImage( Screen, 0, 0, this ); //przeniesienie bufforu
	 g1.setColor(Color.white);
	 g1.fillRect(0, 0, 500, 800);
	 g1.setColor(Color.black);
	 BasicStroke grubas = new BasicStroke(1.0f);
	 g1.setStroke(grubas);
	 for(int i=0;i<=10;i++)
	 {
		int d=200/10;
		g1.drawLine(d*i,0 , d*i, 600);
	 }
	 for(int i=0;i<=30;i++)
	 {
		 int d=600/30;
		 g1.drawLine(0,d*i,200,d*i);
		 
	 }
	 Vector2D wektor = new Vector2D();
	 Vector2D predkosc = new Vector2D();
	 Vector2D przyspieszenie = new Vector2D();
	 przyspieszenie=silnik.przyspieszenie();
	 wektor=silnik.polozenie(); 
	 predkosc=silnik.predkosc();
	 g1.fillOval(95,(int)(wektor.y*100),10, 10);
	 rysujsprezyne(wektor,g1);
	 g1.setColor(Color.blue);
	 g1.drawString("Wartosc predkosci: " + (double)(Math.round(predkosc.y*100))/100, 5, 540);
	 rysujwektor(predkosc.y,wektor.y,g1,4);
	 g1.setColor(Color.red);
	 rysujwektor(przyspieszenie.y,wektor.y,g1,1);
	 g1.drawString("Wartosc wypadkowej sily: " + (double)(Math.round(przyspieszenie.y*100))/100, 5, 500);
	 rysujutwierdzenie(g1);
	}
	
	public void init(int a) {}
	public void paint(int a) {}
	void rysujwektor(double y, double punkt, Graphics g,int wielokrotnosc)
	{
	  double yy=10*Math.round(y*10)/10;
	  int yk= (int)yy;
	  Graphics2D g2=(Graphics2D)g;
	  BasicStroke grubas = new BasicStroke(2.0f);
	  g2.setStroke(grubas);
	  g.drawLine(100,(int)(punkt*100),100,(int)(punkt*100)+yk*wielokrotnosc);    //rysuje wektory
	  if(punkt*100>((punkt*100)+yk*wielokrotnosc))
	  {
		  g.drawLine(100,(int)(punkt*100)+yk*wielokrotnosc,110,(int)(punkt*100)+yk*wielokrotnosc+10);
		  g.drawLine(100,(int)(punkt*100)+yk*wielokrotnosc,90,(int)(punkt*100)+yk*wielokrotnosc+10);
	  }
	  else if(punkt*100<((punkt*100)+yk*wielokrotnosc))
	  {
		  g.drawLine(100,(int)(punkt*100)+yk*wielokrotnosc,110,(int)(punkt*100)+yk*wielokrotnosc-10);
		  g.drawLine(100,(int)(punkt*100)+yk*wielokrotnosc,90,(int)(punkt*100)+yk*wielokrotnosc-10);
	  }}
void rysujutwierdzenie(Graphics g)
	  {
		  g.setColor(Color.black);
			 g.drawLine(60, 5, 140, 5);
			 g.drawLine(60, 0, 60, 5);
			 g.drawLine(140, 0, 140, 5);
			 for(int i=0;i<10;i++)
			 {
				 int d=80/10;
				 g.drawLine(60+d*i,5, 60+d*(i+1), 0);
			 }
	  }
void rysujsprezyne(Vector2D wektor,Graphics g)
{
		  double podzialka = 0.05;
			 int id=0;
			 for(int i=0; i<19;i++)
			 {
				 	
				 	if(id==1)
				 	{
					g.drawLine(120, (int)(wektor.y*podzialka*100*i), 80, 10+(int)(wektor.y*podzialka*100*i));
					g.drawLine(80, 10+(int)(wektor.y*podzialka*100*i), 120, (int)(wektor.y*podzialka*100*(i+1)));
				 	}
				 	if(id==0&i==1)
				 	{	g.drawLine(100, 0, 100, 10);
				 		g.drawLine(100, 10, 80, 10+(int)(wektor.y*podzialka*100*i));
				 		g.drawLine(80, 10+(int)(wektor.y*podzialka*100*i), 120, (int)(wektor.y*podzialka*100*(i+1)));
				 		g.drawLine(120, (int)(wektor.y*podzialka*100*19), 100, (int)(wektor.y*podzialka*100*19.7));
				 		g.drawLine(100, (int)(wektor.y*podzialka*100*19.7), 100, (int)(wektor.y*100));
				 		id=1;
				 	}
			 }
		  
	  }
}
