package cd.aaa.number;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cd.aaa.number.resolver.CroreResolverTest;
import cd.aaa.number.resolver.HundredsResolverTest;
import cd.aaa.number.resolver.LacResolverTest;
import cd.aaa.number.resolver.TensAndUnitsResolverTest;
import cd.aaa.number.resolver.TensResolverTest;
import cd.aaa.number.resolver.ThousandResolverTest;

@RunWith(Suite.class)
@SuiteClasses({HundredsResolverTest.class, LacResolverTest.class, TensAndUnitsResolverTest.class,
    TensResolverTest.class, ThousandResolverTest.class, SpellMapTest.class, CroreResolverTest.class, NumberTest.class})
public class NumberTestSuite {

}
