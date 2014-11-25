package cd.aaa.ex2;

import cd.aaa.ex2.resolver.CroreResolver;
import cd.aaa.ex2.resolver.HundredsResolver;
import cd.aaa.ex2.resolver.LacResolver;
import cd.aaa.ex2.resolver.Resolver;
import cd.aaa.ex2.resolver.TensAndUnitsResolver;
import cd.aaa.ex2.resolver.TensResolver;
import cd.aaa.ex2.resolver.ThousandResolver;

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
