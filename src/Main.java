import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        System.out.println(value);
        if (value.length() > 6)
        {
            throw new Exception();
        }
        System.out.println(calc(value));
    }

    public static String calc(String value)
    {
        String result = "";
        String[] values = value.split(" ");
        try
        {
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[2]);
            String operation = values[1];
            Calculate calc = new Calculate();
            result = Integer.toString(calc.getResult(a,b,operation));
        }
        catch (Exception e)
        {
            Conventer convert = new Conventer();
            int a = convert.romanToArabic(values[0]);
            int b = convert.romanToArabic(values[2]);
            String operation = values[1];
            Calculate calculate = new Calculate();
            int res = calculate.getResult(a,b,operation);
            result = convert.arabicToRomain(res);
        }

        return result;
    }
}
