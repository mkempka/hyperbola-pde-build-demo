package org.eclipsercp.hyperbola.alltests.suite;

import org.eclipsercp.hyperbola.alltests.internal.BundleTestCollector;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite result = new TestSuite("All Hyperbola Tests");
		BundleTestCollector collector = new BundleTestCollector();
		collector.collectTests(result, "org.eclipsercp.hyperbola", "org.eclipsercp.hyperbola", "*_Test");
		return result;
	}
}
