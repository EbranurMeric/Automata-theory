
import java.util.Scanner;

class ODEV {

	public static boolean simulate(String input) {
		String currentState = "q0";
		for (char symbol : input.toCharArray()) {
			System.out.println("Mevcut Durum: " + currentState + ", Okunan Sembol: " + symbol);

			if (currentState.equals("q0")) {
				if (symbol == 'b') {
					currentState = "q1";
				} else if (symbol == 'a') {
					currentState = "q3";
				} else {
					throw new IllegalArgumentException("Geçersiz Sembol: " + symbol);
				}
			} else if (currentState.equals("q1")) {
				if (symbol == 'b') {
					currentState = "q2";
				} else if (symbol == 'a') {
					currentState = "q4";
				} else {
					throw new IllegalArgumentException("Geçersiz Sembol: " + symbol);
				}
			} else if (currentState.equals("q2")) {
				if (symbol == 'b') {
					currentState = "q2";
				} else if (symbol == 'a') {
					currentState = "q5";
				} else {
					throw new IllegalArgumentException("Geçersiz Sembol: " + symbol);
				}
			} else if (currentState.equals("q3")) {
				if (symbol == 'b') {
					currentState = "q4";
				} else if (symbol == 'a') {
					currentState = "q6";
				} else {
					throw new IllegalArgumentException("Geçersiz Sembol: " + symbol);
				}
			} else if (currentState.equals("q4")) {
				if (symbol == 'a') {
					currentState = "q7";
				} else if (symbol == 'b') {
					currentState = "q5";
				} else {
					throw new IllegalArgumentException("Geçersiz Sembol: " + symbol);
				}
			} else if (currentState.equals("q5")) {
				if (symbol == 'b') {
					currentState = "q5";
				} else if (symbol == 'a') {
					currentState = "q8";
				} else {
					throw new IllegalArgumentException("Geçersiz Sembol: " + symbol);
				}
			} else if (currentState.equals("q6")) {
				if (symbol == 'a') {
					currentState = "q6";
				} else if (symbol == 'b') {
					currentState = "q7";
				} else {
					throw new IllegalArgumentException("Geçersiz Sembol: " + symbol);
				}
			} else if (currentState.equals("q7")) {
				if (symbol == 'a') {
					currentState = "q7";
				} else if (symbol == 'b') {
					currentState = "q8";
				} else {
					throw new IllegalArgumentException("Geçersiz Sembol: " + symbol);
				}
			} else if (currentState.equals("q8")) {
				if (symbol == 'a' || symbol == 'b') {
					currentState = "q8";
				} else {
					throw new IllegalArgumentException("Geçersiz Sembol: " + symbol);
				}
			}
		}

		System.out.println("Bitiş Durumu: " + currentState);
		return currentState.equals("q8");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Bir dizgi giriniz veya bitirmek için 'bitir' yazınız: ");
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("bitir")) {
				System.out.println("Simülasyon bitti...");
				break;
			}

			try {
				boolean accepted = simulate(input);
				if (accepted) {
					System.out.println("Bu dizgi DFA'yı kabul eder.");
				} else {
					System.out.println("Bu dizgi DFA'yı kabul etmez.");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		scanner.close();
	}
}
