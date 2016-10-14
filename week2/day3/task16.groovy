/*16  Text2number
Write a program that reads a number with commas and decimal dots (such as “23,419.34”) and then prints a number that is half of it. Do not use Double.parseDouble().
If you were writing a simple spreadsheet, you could use this code to parse the input in the cells.*/

println("Please enter a number with commas and decimal point: ");
String input = System.console().readLine();

double number = parseNumber(stripCommas(input));
println number / 2;

def parseNumber(String input){
    int decimalPointPosition = input.indexOf(".");
    double columnValue = 1;
    double output = 0;

    if(decimalPointPosition > 0){
        int reduction = input.length - decimalPointPosition;
        for(int i = reduction; i>0; i--){
            columnValue /= 10;
        }
    }

    for(char character : input){
        if(character != '.'){
            output += Integer.parseInt(character.toString()) * columnValue;
            columnValue *= 10;
        }
    }

    return output;
}

def stripCommas(String input){
    return input.replace(",", "");
}