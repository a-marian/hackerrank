package recursion;

public class SumNaturalNumbers {

    public static  int recursiveSummation(int inputNumber){
        if (inputNumber <= 1) return inputNumber;

        return inputNumber + recursiveSummation(inputNumber-1);
    }
}
