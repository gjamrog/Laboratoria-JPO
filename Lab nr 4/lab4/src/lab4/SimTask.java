package lab4;
import java.util.TimerTask;
public class SimTask extends TimerTask{
	private SimEngine silnik;   //prywatne pole do przechowywania obiektu SimEngine
	private SpringApplet applet; //prywatne pole do przechowywania obiektu SpringApplet
	private double odstep_czasowy; //krok czasowy
	public SimTask(SimEngine obiekt1 , SpringApplet obiekt2,double krok) //konstruktor z parametrami
	{
		silnik=obiekt1;
		applet=obiekt2;
		odstep_czasowy=krok;
	}
	public void run(){   //przeciazona publiczna metoda
		  silnik.symulacja(odstep_czasowy); //uruchamainie obliczenia koljnego kroku symulacji
	      applet.repaint();           //odswiezenei wyswietleanai powierzchni appletu
	}
    public void run(int x){}
    
}
