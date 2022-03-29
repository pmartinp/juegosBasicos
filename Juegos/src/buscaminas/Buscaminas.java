package buscaminas;

import java.util.*;

public class Buscaminas {
	
	public static void main(String[] args) {
		/* Buscaminas con recompensa. Colocar una minay un tesoro de forma aleatoria en un cuadrantede cuatro
		   filas por cinco columnas. Elusuario debe encontrar el tesoro o morir enel intento.... Proporcionar
		   mensajesadecuados a los eventos.
		*/

		Scanner leer= new Scanner(System.in);
		
		int dificultad, coordenadafila, coordenadacolumna;
		String[][]tablero;
		boolean juegoenprogreso=true, comprobante;
		
		
		
		
		System.out.println("Vamos a jugar al buscaminas. Habrá una mina y un tesoro, encuentralo o muere en el intento");
		System.out.println("");
		System.out.println("Seleccione la dificultad: 1 facil, 2 medio, 3 dificil");
		dificultad=leer.nextInt();
		
		if(dificultad==1 || dificultad==2 || dificultad==3) {
			comprobante=true;
		}
		else {
			comprobante=false;
		}
		
		while(comprobante==false) {
			System.out.println("Por favor, introduza un valor de la dificultad correcto (1, 2 o 3)");
			dificultad=leer.nextInt();
			if(dificultad==1 || dificultad==2 || dificultad==3) {
				comprobante=true;
			}
		}
		
		tablero=crearTablero(dificultad);
		
		mostrarTablero(tablero);
		
		int filatesoro=(int)(Math.random()*tablero.length);
		int columnatesoro=(int)(Math.random()*tablero[0].length);
		int filabomba=(int)(Math.random()*tablero.length);
		int columnabomba=(int)(Math.random()*tablero[0].length);
		
		if(filabomba+columnabomba==filatesoro+columnatesoro) {
			filabomba=(int)Math.random()*tablero.length;
			columnabomba=(int)Math.random()*tablero.length;
		}
		
		//System.out.println("La bomba está:"+ filabomba+""+ columnabomba);
		//System.out.println("El tesoro está:"+ filatesoro+""+ columnatesoro);
		
		while(juegoenprogreso==true) {
			System.out.println("Elige una coordenada");
			
			System.out.println("Fila:");
			coordenadafila=leer.nextInt()-1;
			while(coordenadafila<0 || coordenadafila>=tablero.length) {
				System.out.println("Por favor, introduzca un valor de fila correcto");
				coordenadafila=leer.nextInt()-1;
			}
			
			System.out.println("Columna:");
			coordenadacolumna=leer.nextInt()-1;
			while(coordenadacolumna<0 || coordenadacolumna>=tablero[0].length) {
				System.out.println("Por favor, introduzca un valor de columna correcto");
				coordenadacolumna=leer.nextInt()-1;
			}
			
			
			
			if(coordenadafila+coordenadacolumna==filatesoro+columnatesoro) {
				System.out.println("¡¡¡HAS GANADO!!! Encontraste el tesoro");
				juegoenprogreso=false;
			}
			else if(coordenadafila+coordenadacolumna==filabomba+columnabomba) {
				System.out.println("¡¡¡HAS PERDIDO!!! La bomba explotó");
				juegoenprogreso=false;
			}
			else {
				tablero=actualizarTablero(coordenadafila, coordenadacolumna, tablero);
				mostrarTablero(tablero);
				
				
			}
		}
		
	}
	
	public static String[][] crearTablero(int n) {
		int filas=0, columnas=0;
		if(n==1) {
			filas=4;
			columnas=5;
		}
		else if(n==2) {
			filas=8;
			columnas=10;
		}
		else if(n==3) {
			filas=12;
			columnas=15;
		}
		String[][]tablero=new String[filas][columnas];
		for(int i=0; i<tablero.length; i++) {
			for(int j=0; j<tablero[i].length; j++) {
				tablero[i][j]="*";
			}
		}
		return tablero;
	}
	
	public static void mostrarTablero(String[][] r) {
		for(int i=0; i<r.length; i++) {
			for(int j=0; j<r[i].length; j++) {
				System.out.print(r[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public static String[][] actualizarTablero(int fila,int columna, String[][]campo) {
		campo[fila][columna]="O";
		return campo;
	}

}
