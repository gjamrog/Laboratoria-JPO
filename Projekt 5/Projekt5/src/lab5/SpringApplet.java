package lab5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
public class SpringApplet extends JApplet implements MouseMotionListener, MouseListener, ActionListener { //zaimplementowanie interfejsow
	private SimEngine silnik;
    private SimTask obiekt;
    private Timer timer;
    private boolean wartosc=false;
    private double xx=1;
    private Button reset; //pole z reset
    private TextField masa,k,c,przyspieszenie,lo; //pola z przyciskami
	public void init() {
		//Inicjalizacja stworzonych pol nowymi obiektami
		setSize(400,600);
		silnik = new SimEngine(10,4,0.4,0.1,1,1,1,100);
		obiekt = new SimTask(silnik,this,0.3);
		obiekt = new SimTask(silnik,this,0.3);
		Timer timer = new Timer();
	    timer.scheduleAtFixedRate(obiekt,50,60);
	    addMouseListener(this);    //dodanie nasluchiwacza
		addMouseMotionListener(this);;
		reset=new Button("Reset"); //wypisanie przyciskow wraz z ich wartosciami poczatkowymi
    	masa=new TextField("10");
    	k=new TextField("4");
    	c=new TextField("0.4");
    	przyspieszenie=new TextField("10");
    	lo=new TextField("1");
    	add(masa);  //dodanie przyciskow do appletu
    	add(k);
    	add(c);
    	add(przyspieszenie);
    	add(lo);
    	add(reset);
		reset.addActionListener(this); //dodanie nasluchiwacza do obiektu reset
	}
	public void paint(Graphics g) {
	 System.out.println(silnik.polozenie);
	
	 g.setColor(Color.white);
	 g.fillRect(0, 0, 500, 800);
	 g.setColor(Color.black);
	 Vector2D wektor = new Vector2D();           //stworzene obieku wektor
	 wektor=silnik.polozenie();  //przypisanie wspolrzednych polozenia do wektora z klasy Vector2D
	 rysujsprezyne(wektor,g);
	 rysujutwierdzenie(g);
	 g.fillOval(90,(int)(wektor.y),20, 20);  //narysowanie ovalu
	 g.drawString("Masa:", 250, 110);    //narysowanie przyciskow wraz z podpisami
	 masa.setBounds(350,100,30,20);
	 g.drawString("Wspolczynnik k:", 250, 135);
	 k.setBounds(350,120,30,20);
	 g.drawString("Wspolczynnik c:", 250, 155);
	 c.setBounds(350,140,30,20);
	 g.drawString("Przyspieszenie:", 250, 175);
	 przyspieszenie.setBounds(350,160,30,20);
	 g.drawString("Wychylenie:", 250, 195);
	 lo.setBounds(350,180,30,20);
	 reset.setBounds(350,220,30,20);
	}
	
	public void init(int a) {}
	public void paint(int a) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();
		Vector2D wektor = new Vector2D();          //stworzenei wektora
		wektor=silnik.polozenie(); 
		if(x>95&&x<105&&y>(int)(wektor.y*100-5)&&y<(int)(wektor.y*100+5))
		{
			timer.cancel();    //zatrzymanie timera
			silnik.reset();     //reset predkosci
			wartosc=true;
			e.consume();
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(wartosc==true)
		{
			timer.scheduleAtFixedRate(obiekt,50,60);  //wznowienie timera      
			e.consume();//zmiana wartosci logicznej 
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {

		
		int y=e.getY();	
		silnik.polozenie=y; //zmiana wartosci polozenia
		silnik.reset();    //reset
		wartosc=false; 
		e.consume();
		
		// TODO Auto-generated method stub
		}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//sprawdzenei czy zrodlem akcji jest przycisk
		if(arg0.getSource()==reset)
      	{
      		silnik.reset();
    		timer.cancel();
    		//zamiana tekstu na liczby
      		double m=Double.parseDouble(masa.getText());
      		double ka=Double.parseDouble(k.getText());
      		double ce=Double.parseDouble(c.getText());
      		double a=Double.parseDouble(przyspieszenie.getText());
      		double Lo=Double.parseDouble(lo.getText());
      		//nadanie nowych parametrow
            silnik=new SimEngine(m,ka,ce,Lo,Lo,Lo,1,a);
            obiekt =new SimTask(silnik,this,0.5);
            timer = new Timer();
            timer.scheduleAtFixedRate(obiekt,0,150);
      		repaint();
       }
		// TODO Auto-generated method stub
		
	}
	void rysujsprezyne(Vector2D wektor,Graphics g)
	{
			  double podzialka = 0.05;
				 int id=0;
				 for(int i=0; i<19;i++)
				 {
					 	
					 	if(id==1)
					 	{
						g.drawLine(120, (int)(wektor.y*podzialka*i), 80, 10+(int)(wektor.y*podzialka*i));
						g.drawLine(80, 10+(int)(wektor.y*podzialka*i), 120, (int)(wektor.y*podzialka*(i+1)));
					 	}
					 	if(id==0&i==1)
					 	{	g.drawLine(100, 0, 100, 10);
					 		g.drawLine(100, 10, 80, 10+(int)(wektor.y*podzialka*i));
					 		g.drawLine(80, 10+(int)(wektor.y*podzialka*i), 120, (int)(wektor.y*podzialka*(i+1)));
					 		g.drawLine(120, (int)(wektor.y*podzialka*19), 100, (int)(wektor.y*podzialka*19.7));
					 		g.drawLine(100, (int)(wektor.y*podzialka*19.7), 100, (int)(wektor.y));
					 		id=1;
					 	}}}
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


	
}


