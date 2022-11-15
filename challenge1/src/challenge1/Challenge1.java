package challenge1;

import java.util.Arrays;
import java.util.Scanner;

public class Challenge1 {
	
	//Method to give ten random numbers where the first two numbers depend on user input. 
	public static void tenNumbers() {
		
		//initialize the variable to store the array and the method for storing user input
		int[] numbers = null;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter 'TipoA' or 'TipoB' to generate the text string: ");
			

			String input = sc.nextLine();
			input = input.toLowerCase().replaceAll(" ", "");
//			System.out.println(input);
			
			//check if the input matches the required parameters and generate the first two numbers
			if(input.matches("tipoa") || input.matches("tipob")) {
				numbers = new int[10];
				if(input.matches("tipoa")){
					numbers[0]=5;
					numbers[1]=4;
				}else{
					numbers[0]=0;
					numbers[1]=8;
				}
				//build the remaining random numbers
				for (int i=2; i<10;i++){
					numbers[i]=(int)(Math.random()*10);
				}
				//print the array as string
				System.out.println(Arrays.toString(numbers));
			}
			//if the values entered do not match, it prints a message and executes the method again.
			else {
				System.out.println("Please check the entered values and try again.");
				tenNumbers();
			}
		}	 
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
