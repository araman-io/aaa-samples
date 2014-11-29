package cd.aaa.number;

import cd.aaa.number.resolver.CroreResolver;
import cd.aaa.number.resolver.HundredsResolver;
import cd.aaa.number.resolver.LacResolver;
import cd.aaa.number.resolver.Resolver;
import cd.aaa.number.resolver.TensAndUnitsResolver;
import cd.aaa.number.resolver.TensResolver;
import cd.aaa.number.resolver.ThousandResolver;

public class Number {

  int value;

  SpellMap spelling = new SpellMap();

  Resolver[] resolverChain = new Resolver[] {new CroreResolver(), new LacResolver(), new ThousandResolver(),
      new HundredsResolver(), new TensResolver(), new TensAndUnitsResolver()};

  public Number(int i) {
    this.value = i;
  }

  public String spell() {
    StringBuilder result = new StringBuilder();

    for (Resolver r : resolverChain) {
      int toBeSpelt = r.getUnits(value);
      if (toBeSpelt > 0) {
        result.append(spelling.getSpellingFor(toBeSpelt)).append(" ").append(r.getDenomination()).append(" ");
      }
    }

    return result.toString();
  }
  
  public Resolver[] getResolverSequence() {
    return this.resolverChain;
  }
  
  public void setResolverChain(Resolver[] resolverChain) {
    this.resolverChain = resolverChain;
  }

}
