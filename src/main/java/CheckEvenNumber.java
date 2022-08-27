public class CheckEvenNumber {
    public static boolean checkValue(int number)
    {
        return number %2==0;
    }

    public static void main(String[] args){
        System.out.println("CheckEven: "+checkValue(5));
    }
}
