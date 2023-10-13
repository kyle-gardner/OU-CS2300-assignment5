// 1. 4 diff conversion
// 2. continue accepting input until exit
// 3. README on how to use
// 4. jar file

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Converter converter = new Converter();

		while(!"exit".equals(converter.input)) {
			System.out.println("Choose your conversion\n1. kg -> lbs\n2. mi -> km\n3. grams -> ounces\n4. mm -> in\n");			
			converter.waitForInput();

			converter.giveOutput();
		}	
	}	
}

class Converter {
	Scanner scanner;
	public String input;
	float inputNum;
	float outputNum;

	Operation op;

	private enum Operation {
		KG_LBS,
		MI_KM,
		G_OZ,
		MM_IN,
		INVALID,
	}

	public Converter() {
		scanner = new Scanner(System.in);
	}
	public void waitForInput() {
		String unSplit = scanner.nextLine();
		String split[] = unSplit.split("\\s+");

		if (split.length != 2) {
			System.out.println("1 or more than 2 parameters were entered, restarting.\n");
			op = Operation.INVALID;
		} else {
			String match = split[0];
			inputNum = Float.parseFloat(split[1]);

			switch (match) {
				case "1":
					op = Operation.KG_LBS;
					break;
				case "2":
					op = Operation.MI_KM;
					break;
				case "3":
					op = Operation.G_OZ;
					break;
				case "4":
					op = Operation.MM_IN;
					break;
				default:
					System.out.println(match + " is not a valid option, restarting\n");
					op = Operation.INVALID;
					break;
			}
		}

	}
	public void giveOutput() {
		convert(op, inputNum);
		String tempIn = Float.toString(inputNum);
		String tempOut = Float.toString(outputNum);
		switch (op) {
			case KG_LBS:
				System.out.println(tempIn + " kg -> " + tempOut + " lbs\n");
				break;
			case MI_KM:
				System.out.println(tempIn + " mi -> " + tempOut + " km\n");
				break;
			case G_OZ:
				System.out.println(tempIn + " grams -> " + tempOut + " ounces\n");
				break;
			case MM_IN:
				System.out.println(tempIn + " mm -> " + tempOut + " in\n");
				break;
			case INVALID: break;
		}

	}
	
	private void convert(Operation op, float inputNum) {
		switch (op) {
			case KG_LBS:
				outputNum = inputNum * 2.2046226F;
				break;
			case MI_KM:
				outputNum = inputNum * 1.60934F;
				break;
			case G_OZ:
				outputNum = inputNum / 28.35F;
				break;
			case MM_IN:
				outputNum = inputNum / 25.4F;
				break;
			case INVALID: break;
		}
	}
}