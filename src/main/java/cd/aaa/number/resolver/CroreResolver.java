package cd.aaa.number.resolver;

public class CroreResolver extends RangeResolver {
  
  public CroreResolver() {
    super(10000000, 100);
  }
  
  @Override
  public String getDenomination() {
    return "crore";
  }

}
