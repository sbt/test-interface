package org.scalatools.testing;

/** A basic interface to provide feedback.   Note that the logging methods are not call-by-name as
* a Scala interface would be.  We could define a Function0 interface if we find that this is a problem.*/
@Deprecated
public interface Logger {
	/** True if ANSI color codes are understood by this instance.*/
	public boolean ansiCodesSupported();

	public void error(String msg);
	public void warn(String msg);
	public void info(String msg);
	public void debug(String msg);
	public void trace(Throwable t);
}
