package cd.aaa.number.resolver;

public class HundredsResolver extends RangeResolver {

  public HundredsResolver() {
    super(100, 10);
  }

  @Override
  public String getDenomination() {
    return "hundred";
  }

}
