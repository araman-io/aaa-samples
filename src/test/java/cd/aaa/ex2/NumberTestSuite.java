package cd.aaa.ex2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cd.aaa.ex2.resolver.CroreResolverTest;
import cd.aaa.ex2.resolver.HundredsResolverTest;
import cd.aaa.ex2.resolver.LacResolverTest;
import cd.aaa.ex2.resolver.TensAndUnitsResolverTest;
import cd.aaa.ex2.resolver.TensResolverTest;
import cd.aaa.ex2.resolver.ThousandResolverTest;

@RunWith(Suite.class)
@SuiteClasses({HundredsResolverTest.class, LacResolverTest.class, TensAndUnitsResolverTest.class,
    TensResolverTest.class, ThousandResolverTest.class, SpellMapTest.class, CroreResolverTest.class, NumberTest.class})
public class NumberTestSuite {

}
