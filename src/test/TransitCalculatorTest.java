package test;

import static org.junit.jupiter.api.Assertions.*;

import main.TransitCalculator;
import org.junit.jupiter.api.Test;

public class TransitCalculatorTest {
   @Test
   public void testBestFareZeroes() {
      String s = "Minimum of 1 day and 1 ride for program to run.";
      assertEquals(s, TransitCalculator.getBestFare(0, 0));
   }

   @Test
   public void testBestFareNegs() {
      String s = "Minimum of 1 day and 1 ride for program to run.";
      assertEquals(s, TransitCalculator.getBestFare(-1, -1));
   }

   @Test
   public void testBestFareOnes() {
      String s = "You should get the Pay-per-ride option at $2.75 per ride.";
      assertEquals(s, TransitCalculator.getBestFare(1, 1));
   }

   @Test
   public void testBestFareWeek() {
      String s = "You should get the 7-day Unlimited option at $2.54 per ride.";
      assertEquals(s, TransitCalculator.getBestFare(1, 13));
   }

   @Test
   public void testBestFareWeek2() {
      String s = "You should get the 7-day Unlimited option at $0.72 per ride.";
      assertEquals(s, TransitCalculator.getBestFare(1, 46));
   }

   @Test
   public void testBestFareWeek3() {
      String s = "You should get the Pay-per-ride option at $2.75 per ride.";
      assertEquals(s, TransitCalculator.getBestFare(8, 23));
   }

   @Test
   public void testBestFareWeek4() {
      String s = "You should get the 7-day Unlimited option at $2.64 per ride.";
      assertEquals(s, TransitCalculator.getBestFare(8, 25));
   }
}