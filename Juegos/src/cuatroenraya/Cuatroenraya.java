package cuatroenraya;

import java.util.*;

import buscaminas.Buscaminas;

public class Cuatroenraya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leer=new Scanner (System.in);
		boolean juegoenprogreso=true;
		
		System.out.println("Bienvenido al 4 en raya version de tieso");
		
		String[][]tablero=crearTablero();
		Buscaminas.mostrarTablero(tablero);
		
		while(juegoenprogreso) {
			System.out.println("Turno jugador 1");
			int jugada1=leer.nextInt();
			
			for(int i=tablero.length-1; i>0; i--) {
					if(tablero[i][jugada1].equals("  ")) {
						tablero[i][jugada1]="O ";
						break;
					}
			}
			
			Buscaminas.mostrarTablero(tablero);
			
			for(int i=0; i<tablero.length; i++) {
				for(int j=0; j<tablero[i].length; j++) {
					if(tablero[i][j].equals("O ") && tablero[i][j+1].equals("O ") && tablero[i][j+2].equals("O ") && tablero[i][j+3].equals("O ")) {
						System.out.println("HA GANADO EL JUGADOR 1");
						juegoenprogreso=false;
					}
					else if(tablero[i][j].equals("O ") && tablero[i+1][j+1].equals("O ") && tablero[i+2][j+2].equals("O ") && tablero[i+3][j+3].equals("O ")) {
						System.out.println("HA GANADO EL JUGADOR 1");
						juegoenprogreso=false;
					}
					else if(tablero[i][j].equals("O ") && tablero[i-1][j+1].equals("O ") && tablero[i-2][j+2].equals("O ") && tablero[i-3][j+3].equals("O ")) {
						System.out.println("HA GANADO EL JUGADOR 1");
						juegoenprogreso=false;
					}
					else if(tablero[i][j].equals("O ") && tablero[i+1][j].equals("O ") && tablero[i+2][j].equals("O ") && tablero[i+3][j].equals("O ")) {
						System.out.println("HA GANADO EL JUGADOR 1");
						juegoenprogreso=false;
					}
				}
			}
			
			
			System.out.println("Turno jugador 2");
			int jugada2=leer.nextInt();
			
			for(int i=tablero.length-1; i>0; i--) {
				if(tablero[i][jugada2].equals("  ")) {
					tablero[i][jugada2]="X ";
					break;
				}
			}
		
			Buscaminas.mostrarTablero(tablero);
		
			for(int i=0; i<tablero.length; i++) {
				for(int j=0; j<tablero[i].length; j++) {
					if(tablero[i][j].equals("X ") && tablero[i][j+1].equals("X ") && tablero[i][j+2].equals("X ") && tablero[i][j+3].equals("X ")) {
						System.out.println("HA GANADO EL JUGADOR 2");
						juegoenprogreso=false;
					}
					else if(tablero[i][j].equals("X ") && tablero[i+1][j+1].equals("X ") && tablero[i+2][j+2].equals("X ") && tablero[i+3][j+3].equals("X ")) {
						System.out.println("HA GANADO EL JUGADOR 2");
						juegoenprogreso=false;
					}
					else if(tablero[i][j].equals("X ") && tablero[i+1][j].equals("X ") && tablero[i+2][j].equals("X ") && tablero[i+3][j].equals("X ")) {
						System.out.println("HA GANADO EL JUGADOR 2");
						juegoenprogreso=false;
					}
				}
			}
			
			
		}
	}
	public static String[][] crearTablero(){
		String[][]tablero=new String[7][8];
		for(int i=0; i<tablero.length; i++) {
			for(int j=0; j<tablero[i].length; j++) {
				if(j==0 || j==tablero[i].length-1) {
					tablero[i][j]="|";
				}
				else if(i==tablero.length-1) {
					tablero[i][j]="_ ";
				}
				else {
					tablero[i][j]="  ";
				}
			}
		}
		return tablero;
	}

}
