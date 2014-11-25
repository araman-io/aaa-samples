package cd.aaa.ex2;

import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.assertArrayEquals;

import cd.aaa.ex2.Number;
import cd.aaa.ex2.resolver.CroreResolver;
import cd.aaa.ex2.resolver.HundredsResolver;
import cd.aaa.ex2.resolver.LacResolver;
import cd.aaa.ex2.resolver.Resolver;
import cd.aaa.ex2.resolver.TensAndUnitsResolver;
import cd.aaa.ex2.resolver.TensResolver;
import cd.aaa.ex2.resolver.ThousandResolver;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NumberTest {

  Resolver[] expectedResolverChain = new Resolver[] {new CroreResolver(), new LacResolver(), new ThousandResolver(),
      new HundredsResolver(), new TensResolver(), new TensAndUnitsResolver()};

  @Test
  public void resolverChainShouldGoFromHigestDenoinationToLowest() {
    Number n = new Number(45);
    assertArrayEquals(expectedResolverChain, n.getResolverSequence());

    n = new Number(1000000);
    assertArrayEquals(expectedResolverChain, n.getResolverSequence());
  }

  @Test
  public void shouldCallResolversInChainExactlyOnce() {
    Resolver hR = mock(HundredsResolver.class);
    Resolver tauR = mock(TensAndUnitsResolver.class);
    Resolver tR = mock(TensResolver.class);
    Resolver[] chain = new Resolver[] {hR, tR, tauR};
    

    InOrder orderOfCall = inOrder(hR, tR, tauR);
    
    Number n = new Number(456);
    n.setResolverChain(chain);
    n.spell();
    
    orderOfCall.verify(hR).getUnits(456);
    orderOfCall.verify(tR).getUnits(456);
    orderOfCall.verify(tauR).getUnits(456);

    verify(hR, times(1)).getUnits(456);
    verify(tauR, times(1)).getUnits(456);
    verify(tR, times(1)).getUnits(456);
  }


  @Test
  public void shouldCallResolverDenominationOnlyWhenResolverUnitsIsMoreThanZero() {
    Resolver hR = mock(HundredsResolver.class);
    Resolver tauR = mock(TensAndUnitsResolver.class);
    Resolver tR = mock(TensResolver.class);
    Resolver[] chain = new Resolver[] {hR, tR, tauR};
    
    when(hR.getUnits(50)).thenReturn(0);
    when(tR.getUnits(50)).thenReturn(50);
    when(tauR.getUnits(50)).thenReturn(0);
    
    Number n = new Number(50);
    n.setResolverChain(chain);
    n.spell();
    
    verify(hR, times(1)).getUnits(50);
    verify(hR, never()).getDenomination();
    verify(tR, times(1)).getUnits(50);
    verify(tR, times(1)).getDenomination();
    verify(tauR, times(1)).getUnits(50);
    verify(tauR, never()).getDenomination();
  }
}
