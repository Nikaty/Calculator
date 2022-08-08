import java.util.List;

class Conventer {



    public int romanToArabic(String input) {
        String romanNumber = input.toUpperCase();
        int res = 0;

        List romanNumbers = RomanNumbers.getListSortedOfValues();

        int i = 0;

        while ((romanNumber.length() > 0) && (i < romanNumbers.size()))
        {
            RomanNumbers symbol = (RomanNumbers) romanNumbers.get(i);
            if (romanNumber.startsWith(symbol.name()))
            {
                res += symbol.getValue();
                romanNumber = romanNumber.substring(symbol.name().length());
            }
            else
            {
                i++;
            }
        }
        if (romanNumber.length() > 0)
        {
            throw new IllegalArgumentException();
        }
        return res;
    }
    public String arabicToRomain(int number) {
        if ((number <= 0) || (number > 4000))
        {
            throw new IllegalArgumentException();
        }

        List romanNumbers = RomanNumbers.getListSortedOfValues();

        int i = 0;

        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumbers.size()))
        {
            RomanNumbers currentSymbol = (RomanNumbers) romanNumbers.get(i);
            if (currentSymbol.getValue() <= number)
            {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            }
            else
            {
                i++;
            }
        }
        return sb.toString();
    }
}


