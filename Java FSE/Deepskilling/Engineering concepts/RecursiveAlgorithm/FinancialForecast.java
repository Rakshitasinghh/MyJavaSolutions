public class FinancialForecast {

   
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double presentValue = 10000;     
        double annualGrowthRate = 0.08;  
        int years = 5;

        double futureValue = calculateFutureValue(presentValue, annualGrowthRate, years);
        System.out.printf("Predicted future value after %d years: ₹%.2f\n", years, futureValue);
    }
}

/*
Time Complexity:
- Recursive Time Complexity: O(n)
- Each recursive call reduces 'years' by 1 until it hits 0.

Optimization:
- This recursion is simple and efficient 
- For performance-critical applications or large inputs, convert to iteration (tail-recursive or loop).


*/
