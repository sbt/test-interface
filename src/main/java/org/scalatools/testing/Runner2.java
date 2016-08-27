package org.scalatools.testing;

/** New Runner that can handle more types of Fingerprints.*/
@Deprecated
public abstract class Runner2 implements Runner {
	/** Runs the test suite with class name 'testClassName' and returns the results of executing each test
	* contained in the suite.  This Runner should run the suite in the calling (current) thread.
	*
	* 'fingerprint' indicates how the test suite was identified as a test suite.  This method may be called with the
	* same value for 'testClassName' but different fingerprints.  For example, if both a class and its companion object
	* were tests, this method would be called with the same name but with a different value for 'fingerprint.isModule'. */
	public abstract void run(String testClassName, Fingerprint fingerprint, EventHandler eventHandler, String [] args);

	public final void run(String testClassName, TestFingerprint fingerprint, EventHandler eventHandler, String[] args)
	{
		run(testClassName, (Fingerprint)fingerprint, eventHandler, args);
	}
}
