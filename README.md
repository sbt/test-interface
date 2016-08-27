To build, run 'sbt package'

For test framework authors, the interfaces to implement are:
 * `sbt.testing.Framework`
 * `sbt.testing.Runner`
 * `sbt.testing.Fingerprint` (one of `sbt.testing.SubclassFingerprint` or `sbt.testing.AnnotatedFingerprint`)

For test framework clients, `sbt.testing.Logger` and `sbt.testing.EventHandler` must be implemented.

The `org.scalatools` package is deprecated and only exists for backward-compatibility.
No new code should use it and existing users should migrate to `sbt.testing`.
