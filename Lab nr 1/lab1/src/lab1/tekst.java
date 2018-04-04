package lab1;
import java.util.ArrayList;
import java.util.Random;

public class tekst {
	public static void main(String[] args)
	{
		punkt punkt1 = new punkt();     //stworzenie pierwszego obiektu za pomoca konstruktora domyslenego
		punkt punkt2 = new punkt(24);   //stworzenie drugiego obiektu za pomoca konstruktora z parametrem
		int biegun = -12 ;              //biegun wzgledem ktorego jest obliczany mom. bez. z tw. St. 
		punkt1.opis();                  
		punkt1.momentbez();
		punkt1.steiner(biegun);         //wyznaczenie moment bez. , momentu z tw. Steneiera oraz opisu dla pierwszego obiektu
		System.out.println("");
		punkt2.opis();            
		punkt2.momentbez();
		punkt2.steiner(biegun);          //wyznaczenie moment bez. , momentu z tw. Steneiera oraz opisu dla drugiego obiektu
		System.out.println("");
		System.out.println("Ponowne obliczenie dla punktu 1 po zmianie masy:");
		punkt1.setmasa(54);             // zmiana masy pierwszego obiektu
		punkt1.opis();
		punkt1.momentbez();
		punkt1.steiner(biegun);
		ArrayList<punkt> lista = new ArrayList<punkt>();    //tablica przechowujaca obiekty z klasy punkt
		Random rand = new Random();
		int i=0 ;
		for(int x=i; x<10; x++)                             //petla tworzaca punkty o losowych masach
		{ 
			int rmasa = rand.nextInt(100)+1;
			lista.add(new punkt(rmasa));	
		}
		for (int x=i;x<10;x++)                             //petla wypisujace informacje na temat utworzonych obiektow
		{
			punkt genpunkt = lista.get(x);
			System.out.println("");
			System.out.println("Generowany punkt nr: " + ++i);
			System.out.println("");
			genpunkt.opis();
			genpunkt.momentbez();
			genpunkt.steiner(biegun);
		}
	}

}
