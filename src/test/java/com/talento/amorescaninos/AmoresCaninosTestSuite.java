package com.talento.amorescaninos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.talento.amorescaninos.config.AppConfigTest;
import com.talento.amorescaninos.repository.CaracteristicaRepositoryTest;
import com.talento.amorescaninos.repository.RazaRepositoryTest;

@RunWith(Suite.class)
@SuiteClasses({AppConfigTest.class,
			   CaracteristicaRepositoryTest.class,
			   RazaRepositoryTest.class})
public class AmoresCaninosTestSuite {

}
