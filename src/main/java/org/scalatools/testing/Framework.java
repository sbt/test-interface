package org.scalatools.testing;

@Deprecated
public interface Framework {
	/** The name of the test framework that this object represents.  It is intended to be a human readable label.*/
	public String name();
	/** Specifies how to identify classes that are tests.*/
	public Fingerprint[] tests();

	/** Provide a runner for tests that will load test classes from 'testClassLoader' and direct all
	* logging output from the framework to 'loggers'.*/
	public Runner testRunner(ClassLoader testClassLoader, Logger[] loggers);
}
