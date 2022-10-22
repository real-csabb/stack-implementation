
import java.util.Scanner;

/**
 * This ArrayPalindrome program uses stack implementations to test whether two strings of characters are the
 * reverse of one each other. This reversed nature of the strings suggests using stacks to try to determine 
 * if the given string is a palindrome.
 * 
 * My program accomplishes this by pushing the given string onto a stack1 and stack2 object initialized as 
 * new ArrayStack<Character> objects in the ArrayPalindrome class constructor. My program then pushes the 
 * popped values of stack1 onto the reverse stack object (likewise initialized in the constructor) and
 * compares these reversed values to the second stack stack2. If none of the characters in these stacks
 * are different from one another, then they are palindromes. 
 * 
 * The main function of my program then tests the .isPalindrome method eight times and returns the appropriate
 * values, such as true for "x" and for an empty "" string and false for "egg". The .clear method removes any
 * leftover values in the stack1, stack2, and reverse stack objects so that they can be used again in future
 * .isPalindrome method calls.
 * 
 * @author Chris Sabb
 * @version 2.0
 * @since 2022-09-11
 */

public class ArrayPalindrome {
	
	ArrayStack<Character> stack1;
	ArrayStack<Character> stack2;
	ArrayStack<Character> reverse;
	
	/**
	 * This is the constructor method for the ArrayPalindrome class. Before it, the stacks stack1, stack2,
	 * and reverse are initialized and within the constructor are giving ArrayStack<Character> values.
	 * These stack objects will be utilized later in the .isPalindrome, .clear, and main methods.
	 * @param args Unused
	 * @return Nothing
	 */
	public ArrayPalindrome() {
		stack1 = new ArrayStack<Character>();
		stack2 = new ArrayStack<Character>();
		reverse = new ArrayStack<Character>();
	}
	
	/**
	 * This is the main method of ArrayPalindrome. It calls the method .isPalindrome on eight string array
	 * objects and checks them for palindromeness. It then prints out whether or not the string array object
	 * is a palindrome or not. For example, for racecar and for otto, both are palindromes, therefore the
	 * .isPalindrome method will return true. It will not however return true for georgewashington because
	 * it is not equal to notgnihsawegroeg and is therefore not a palindrome.
	 * @param args Unused. This function prints the palindromeness of an string object passed to .isPalindrome.
	 * @return Nothing. This function prints out the return values of its .isPalindrome method calls.
	 */
	public static void main(String[] args) {
		ArrayPalindrome isPalindrome = new ArrayPalindrome();
		
		String[] candidates = {"racecar", "egg", "otto", "tacocat", "georgewashington", " ", "", "x", "go", "taco cat", "  ", "hola", "stressed desserts", "The Java Programming Language",
				"Stressed Desserts"};
		for (String str : candidates) {
			System.out.println("\n" + str + " Palindromeness: " + isPalindrome.isPalindrome(str));
		}

		// Scanner scan = new Scanner (System.in);
		// while (true) {
		//	  System.out.print("Enter \"Ctrl+D\" to end the program. Otherwise, enter a string to check for palindromeness.\n: ");
		//	  System.out.println("\nPalindromeness: " + isPalindrome.isPalindrome(scan.next()) + "\n");
	}
	
	/**
	 * This method is used to examine the characters of a string input parameter one at a time and
	 * pushes them onto the stacks stack1 and stack2. stack1 is then reversed onto the "reverse" stack
	 * and this reverse stack is then compared to stack2 and iterated through. If one of the characters 
	 * doesn't match up with the other stack's characters, then the string input parameter is not a 
	 * palindrome. If the while loop hasn't returned false (ala not a palindrome) by the time it's done 
	 * iterating through the string input parameter, then the parameter is a palindrome and the function
	 * returns true. Following all of this, the function clears all the stacks using the .clear helper method 
	 * so that it can check for more palindromeness.
	 * @param input This incoming string is the string that isPalindrome will check for palindromeness.
	 * @return boolean This returns a boolean value of whether or not the input string is a palindrome.
	 */
	public boolean isPalindrome(String input) {
		this.clear();
		for (char c : input.toCharArray()) {
			stack1.push(c);
			stack2.push(c);
		}
		
		while (!stack1.isEmpty()) {
			reverse.push(stack1.pop());
		}
		
		while (!stack2.isEmpty()) {
			if (! (stack2.pop() ==  reverse.pop())) {
				return false;
			}
		} 
		return true; 
	}
	
	/**
	 * This helper method is used to clear this class' stack objects stack1, stack2, and reverse and remove 
	 * any values within them left over from previous .isPalindrome method calls. It does this by iterating
	 * through each stack and while each stack is not empty, it pops its value from the stack. It does this
	 * for all three stack objects.
	 * @param args Unused
	 * @return Nothing
	 */
	private void clear() {
		while (!stack1.isEmpty()) {
			stack1.pop();
		}
		
		while (!stack2.isEmpty()) {
			stack2.pop();
		}
		
		while (!reverse.isEmpty()) {
			reverse.pop();
		}
	}
}
