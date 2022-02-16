package Ejercicio;

public class ClsVerificacion {
	
	public String Verificacion(Numeros num) {
		
		
		if (num.getNum1() < 0 && num.getNum2() < 0) {
			
			return "El numero "+num.getNum1()+" y "+num.getNum2()+" son NEGATIVOS";
		}
		else if(num.getNum1() > 0 && num.getNum2() < 0) {
			
			return "El numero "+num.getNum1()+" es POSITIVO y el "+num.getNum2()+" es NEGATIVO";
		}
		else if(num.getNum1() < 0 && num.getNum2() > 0) {
			
			return "El numero "+num.getNum1()+" es NEGATIVO y el "+num.getNum2()+" es POSITIVO";
		}
		else {
			
			return "El numero "+num.getNum1()+" y "+num.getNum2()+" son POSITIVOS";
		}
		
	}
	

}
