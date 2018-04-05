package lab2;
import java.util.ArrayList;
import java.util.Random;


public class Tekst {
	 public static void main(String[] args) {
		 int steiner = 4;
		 int BrylaId =1;
		 Walec walec1= new Walec(11,2,3);     //tworzenie obiektu klasy pochodnej Walec
		 walec1.opis();
		 walec1.opis(steiner);
		 Kula kula1= new Kula(23,4);           //tworzenie obiektu klasy pochodnej Kula
		 kula1.opis();
		 kula1.opis(steiner);
		 Pret pret1=new Pret(6,7);            //tworzenie obiektu klasy pochodnej Pret
		 pret1.opis();
		 pret1.opis(steiner);
		 ArrayList<Punkt> Bryly= new ArrayList<Punkt>();  //tworzenie tablicy obiektow:
		 Random rand = new Random();
		 for(int i=0;i<10;i++)
		 { int r = rand.nextInt(3)+1;
		 switch (r) {
		 case 1:
			 
				 Bryly.add(new Walec(rand.nextInt(10)+1, rand.nextInt(10)+1, rand.nextInt(10)+1));
				 break;
		 case 2:
			 
				 Bryly.add(new Kula(rand.nextInt(20)+1, rand.nextInt(20)+1));
				 break;
		 case 3:
			 	Bryly.add(new Pret(rand.nextInt(30)+1, rand.nextInt(30)+1));
			 	break;
		 }
		 }
		 for(int i=0;i<10;i++)               //wyswietlenie opisow a takze glownego momentu bezwladnosci oraz mom. bez. z tw. Steinera
		 {
					Punkt genpunkt = Bryly.get(i);
					System.out.println("");
					System.out.println("Generowana bryla nr: " + BrylaId++);
					System.out.println("");
					genpunkt.opis();
					genpunkt.opis(steiner);		
		 }
}}
