package cd.aaa.ex2.resolver;

public class LacResolver extends RangeResolver {

  public LacResolver() {
    super(100000, 100);
  }
  
  @Override
  public String getDenomination() {
    return "lac";
  }


}
