import java.util.Scanner;

public class MondayMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SystemDisplay.headerDisplay();
		
		int numberOfCandidates = 0;
		
		boolean isErrorPresent = true;
		while(isErrorPresent) {
			try {
				System.out.print("How many candidates are you entering for? ");
				numberOfCandidates = Integer.parseInt(scanner.nextLine());
				isErrorPresent = false;
			}catch(NumberFormatException e) {
				System.out.println("\t-----INVALID ENTRY! Use numerals.-----\n");
			}
		}		
		
		SystemDisplay.input(numberOfCandidates);
		
	}

}
