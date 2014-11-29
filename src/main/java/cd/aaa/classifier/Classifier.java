package cd.aaa.classifier;

import java.util.HashSet;
import java.util.Set;

public class Classifier {

  int number = 0;
  Set<Integer> factors = new HashSet<Integer>();

  public Classifier(int i) {
    this.number = i;
    this.determineFactors();
  }

  public Set<Integer> getFactors() {
    return this.factors;
  }

  public void determineFactors() {
    double sqrt = 0d;
    int complement = 0;
    
    sqrt = Math.sqrt(number);
    for (int i = 1; i <= sqrt; i++) {
      if (number % i == 0) {
        factors.add(i);
        complement = number / i;
        factors.add(complement);
      }
    }
  }

  public boolean isPerfect() {
    if (sumFactors() - number == number) {
      return true;
    } else {
      return false;
    }
  }

  public int sumFactors() {
    int result = 0;
    for (int i : factors) {
      result += i;
    }

    return result;
  }


}
