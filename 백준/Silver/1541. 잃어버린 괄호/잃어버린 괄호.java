
import java.util.Scanner;

public class Main {

    static int result = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splitArr = str.split("-");

        for (int i = 0; i < splitArr.length; i++) {
            int sumResult = sum(splitArr[i]);

            if(i == 0) {
                result += sumResult;
            } else {
                result -= sumResult;
            }
        }

        System.out.println(result);
    }

    private static int sum(String s) {

        String[] splitArr = s.split("[+]");
        int count = 0;

        for (int i = 0; i < splitArr.length; i++) {
            count += Integer.parseInt(splitArr[i]);
        }
        return count;

    }
}
