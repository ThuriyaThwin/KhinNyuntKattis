import java.util.Scanner;

public class magical3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input;
		while ((input = scan.nextInt()) != 0) {
			int _base = -1;
			input -= 3;
			if (input == 0)
				_base = 4;
			else if (input > 3) {
				boolean isPrime = true;
				for (int i = 2; i <= Math.ceil(Math.sqrt(input)); i++) {
					if (input % i == 0) {
						isPrime = false;
						if (i >= 4) {
							_base = i;
							break;
						} else {
							int factor = input / i;
							boolean isFactorPrime = true;
							for (int j = 2; j <= Math.ceil(Math.sqrt(factor)); j++)
								if (factor % j == 0) {
									isFactorPrime = false;
									break;
								}
							if (isFactorPrime && factor >= 4) {
								_base = factor;
								break;
							}
							break;
						}
					}
				}
				if (isPrime) {
					_base = input;
				} else {
					if (_base == -1) {
						_base = 4;
						while (input >= _base) {
							if (input % _base == 0)
								break;
							_base++;
						}
						if (input < _base)
							_base = -1;
					}
				}
			}
			if (_base == -1)
				System.out.println("No such base");
			else
				System.out.println(_base);
		}
		scan.close();
	}
}
