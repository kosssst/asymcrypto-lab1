package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BuildInGeneratorTest.class,
        LehmerHighGeneratorTest.class,
        LehmerLowGeneratorTest.class
})

public class MainTest {


}
