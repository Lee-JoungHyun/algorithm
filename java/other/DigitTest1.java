package other;

public class DigitTest1 {
    public static void main(String[] args) {
        int cnt = 5;
        int num = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j ++) System.out.printf("\t");
            for (int j = 0; j < 5 - i; j ++) {
                if (num < 10)
                    System.out.printf("%d\t", num++);
                else
                    System.out.printf("%d\t", num++);
            }
            System.out.println();
        }
    }
}
