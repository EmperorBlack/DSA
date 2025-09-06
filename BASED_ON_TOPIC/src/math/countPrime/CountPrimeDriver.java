package math.countPrime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimeDriver {

  public static void main(String[] args) {

    System.out.println( Solution_prime_factors_2.findPrimeFactors(12246));
  }
}
class Solution {
  public int countPrimes(int n) {

    if(n < 3){
      return 0;
    }
    int count = 1;
    for (int i = 3; i <n ; i=i+2) {
      if(isPrime(i)){
        count++;
      }
    }
    return count;
  }

  public boolean isPrime(int n){
    for (int i = 2; i*i <= n ; i++) {
      if(n%i == 0){
        return false;
      }
    }
    return true;
  }
}



//sieve check isPrime in constant time by using technique
//by taking extra space for the factor it gives us prime, we set all its multiple to 0
class Solution_l {
  public int countPrimes(int n) {
    // If n is less than 3, there are no primes less than n
    if (n < 3) {
      return 0;
    }

    // Create an array 'prime' where each index represents whether the number is prime (1) or not (0).
    int[] prime = new int[n];
    Arrays.fill(prime, 1); // Mark all numbers as potential primes

    // We know that 0 and 1 are not prime, so mark them as non-prime
    prime[0] = prime[1] = 0;

    // Start the sieve process from the first prime number, i.e., 2
    for (int i = 2; i * i < n; i++) {
      // If prime[i] is still marked as prime, we proceed to mark all its multiples as non-prime
      if (prime[i] == 1) {
        // Mark all multiples of i starting from i * i as non-prime
        for (int j = i * i; j < n; j += i) {
          prime[j] = 0; // Set the multiple as non-prime
        }
      }
    }

    // Now count all the primes (those that are still marked as 1)
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (prime[i] == 1) {
        count++;
      }
    }

    return count;
  }
}

class Solution_prime_factors {
  // You must implement this function

  static void sieve() {}

  static List<Integer> findPrimeFactors(int N) {
    // code here

    int[] prime = new int[N+1];
    Arrays.fill(prime, 1); // Mark all numbers as potential primes
    List<Integer> list = new ArrayList<>();

    // We know that 0 and 1 are not prime, so mark them as non-prime
    prime[0] = prime[1] = 0;
    for (int i = 2; i * i <= N; i++) {
      // If prime[i] is still marked as prime, we proceed to mark all its multiples as non-prime
      if (prime[i] == 1) {
        // Mark all multiples of i starting from i * i as non-prime
        for (int j = i * i; j <= N; j += i) {
          prime[j] = 0; // Set the multiple as non-prime
        }
      }
    }

    for (int i = 2; i <= N; i++) {
      if (prime[i] == 1 && N % i == 0) {
        list.add(i);
      }
    }

    List<Integer> result = new ArrayList<>();
    for (int prim : list){
      if(prim > N){
        break;
      }

      while (N%prim ==0){
        N = N/prim;
        result.add(prim);
      }
    }
    if(N > 1){
      result.add(N);
    }
    return result;

  }
}

class Solution_prime_factors_2 {
  // You must implement this function

  static void sieve() {}

  static List<Integer> findPrimeFactors(int N) {
    // code here

    int n = (int) Math.ceil(Math.sqrt(N));
    int[] prime = new int[n+1];
    Arrays.fill(prime, 1); // Mark all numbers as potential primes
    List<Integer> list = new ArrayList<>();

    // We know that 0 and 1 are not prime, so mark them as non-prime
    prime[0] = prime[1] = 0;
    for (int i = 2; i * i <= n; i++) {
      // If prime[i] is still marked as prime, we proceed to mark all its multiples as non-prime
      if (prime[i] == 1) {
        // Mark all multiples of i starting from i * i as non-prime
        for (int j = i * i; j <= n; j += i) {
          prime[j] = 0; // Set the multiple as non-prime
        }
      }
    }

    for (int i = 2; i <= n; i++) {
      if (prime[i] == 1 && N % i == 0) {
        list.add(i);
      }
    }

    List<Integer> result = new ArrayList<>();
    for (int prim : list){
      if(prim > N){
        break;
      }

      while (N%prim ==0){
        N = N/prim;
        result.add(prim);
      }
    }
    if(N > 1){
      result.add(N);
    }
    return result;

  }
}

