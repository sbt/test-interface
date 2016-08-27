package org.scalatools.testing;

/** Identifies a test by a class or its methods having a specific annotation. */
@Deprecated
public interface AnnotatedFingerprint extends Fingerprint {
	/** Whether a test is a module or a class*/
	public boolean isModule();
	/** The name of the annotation that identifies it as a test.*/
	public String annotationName();
}
