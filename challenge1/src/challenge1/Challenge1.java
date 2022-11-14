package challenge1;

import java.util.Arrays;
import java.util.Scanner;

public class Challenge1 {
	
	public static void tenNumbers() {
		int[] numbers = {0,0,0,0,0,0,0,0,0,0};
		System.out.println("ingrese 'TipoA' o 'TipoB' para generar la cadena de texto:");
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		input = input.toLowerCase().trim();
		System.out.println(input);
		
		if(input.matches("tipoa") || input.matches("tipob")) {
			if(input.matches("tipoa")){
				numbers[0]=5;
				numbers[1]=4;
			}else{
				numbers[0]=0;
				numbers[1]=8;
			}
		}
		else {
			System.out.println("Verifique los valores ingresados e intente nuevamente!");
			tenNumbers();
		}
		for (int i=2; i<10;i++){
			numbers[i]=(int)(Math.random()*10);
			}
					
		 System.out.println(Arrays.toString(numbers));
	}
	
	public static void orderNumbers() {
		int[] numbersToOrder;
		numbersToOrder = new int[10];
		
		
		Scanner sc = new Scanner(System.in);
		
		for (int i=0;i<numbersToOrder.length;i++) {
			System.out.print("\n"+i+"). Enter the number: ");  
			int a= sc.nextInt();
			numbersToOrder[i]=a;
		}
		
		System.out.println("Escriba 'Asc' para organizar los numeros de menor a mayor o\n"
				+ "Escriba 'Desc' para organizar los numeros de mayor a menor: ");
		
		
		String outputOrder=sc.nextLine();
		outputOrder.toLowerCase();
		
		if(outputOrder=="asc") {
			for(int i=0;i<numbersToOrder.length;i++) {
				for(int j=i+1;j<numbersToOrder.length;j++) {
					if(numbersToOrder[i]>numbersToOrder[j]) {
						int temp=numbersToOrder[i];
						numbersToOrder[i]=numbersToOrder[j];
						numbersToOrder[j]=temp;
					}
				}
			}
			System.out.print("los numeros ordenados de Menor a Mayor son: \n"+numbersToOrder[0]);
			for (int i=1;i<numbersToOrder.length;i++) {
				System.out.print(","+numbersToOrder[i]);
			}
		}else if(outputOrder=="desc") {
			for(int i=0;i<numbersToOrder.length;i++) {
				for(int j=i+1;j<numbersToOrder.length;j++) {
					if(numbersToOrder[i]<numbersToOrder[j]) {
						int temp=numbersToOrder[i];
						numbersToOrder[i]=numbersToOrder[j];
						numbersToOrder[j]=temp;
					}
				}
			}
			System.out.print("los numeros ordenados de Mayor a Menor son: \n"+numbersToOrder[0]);
			for (int i=1;i<numbersToOrder.length;i++) {
				System.out.print(","+numbersToOrder[i]);
			}
		}
		else {
			System.out.println("Verifique el valor ingresado e intente nuevamente");
			orderNumbers();
		}
	}
	public static void main(String args[]) {
		tenNumbers();
//		orderNumbers();
	}
}
