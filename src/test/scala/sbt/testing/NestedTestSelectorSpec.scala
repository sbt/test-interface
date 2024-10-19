package sbt.testing

import org.scalatest._

class NestedTestSelectorSpec extends UnitSpec {

  object `a NestedTestSelector` {
    val redBirdNestedTestSelector = new NestedTestSelector("red", "bird")
    val blueBirdNestedTestSelector = new NestedTestSelector("blue", "bird")
    val redFishNestedTestSelector = new NestedTestSelector("red", "fish")
    val blueFishNestedTestSelector = new NestedTestSelector("blue", "fish")
    def `should give back what you put into it`: Unit = {
      redBirdNestedTestSelector.suiteId shouldBe "red"
      redBirdNestedTestSelector.testName shouldBe "bird"
      blueBirdNestedTestSelector.suiteId shouldBe "blue"
      blueBirdNestedTestSelector.testName shouldBe "bird"
      redFishNestedTestSelector.suiteId shouldBe "red"
      redFishNestedTestSelector.testName shouldBe "fish"
      blueFishNestedTestSelector.suiteId shouldBe "blue"
      blueFishNestedTestSelector.testName shouldBe "fish"
    }
    def `should have a properly behaving equals method`: Unit = {
      redBirdNestedTestSelector shouldEqual redBirdNestedTestSelector
      redBirdNestedTestSelector shouldEqual new NestedTestSelector("red", "bird")
      redBirdNestedTestSelector shouldEqual new NestedTestSelector(red(), "bird")
      redBirdNestedTestSelector should not equal blueBirdNestedTestSelector
      redBirdNestedTestSelector should not equal redFishNestedTestSelector
      redBirdNestedTestSelector should not equal blueFishNestedTestSelector
      redBirdNestedTestSelector should not equal null
      redBirdNestedTestSelector should not equal "howdy"
      redBirdNestedTestSelector should not equal new SuiteSelector
    }
    def `should have a properly behaving hashCode method`: Unit = {
      redBirdNestedTestSelector.hashCode shouldEqual redBirdNestedTestSelector.hashCode
      redBirdNestedTestSelector.hashCode shouldEqual (new NestedTestSelector("red", "bird")).hashCode
      redBirdNestedTestSelector.hashCode should not equal blueBirdNestedTestSelector.hashCode
      redBirdNestedTestSelector.hashCode should not equal redFishNestedTestSelector.hashCode
      blueBirdNestedTestSelector.hashCode shouldEqual blueBirdNestedTestSelector.hashCode
      blueBirdNestedTestSelector.hashCode shouldEqual (new NestedTestSelector("blue", "bird")).hashCode
    }
    def `should throw NPE from constructor if null passed`: Unit = {
      a [NullPointerException] should be thrownBy {
        new NestedTestSelector(null, "bird")
      }
      a [NullPointerException] should be thrownBy {
        new NestedTestSelector("red", null)
      }
    }
    def `should have a pretty toString`: Unit = {
      redBirdNestedTestSelector.toString shouldEqual "NestedTestSelector(red, bird)"
      blueBirdNestedTestSelector.toString shouldEqual "NestedTestSelector(blue, bird)"
    }
  }
}

