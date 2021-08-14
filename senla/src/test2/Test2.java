package test2;

public class Test2 {
    public static void main(String[] args){

        String str = "jklghghgmn4869pjro63ggh566ops";
        int sum = 0;
        int evenSum = 0;
        for (char c : str.replaceAll("\\D", "").toCharArray()) {
            int digit = c - '0';
            sum += digit;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
        }
        System.out.println("строка = " + str);
        System.out.println(sum);


    }
}
