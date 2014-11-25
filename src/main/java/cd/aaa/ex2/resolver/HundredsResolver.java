package cd.aaa.ex2.resolver;

public class HundredsResolver extends RangeResolver {

  public HundredsResolver() {
    super(100, 10);
  }

  @Override
  public String getDenomination() {
    return "hundred";
  }

}
