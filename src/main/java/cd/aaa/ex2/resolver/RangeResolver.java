package cd.aaa.ex2.resolver;

public abstract class RangeResolver implements Resolver {
  
  int divisor = 0;
  int numberOfDigits = 0;
  
  RangeResolver(int divisor, int numberOfDigits) {
    this.divisor = divisor;
    this.numberOfDigits = numberOfDigits;
  }

  @Override
  public int getUnits(int number) {
    int units = (number / divisor) % numberOfDigits;
    
    return units;
  }

  @Override
  public int hashCode() { 
    final int prime = 31;
    int result = 1;
    result = prime * result + divisor;
    result = prime * result + numberOfDigits;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    boolean result = false;

    RangeResolver other = (RangeResolver) obj;
    
    if (divisor == other.divisor &&  numberOfDigits == other.numberOfDigits)
      result = true;
    
    return result;
  }
  
  

}
