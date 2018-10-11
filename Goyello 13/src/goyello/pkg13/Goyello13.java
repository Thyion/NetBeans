
package goyello.pkg13;

/**
 *
 * @author Krzysztof
 */
public class Goyello13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
/*
    @Override
    public int applyasInt(int left, int right) {
       //IntBinaryOperator adder1 = (int x, int y) -> x + y;
        //IntBinaryOperator adder2 = (x,y) -> x + y;
         //IntBinaryOperator adder3 = (int x, int y) -> {return x + y};
        //return 0;
         //IntBinaryOperator adder3 = (Integer x, Integer y) -> {return x + y};
       return 0;
    }
    */
    IntBinaryOperator io = (x,y)->x + y;
    
    System.out.println(io.applyasInt(2,3));
    }
}
