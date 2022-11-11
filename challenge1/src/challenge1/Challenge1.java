package challenge1;

import java.util.Scanner;

public class Challenge1 {
	
	String tenNumbers() {
		int[] numbers = {0,0,0,0,0,0,0,0,0,0};
		System.out.println("ingrese 'TipoA' o 'TipoB' para generar la cadena de texto:");
		
		try (Scanner sc = new Scanner(System.in)) {
			String input=sc.next();
			input.toLowerCase();
			
			if(input=="tipoa" || input=="tipob") {
				if(input=="tipoa"){
					numbers[0]=5;
					numbers[1]=4;
				}else{
					numbers[0]=0;
					numbers[1]=8;
				}
			}else {
				System.out.println("Verifique los valores ingresados e intente nuevamente!");
				tenNumbers();
			}
		}finally {
			for (int i=2; i<10;i++){
				numbers[i]=(int)(Math.random()*10);
				}
		}		
	return numbers.toString();
	}
}
