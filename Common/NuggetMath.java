package Common;
/**
 * A static class to define useful constants and functions when doing math for Nuggets.
 * 
 * VALUES:
 * nuggetWeightPounds - BigDecimal
 * 
 * METHODS:
 * amountForPercent(double, double) - BigDecimal
 * numberNuggets(double, double) - BigDecimal
 */

import java.math.BigDecimal;
import java.math.MathContext;

public class NuggetMath {
    
    // ALL CONSTANT VALUES

    /**
     * Average weight of chicken nugget according to McDonalds.
     * Probably not 100% accurate, but a good estimate for now.
     */
    public static final BigDecimal nuggetWeightPounds = new BigDecimal(16.5).multiply(new BigDecimal(0.0022046226));

    //ALL CONSTANT METHODS

    /**
     * Returns (as a BigDecimal) the weight required for the new weight to be some percentage larger than the original weight.
     * The values input are both doubles, but for the sake of accuracy, the return type is a BigDecimal rounded to 20 digits.
     * <p>
     * For example, amountForPercentage(99, 1) will return 1 since a 99 pound person who ate a pound of chicken nuggets would 
     * be 100 pounds, one percentage (a single pound) of which is chicken nuggets.
     * 
     * @param orig The original weight of the person as a double
     * @param percent The percentage increase as a double
     *
     * @return The weight in pounds required to increase that much.
     * 
     * @throws DivideByZero If the percentage is 100%, the BigInteger divides by zero and returns an error.
    */
    public static BigDecimal amountForPercent(double orig, double percent) {
        //New weight needed for consumption
        BigDecimal weight;

        //The general formula is orginal weight times percent over 100 minus percent. Source: trust me I did the math
        weight = (new BigDecimal(percent * orig)).divide(new BigDecimal(100 - percent), new MathContext(20));
        
        //Return it
        return weight;
    }

    /**
     * Returns (as a BigDecimal) the number of nuggest required for the new weight to be some percentage larger than the 
     * original weight. The values input are both doubles, but in the sake of accuracy, the return type is a BigDecimal 
     * rounded to 20 digits. This function will simply call amountForPercent with the given inputs and then factor in the 
     * weight of a nugget.
     * 
     * @param orig The original weight of the person as a double
     * @param percent The percentage increase as a double
     *
     * @return The of nuggets required to increase that much.
     * 
     * @throws DivideByZero If the percentage is 100%, the BigInteger divides by zero and returns an error.
     * 
     * @see amountForPercent
    */
    public static BigDecimal numberNuggets(double orig, double percent) {
        //New weight needed for consumption
        BigDecimal weight = amountForPercent(orig, percent);
        
        //Return it
        return weight.divide(nuggetWeightPounds, new MathContext(20));
    }
}
