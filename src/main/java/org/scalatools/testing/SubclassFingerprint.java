package org.scalatools.testing;

/** Identifies a test as a class that has a specific type as an ancestor. */
@Deprecated
public interface SubclassFingerprint extends Fingerprint {
	/** Whether a test is a module or a class*/
	public boolean isModule();
	/** The name of the type that designates a test.*/
	public String superClassName();
}
