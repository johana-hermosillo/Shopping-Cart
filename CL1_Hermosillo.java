/* Johana Hermosillo
 [CS1101] Comprehensive Lab 1
 This work is to be done individually. It is not permitted to.
 share, reproduce, or alter any part of this assignment for any
 purpose. Students are not permitted to share code, upload
 this assignment online in any form, or view/receive/
 modifying code written by anyone else. This assignment is part.
 of an academic course at The University of Texas at El Paso and
 a grade will be assigned for the work produced individually by
 the student.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class CL1_Hermosillo{

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int option = 0;
		String answer = "true";
		String foodName = " ";
		String cart = " ";
		String exit = " ";
		String product = " ";
		float price = 0.0f;
		int totalItems = 0;
		double totalPrice = 0.0;
		int num = 0;
		int user = 0;
		String address = " ";
		int tip = 0;
	//tring validInput = " ";
		String creditCard = " ";
		float tipAmount = 0.0f;
		boolean validInput = false;
		int productItems = 0;
		String clearCart = "false";
		boolean isLengthCorrect = false;

		try{

			File myFile = new File("food.txt");

			

			// while(scanner.hasNextLine()){
			// 	System.out.println(scanner.nextLine());

			// }

			while(option != 5 && option != 4) {

				System.out.println("Welcome to Miners Eats!");
				System.out.println("------------Menu------------");
				System.out.println("Choose an option (1-5):");
				System.out.println("1. Add a food");
				System.out.println("2. View cart");
				System.out.println("3. Clear cart");
				System.out.println("4. Checkout");
				System.out.println("5. Exit");
				System.out.println("----------------------------");

				option = input.nextInt();

				switch(option){
					case 1:
						//Show the menu
						Scanner scanner = new Scanner(myFile);
						while(scanner.hasNextLine()){
							System.out.println(scanner.nextLine());
							//product = scanner.next();
							//price = scanner.nextFloat();

						}

						System.out.println("Please type the food you want to add: ");
							foodName = input.next();
							foodName = foodName.substring(0, 1).toUpperCase() + foodName.substring(1);
							scanner = new Scanner(myFile);
						System.out.println("How many " + foodName + " would you like?");
							productItems = input.nextInt();
							scanner = new Scanner(myFile);
							while(scanner.hasNextLine()){
								product = scanner.next();
								price = scanner.nextFloat();

								System.out.println(product);
								System.out.println(price);
								if(foodName.equals(product)) {
									break;
								}
							}

						if(foodName.equals(product)) {
							System.out.println("------------Cart----------");
							totalItems += productItems;
							System.out.println("Total items in the cart " + totalItems);
							totalPrice += price * productItems;
							System.out.println("Total price: $" + totalPrice);

							System.out.println("---------------------------");
						} else {
							System.out.println("Item not found");
						}
						break;
					case 2:
						System.out.println("------------Cart-----------");
						System.out.println("Number of items:" + totalItems);
						System.out.println("Total: $" + totalPrice);
						System.out.println("----------------------------");
						
						System.out.println("To go back to main menu enter 0");
						num = input.nextInt();
						break;
					case 3:
						System.out.println("Are you sure you would like to clear your cart? (true or false)");
						clearCart = input.next();
						if(clearCart.equals("true")){
							totalItems = 0;
							totalPrice = 0;
							System.out.println("----------------------------");
							System.out.println("Your cart is now empty");
							System.out.println("Number of items: " + totalItems);
							System.out.println("Total: " + totalPrice);
							System.out.println("-----------------------------");
						
							System.out.println("To go back to main menu enter 0");
							num = input.nextInt();
						}

						if(clearCart.equals("false")){
							System.out.println("Cart not changed. Going back to the menu");
						}
						break;
					case 4:
						System.out.println("Please choose an option below: (1 or 2)");
						System.out.println("1. Pickup        2. Delivery");
						user = input.nextInt();
						if(user == 1) {
							System.out.println("-----------------------------");
							System.out.println("Order Information");
							System.out.println("Number of items: " + totalItems);
							totalPrice = totalPrice * 1.0725;
							System.out.println("Total: $" + totalPrice);
							System.out.println("Tax is already included on all totals!");

							while(!validInput) {
								System.out.println("Please enter your 16 digit credit card number: ");
								if(input.hasNextLong()){
									creditCard = input.next();	
									if(creditCard.length() == 16){
										isLengthCorrect = true;
										break;
									}
								}
								
								
								
							}

							System.out.println("Success! Thank you for shopping with UTEP Eats!");
							System.out.println("------------Receipt-----------");
							System.out.println("Number of items: " + totalItems);
							System.out.println("Total: $" + totalPrice);
							System.out.println("------------Receipt-----------");
							System.out.println("Exiting program");
						}
						if (user==2){
							System.out.println("There is a $5 fee.");
							totalPrice += 5;
							System.out.println("Please enter your address");
							//int addressNumber = Integer.parseInt(address);
							//Integer numAddress = Integer.valueOf(address);
							address = input.next();
							
							System.out.println("Would you like to add a tip (1 or 2)?");
							System.out.println("1. Yes        2. No");
							tip = input.nextInt();
							if(tip == 1) {
								System.out.println("----------------------------");
								System.out.print("Enter tip % amount: ");
								tipAmount = input.nextFloat();
								System.out.println("Thank you for helping us improve the service!");
								System.out.println("Order information");
								System.out.println("Number of items: " + totalItems);
								System.out.println("Total: $" + (totalPrice + (totalPrice / tipAmount)));
								while(!validInput) {
									System.out.println("Please enter your 16 digit credit card number: ");
									if(input.hasNextLong()){
										creditCard = input.next();
										if(creditCard.length() == 16){
											isLengthCorrect = true;
											break;
										}
									}

								}
							}
								System.out.println("----------------------------");
								System.out.println("Success! Thank you for shopping with UTEP Eats!");
								System.out.println("-------------Receipt----------");
								System.out.println("Number of items: " + totalItems);
								System.out.println("Total: $" + (totalPrice + (totalPrice / tipAmount)));
								System.out.println("-------------Receipt--------");
								System.out.println("Exiting program");
						}
							if(tip == 2) {
								System.out.println("Order information");
								System.out.println("Number of items: " + totalItems);
								System.out.println("Total: $" + totalPrice);
								while(!validInput) {
									System.out.println("Please enter your 16 digit credit card number: ");
										creditCard = input.next();
										if(creditCard.length() == 16){
											isLengthCorrect = true;
										}
										boolean allNum = true;
											for(int i = 0; i < answer.length(); i++){
												if('0' <= creditCard.charAt(i) && creditCard.charAt(i) <= '9'){
													allNum = false;
												}
											}
											
										
										System.out.println("Success! Thank you for shopping with UTEP Eats!");
										System.out.println("-------------Receipt-----------");
										System.out.println("Number of items: " + totalItems);
										System.out.println("Total: $" + totalPrice);
										System.out.println("-------------Receipt-----------");
										System.out.println("Exiting program");
										break;
								}
							}		
							
						break;

					case 5:
						while(exit.equals("true")) {
							System.out.println("Are you sure you want to exit (true or false)?");
							exit = input.next();
							break;
						}
					default:
						System.out.println("Cart abandoned. Goodbye!");
						System.out.println("Ending program.");
						break;

				}

			} 


		}catch(FileNotFoundException e){
			System.out.println("an error occurred reading the file");
		}
		
	}
}


