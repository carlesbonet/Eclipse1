import java.util.Scanner;
import java.io.*;
import java.lang.String;

public class Principal {

	static char Lab[][]={{'+','#','+','#','S','+','#','#',},
				  		 {'+','#','+','@','+','+','+','+',},
				         {'+','+','+','#','#','#','+','#',},
				         {'+','@','?','+','+','#','+','+',},
				         {'+','#','+','#','+','+','+','@',}};
	static char trep[][];
	static int fj, cj;
	static int nfj, ncj; 
	static boolean finalJoc = false;
	static int vides=3;
	static boolean piq=false;
	public static void main(String args[])
	{
		Principal joc = new Principal();
		joc.bucleJoc();
		//comentem el bucle principal
		
	}	
	public void bucleJoc(){
		trep=new char[5][8];
		nfj=0; ncj=0;
		fj=1; cj=5;
		
		iniciaTrepitjat();
		while (!(finalJoc) && (vides>0))
		{
			imprimeixTrepitjat();
			String mov=demanaMoviment();
			realitzaMoviment(mov);
			
		}
	}
	
	public void iniciaTrepitjat()
	{
		int fila,columna;
		fila=0;columna=0;
		for(fila=0;fila<5;fila++)
		{
			for(columna=0;columna<8;columna++)
			{
				trep[fila][columna]=' ';
			}
			System.out.println();
		}
	}
	public void imprimeixTrepitjat()
	{
		int fila,columna;
		fila=0;columna=0;
		for(fila=0;fila<5;fila++)
		{
			for(columna=0;columna<8;columna++)
			{
				System.out.print(trep[fila][columna]);
				if ((fila==fj) && (columna==cj)) System.out.print('*');
			
			}
			System.out.println();
		}
	}
	public String demanaMoviment()
	{	
		System.out.println("Que vols fer?: ");
		@SuppressWarnings("resource")
		Scanner llegir=new Scanner(System.in);
		String verb="";
		verb=llegir.next();
		llegir.nextLine();
		return verb;
		
	}
	private void realitzaMoviment(String Mov)
	{	boolean endavant=true;
		String moviment=Mov.toUpperCase();
		switch (moviment)
		{
			case "AMUNT":	nfj=fj-1;
							ncj=cj;
							break;
			case "AVALL":   nfj=fj+1;
							ncj=cj;
							break;
			case "ESQUERRE":
							nfj=fj;
							ncj=cj-1;
							break;
			case "DRETA":   nfj=fj;
							ncj=cj+1;
							break;
			default:        endavant=false;
			
			
							break;
							
		}
		if (endavant)
		{
			ferEfectiuMov();
		}
		else
		{System.out.println("El moviment indicat no es pot realitzar!");}
		
	}
	
	private void ferEfectiuMov()
	{	switch(Lab[nfj][ncj])
		{	
			case '+': trep[nfj][ncj]='+';
					  fj=nfj;cj=ncj;
					  break;
			case '#': if (piq) 
					  {
						System.out.println("Hi ha un mur però tens la super piqueta!!!!");
						trep[nfj][ncj]='+';
						Lab[fj][cj]='+';
						fj=nfj;cj=ncj;
					  }
					  else
					  {
						  System.out.println("Hi ha un mur i no pots passar!!");
						  trep[nfj][ncj]='#';
					  }
			   		  break;
			case '@': System.out.println("Ha trepitjat una bomba!!");
					  System.out.println("Et queden: " + vides + " vides!");
					  trep[nfj][ncj]='+';
					  fj=nfj;cj=ncj;
					  break;	
			case '?': System.out.println("Has trobat una piqueta!!");
					  piq=true;
					  fj=nfj;cj=ncj;
					  break;
			case 'S': System.out.println("Has trobat la sortida i encara estàs viu!!,felicitats!!");
					  finalJoc=true;
					  break;
	   		 
	
		}
		
	}
}
