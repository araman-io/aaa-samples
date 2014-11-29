package cd.aaa.number;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InOrder;

import cd.aaa.number.resolver.CroreResolver;
import cd.aaa.number.resolver.HundredsResolver;
import cd.aaa.number.resolver.LacResolver;
import cd.aaa.number.resolver.Resolver;
import cd.aaa.number.resolver.TensAndUnitsResolver;
import cd.aaa.number.resolver.TensResolver;
import cd.aaa.number.resolver.ThousandResolver;

public class NumberTest {

	Resolver[] expectedResolverChain = new Resolver[] { new CroreResolver(), new LacResolver(), new ThousandResolver(),
			new HundredsResolver(), new TensResolver(), new TensAndUnitsResolver() };

	@Test
	public void resolverChainShouldGoFromHigestDenoinationToLowest() {
		Number n = new Number(45);
		assertArrayEquals(expectedResolverChain, n.getResolverSequence());

		n = new Number(1000000);
		assertArrayEquals(expectedResolverChain, n.getResolverSequence());
	}

	@Test
	public void shouldCallResolversInChainExactlyOnce() {
		Resolver hR = spy(new HundredsResolver());
		Resolver tauR = spy(new TensAndUnitsResolver());
		Resolver tR = spy(new TensResolver());
		Resolver[] chain = new Resolver[] { hR, tR, tauR };

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
		Resolver hR = spy(new HundredsResolver());
		Resolver tauR = spy(new TensAndUnitsResolver());
		Resolver tR = spy(new TensResolver());
		Resolver[] chain = new Resolver[] { hR, tR, tauR };

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
