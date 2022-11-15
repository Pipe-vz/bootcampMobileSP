package challenge1;

import java.util.Arrays;
import java.util.Scanner;

public class Challenge1 {
	
	public int[] numbersToShare = null;
	Scanner sc = new Scanner(System.in);
	
	//Method to give ten random numbers where the first two numbers depend on user input. 
	public void tenNumbers() {
		
		//initialize the variable to store the array and the method for storing user input
		int[] numbers = null;
		
		System.out.println("Type 'TipoA' or 'TipoB' to generate an array starting at 5,4 or 0,8 respectively: ");
		String input = sc.nextLine();
		input = input.toLowerCase().replaceAll(" ", "").replaceAll("'", "");
//		System.out.println(input);

		
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
			numbersToShare=numbers;
		}
		//if the values entered do not match, it prints a message and executes the method again.
		else {
			System.out.println("Please check the entered values and try again.");
			tenNumbers();
		}
	}
			
		

	
	
	
	
	
	public void orderNumbers() {
		
		//initialize the variable to store the array and user input
		
		int[] numbersToOrder;
		numbersToOrder = new int[10];
		String selection = "";
		
		System.out.println("\nNow we gonna sort some numbers");
		
		//Asks if the user wants to use the same array or to create a new one
		System.out.println("\nType 'Yes' to use the numbers generated in the past exercise or\n"
				+ "type 'No' to select different numbers :");
		
		selection = sc.nextLine();
        System.out.println(selection);
		selection = selection.toLowerCase().replaceAll(" ","").replaceAll("'", "");		
		
		if(selection.matches("yes") || selection.matches("y")) {
			numbersToOrder=numbersToShare;
			
		//If the user's choice is to create a new array, it asks the number for each position in the array.
		}else {
			System.out.println(" type the number that corresponds to each position in the ten-position array");
			for (int i=0;i<numbersToOrder.length;i++) {
				System.out.print(+i+1+"). Enter the number: ");  
				int a= sc.nextInt();
				sc.nextLine();
				numbersToOrder[i]=a;
			}
		}
		
		//print the user's selection of the array to sort
		System.out.println("The array of numbers to sort is: \n"
				+ Arrays.toString(numbersToOrder)+"\n");
		
		//Requests the order in which the user wants to sort
		System.out.println("Type 'Asc' to sort the numbers from the lowest to the highest value or\n"
				+ "Type 'Desc' to sort the number from the highest to the lowest:");
		
		String outputOrder=sc.nextLine();
		outputOrder = outputOrder.toLowerCase().replaceAll(" ","").replaceAll("'", "");
		
		
		if(outputOrder.matches("asc") || outputOrder.matches("desc")) {
			//uses one variable to be compared, one variable to traverse the array to compare,
			//and one temporary variable to be used for changing the position of numbers
			if(outputOrder.matches("asc")){
				for(int i=0;i<numbersToOrder.length;i++) {
					for(int j=i+1;j<numbersToOrder.length;j++) {
						if(numbersToOrder[i]>numbersToOrder[j]) {
							int temp=numbersToOrder[i];
							numbersToOrder[i]=numbersToOrder[j];
							numbersToOrder[j]=temp;
						}
					}
				}
				System.out.print("The numbers ordered from Lowest to Highest are: \n"+numbersToOrder[0]);
				for (int i=1;i<numbersToOrder.length;i++) {
					System.out.print(","+numbersToOrder[i]);
				}
			}else {
				for(int i=0;i<numbersToOrder.length;i++) {
					for(int j=i+1;j<numbersToOrder.length;j++) {
						if(numbersToOrder[i]<numbersToOrder[j]) {
							int temp=numbersToOrder[i];
							numbersToOrder[i]=numbersToOrder[j];
							numbersToOrder[j]=temp;
						}
					}
				}
				System.out.print("the numbers ordered from Highest to Lowest are:\n" + numbersToOrder[0]);
				for (int i=1;i<numbersToOrder.length;i++) {
					System.out.print(","+numbersToOrder[i]);
				}
			}
		}else {
			System.out.println("Please check the entered values and try again");
			orderNumbers();
		}
		
		
		
	}
	//Run the app and methods.
	public static void main(String args[]) {
		Challenge1 p=new Challenge1();
		p.tenNumbers();
		p.orderNumbers();
	}
}
