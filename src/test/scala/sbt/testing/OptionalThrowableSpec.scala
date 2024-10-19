package sbt.testing

import org.scalatest._

class OptionalThrowableSpec extends UnitSpec {

  object `an OptionalThrowable` {
    val ex1 = new Error("red alert")
    val ex2 = new RuntimeException("feeling blue")
    val def1 = new OptionalThrowable(ex1)
    val def2 = new OptionalThrowable(ex2)
    val undef = new OptionalThrowable()
    object `when defined` {
      def `should say it is defined`: Unit = {
        def1.isDefined shouldBe true
        def2.isDefined shouldBe true
      }
      def `should say it is not empty`: Unit = {
        def1.isEmpty shouldBe false
        def2.isEmpty shouldBe false
      }
      def `should return the Throwable from its get method`: Unit = {
        def1.get shouldBe ex1
        def2.get shouldBe ex2
      }
    }
    object `when empty` {
      def `should say it is not defined`: Unit = {
        undef.isDefined shouldBe false
      }
      def `should say it is empty`: Unit = {
        undef.isEmpty shouldBe true
      }
      def `should return throw IllegalStateException from its get method`: Unit = {
        an [IllegalStateException] should be thrownBy {
          undef.get
        }
      }
    }
    def `should throw NPE from constructor if null passed`: Unit = {
      a [NullPointerException] should be thrownBy {
        new OptionalThrowable(null)
      }
    }
    def `should have a properly behaving equals method`: Unit = {
      def1 shouldEqual def1
      def1 shouldEqual new OptionalThrowable(ex1)
      def2 shouldEqual def2
      def2 shouldEqual new OptionalThrowable(ex2)
      def1 should not equal null
      def1 should not equal undef
      def1 should not equal "howdy"
      def1 should not equal new OptionalThrowable(ex2)
      undef shouldEqual undef
      undef shouldEqual new OptionalThrowable()
      undef should not equal def1
    }
    def `should have a properly behaving hashCode method`: Unit = {
      def1.hashCode shouldEqual (new OptionalThrowable(ex1)).hashCode
      def2.hashCode shouldEqual (new OptionalThrowable(ex2)).hashCode
      undef.hashCode shouldEqual (new OptionalThrowable()).hashCode
    }
    def `should have a pretty toString`: Unit = {
      def1.toString should (startWith ("OptionalThrowable(") and endWith (")") and not be ("OptionalThrowable()"))
      def2.toString should (startWith ("OptionalThrowable(") and endWith (")") and not be ("OptionalThrowable()"))
      undef.toString shouldBe "OptionalThrowable()"
    }
  }
}

