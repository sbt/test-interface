package sbt.testing

import org.scalatest._

class TestSelectorSpec extends UnitSpec {

  object `a TestSelector` {
    val redTestSelector = new TestSelector("red")
    val blueTestSelector = new TestSelector("blue")
    def `should give back what you put into it`: Unit = {
      redTestSelector.testName shouldBe "red"
      blueTestSelector.testName shouldBe "blue"
    }
    def `should have a properly behaving equals method`: Unit = {
      redTestSelector shouldEqual redTestSelector
      redTestSelector shouldEqual new TestSelector("red")
      redTestSelector shouldEqual new TestSelector(red())
      redTestSelector should not equal new TestSelector("blue")
      redTestSelector should not equal null
      redTestSelector should not equal "howdy"
      redTestSelector should not equal new SuiteSelector
    }
    def `should have a properly behaving hashCode method`: Unit = {
      redTestSelector.hashCode shouldEqual redTestSelector.hashCode
      redTestSelector.hashCode shouldEqual (new TestSelector("red")).hashCode
      redTestSelector.hashCode should not equal blueTestSelector.hashCode
      blueTestSelector.hashCode shouldEqual blueTestSelector.hashCode
      blueTestSelector.hashCode shouldEqual (new TestSelector("blue")).hashCode
    }
    def `should throw NPE from constructor if null passed`: Unit = {
      a [NullPointerException] should be thrownBy {
        new TestSelector(null)
      }
    }
    def `should have a pretty toString`: Unit = {
      redTestSelector.toString shouldEqual "TestSelector(red)"
      blueTestSelector.toString shouldEqual "TestSelector(blue)"
    }
  }
}

