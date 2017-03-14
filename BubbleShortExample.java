class BubbleShortExample {
	public static void main(String[] args) {
		int array[] = { 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}

		System.out.println("sum is" + sum + " and duplice number is "
				+ (sum - ((10 * (10 + 1)) / 2)));

		bubbleShort();

	}

	public static void bubbleShort() {
		int arr[] = { 10, 8, 5, 1, 2, 4, 6, 4, 6, 7, 3, 9 };

		System.out.println("Unsorted arrya is ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length; j++) {
				counter++;
				if (arr[i] < arr[j]) {
					int tem = arr[j];
					arr[j] = arr[i];
					arr[i] = tem;

				}
				// else continue;

			}
		}
		System.out.println("\n" + counter + " is times looped \n"
				+ "sorted arrya is ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}

		int arra[] = { 10, 8, 5, 1, 2, 4, 6, 4, 6, 7, 3, 9 };

		System.out.println("\n  Unsorted arrya is ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arra[i] + ", ");
		}
		counter = 0;
		for (int i = 1; i < arra.length; i++) {

			for (int j = 0; j < (arra.length - i); j++) {
				counter++;
				if (arra[j] < arra[j + 1]) {
					int tem = arra[j + 1];
					arra[j + 1] = arra[j];
					arra[j] = tem;

				}
				// else continue;

			}
		}
		System.out.println("\n" + counter + " is times looped \n"
				+ "sorted arrya is ");
		for (int i = 0; i < arra.length; i++) {
			System.out.print(arra[i] + ", ");
		}
	}

}