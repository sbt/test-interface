package org.scalatools.testing;

@Deprecated
public interface Event {

    String testName();

    String description();

    Result result();

    Throwable error();
}
