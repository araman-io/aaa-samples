package cd.aaa.number.resolver;

public class TensAndUnitsResolver implements Resolver {
  
  @Override
  public int getUnits(int number) {
    int remainder = number % 100;
    if (remainder < 20 ) {
      return remainder;
    } else {
      return 0;
    }
  }

  @Override
  public String getDenomination() {
    return "";
  }
  
  @Override
  public int hashCode() {
    int result = 1;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (getClass() == obj.getClass())
      result = true;
    return result;
  }
}


