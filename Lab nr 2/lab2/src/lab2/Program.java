package lab2;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	public static void Menu() {
		System.out.println("Witaj w kreatorze bryl.");
		System.out.println("");
		System.out.println("1.Stworz Walec");
		System.out.println("2.Stworz Pret");
		System.out.println("3.Stworz Kule");
		System.out.println("4.Pokaz stworzone bryly");
		System.out.println("5.Wyjdz");
	}
	public static void main(String[] args)
	{ int i=0;
	  int x=0;
	  int prom, wys,masa,steiner;
	  ArrayList<Punkt> Bryly= new ArrayList<Punkt>();             //tworzenie tablicy obiektow:
      while(i<1) {
	  Menu();
	  Scanner odczyt = new Scanner(System.in);                   //tworzenie klasy sluzacej do odczytu danych z klawiatury
	  Punkt genpunkt ;
	  int a = odczyt.nextInt();
	  switch(a)
	  { case 1:             //tworzenie walca
		  System.out.println("Prosze podac mase:");
		  masa=odczyt.nextInt();
		  System.out.println("Prosze podac wysokosc:");
		  wys=odczyt.nextInt();
		  System.out.println("Prosze podac promien:");
		  prom=odczyt.nextInt();
		  System.out.println("Prosze podac odleglosc nowej osi:");
		  steiner=odczyt.nextInt();
		  Bryly.add(new Walec(masa,wys,prom));
		  genpunkt = Bryly.get(x);
		  genpunkt.opis();
		  genpunkt.opis(steiner);
		  x++;
		  break;
		  
	  	case 2:            //tworzenie preta
	  		System.out.println("Prosze podac mase:");
			masa=odczyt.nextInt();
			System.out.println("Prosze podac dlugosc:");
		    wys=odczyt.nextInt();
		    System.out.println("Prosze podac odleglosc nowej osi:");
			steiner=odczyt.nextInt();
		    Bryly.add(new Pret(masa,wys));
		    genpunkt = Bryly.get(x);
		    genpunkt.opis();
		    genpunkt.opis(steiner);
		    x++;
		  break;
		  
	  	case 3:          //tworzenie kuli
	  		System.out.println("Prosze podac mase:");
			masa=odczyt.nextInt();
			System.out.println("Prosze podac promien:");
			prom=odczyt.nextInt();
			System.out.println("Prosze podac odleglosc nowej osi:");
			steiner=odczyt.nextInt();
		    Bryly.add(new Kula(masa,prom)); 
		    genpunkt = Bryly.get(x);
		    genpunkt.opis();
		    genpunkt.opis(steiner);
		    x++;
		 break;
	  	
	  	case 4:
	  		for(int y=0;y<x;y++)               //wyswietlenie zapisanych Bryl
			 {
						genpunkt= Bryly.get(y);
						genpunkt.opis();	
			 }
					
			 
			 break;
			 
	  	case 5:                               //zamkniecie programu
		     i++;
			 break;
	  
	  }
      }
	}
}
