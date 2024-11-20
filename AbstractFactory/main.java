import java.util.Scanner;
public class main {

	//This application contains minimal error checking on user inputs
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		PizzaStore pizzaStore = null;
		Pizza pizza = null;
		String input = "";
		
		System.out.println("Welcome to MyPizzaApp! To order a pizza please type your order using the format: MyPizzaApp <franchise> <pizzaKind>. Type \"exit\" to quit the program.");
		while(true) {
			input = sc.nextLine();
			if(input.equals("exit")) break;
			String[] inputs = input.split(" ");
			while(inputs.length != 3) {
				System.out.println("Invalid Input. Try Again");
				input = sc.nextLine();
				inputs = input.split(" ");
			}
			if(inputs[1].substring(1, inputs[1].length()-1).equals("NYPizzaStore")) {
				pizzaStore = new NYPizzaStore();
			}else if(inputs[1].substring(1, inputs[1].length()-1).equals("ChicagoPizzaStore")) {
				pizzaStore = new ChicagoPizzaStore();
			}else {
				System.out.println("Incorrect franchise.");
			}
			if(pizzaStore == null) {
				continue;
			}else if(inputs[2].substring(1, inputs[2].length()-1).equals("cheese")) {
				pizza = pizzaStore.orderPizza("cheese");
			}else if(inputs[2].substring(1, inputs[2].length()-1).equals("veggie")) {
				pizza = pizzaStore.orderPizza("veggie");
			}else if(inputs[2].substring(1, inputs[2].length()-1).equals("clam")) {
				pizza = pizzaStore.orderPizza("clam");
			}else if(inputs[2].substring(1, inputs[2].length()-1).equals("pepperoni")) {
				pizza = pizzaStore.orderPizza("pepperoni");
			}else {
				System.out.println("Incorrect type of Pizza");
			}
			System.out.print(pizza.toString());
		}
		
		System.out.println("App closed");
	}

}
