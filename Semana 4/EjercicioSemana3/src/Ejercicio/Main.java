package Ejercicio;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Numeros nums = new Numeros();
		ClsVerificacion v = new ClsVerificacion();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese el primer numero");
		nums.setNum1(scanner.nextInt());
		System.out.println("Ingrese el segundo numero");
		nums.setNum2(scanner.nextInt());
		System.out.println("*****************************************");
		
		System.out.println(v.Verificacion(nums));
		
		

	}

}
