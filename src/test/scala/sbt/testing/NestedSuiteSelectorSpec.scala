package sbt.testing

import org.scalatest._

class NestedSuiteSelectorSpec extends UnitSpec {

  object `a NestedSuiteSelector` {
    val redNestedSuiteSelector = new NestedSuiteSelector("red")
    val blueNestedSuiteSelector = new NestedSuiteSelector("blue")
    def `should give back what you put into it`: Unit = {
      redNestedSuiteSelector.suiteId shouldBe "red"
      blueNestedSuiteSelector.suiteId shouldBe "blue"
    }
    def `should have a properly behaving equals method`: Unit = {
      redNestedSuiteSelector shouldEqual redNestedSuiteSelector
      redNestedSuiteSelector shouldEqual new NestedSuiteSelector("red")
      redNestedSuiteSelector shouldEqual new NestedSuiteSelector(red())
      redNestedSuiteSelector should not equal new NestedSuiteSelector("blue")
      redNestedSuiteSelector should not equal null
      redNestedSuiteSelector should not equal "howdy"
      redNestedSuiteSelector should not equal new SuiteSelector
    }
    def `should have a properly behaving hashCode method`: Unit = {
      redNestedSuiteSelector.hashCode shouldEqual redNestedSuiteSelector.hashCode
      redNestedSuiteSelector.hashCode shouldEqual (new NestedSuiteSelector("red")).hashCode
      redNestedSuiteSelector.hashCode should not equal blueNestedSuiteSelector.hashCode
      blueNestedSuiteSelector.hashCode shouldEqual blueNestedSuiteSelector.hashCode
      blueNestedSuiteSelector.hashCode shouldEqual (new NestedSuiteSelector("blue")).hashCode
    }
    def `should throw NPE from constructor of null passed`: Unit = {
      a [NullPointerException] should be thrownBy {
        new NestedSuiteSelector(null)
      }
    }
    def `should have a pretty toString`: Unit = {
      redNestedSuiteSelector.toString shouldEqual "NestedSuiteSelector(red)"
      blueNestedSuiteSelector.toString shouldEqual "NestedSuiteSelector(blue)"
    }
  }
}

