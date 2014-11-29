package cd.aaa.number.resolver;

public class ThousandResolver extends RangeResolver{
  
  public ThousandResolver() {
    super(1000, 100);
  }
  
  @Override
  public String getDenomination() {
    return "thousand";
  }

}
