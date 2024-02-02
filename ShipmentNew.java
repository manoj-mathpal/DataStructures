package amazonPrep;

import java.util.Arrays;

     class ShipmentDaysCalculator {

         public static int calculateShippingDays(int[] shipmentCounts) {
             int maxShipment = Arrays.stream(shipmentCounts).max().getAsInt();

             for (int days = maxShipment; ; days++) {
                 int remainingItems = 0;
                 for (int count : shipmentCounts) {
                     if (count > 0) {
                         remainingItems += count - (days - 1);
                     }
                 }

                 if (remainingItems <= 0) {
                     return days;
                 }
             }
         }

        // Helper method to calculate the least common multiple (LCM) of two numbers
        private static int lcm(int a, int b) {
            return (a * b) / gcd(a, b);
        }

        // Helper method to calculate the greatest common divisor (GCD) of two numbers
        private static int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

        public static void main(String[] args) {
            int[] shipmentCounts = {9,8,7,4,2,6,3,1,3,7,1};
            int days = calculateShippingDays(shipmentCounts);
            System.out.println("It would take " + days + " days to ship all items.");
        }
    }


//4, 2, 3, 3, 3    2 3 3 3 4    0 1 1 1 2  0 0 0 0 1  0 0 0 0 0