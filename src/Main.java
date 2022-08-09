import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        System.out.println(calc(value));
    }

    public static String calc(String value) throws Exception {
        String result = "";
        String[] values = value.split(" ");
        if (values.length > 3)
        {
            throw new Exception();
        }
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
            if (res < 1)
            {
                throw new Exception();
            }
            result = convert.arabicToRomain(res);
        }

        return result;
    }
}
