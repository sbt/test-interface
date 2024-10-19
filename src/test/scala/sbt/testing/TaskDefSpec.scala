package sbt.testing

import org.scalatest._

class TaskDefSpec extends UnitSpec {

  case object SuiteSubclassFingerprint extends SubclassFingerprint {
    def isModule: Boolean = false
    def superclassName: String = "org.scalatest.Suite"
    def requireNoArgConstructor: Boolean = true
  }

  case object WrapWithAnnotatedFingerprint extends AnnotatedFingerprint {
    def isModule: Boolean = false
    def annotationName: String = "org.scalatest.WrapWith"
  }

  val fqn1 = "com.myproject.SomeSpec"
  val td1 =
    new TaskDef(
      fqn1,
      SuiteSubclassFingerprint,
      false,
      Array(new SuiteSelector)
    )
    val fqn2 = "com.myproject.SomeOtherSpec"
    val td2 =
      new TaskDef(
        fqn2,
        WrapWithAnnotatedFingerprint,
        true,
        Array(new TestSelector("it should do something"))
      )

  object `a TaskDef` {
    def `should give back what you put into it`: Unit = {
        td1.fullyQualifiedName shouldBe fqn1
        td1.fingerprint shouldBe SuiteSubclassFingerprint
        td1.explicitlySpecified shouldBe false
        td1.selectors shouldBe Array(new SuiteSelector)

        td2.fullyQualifiedName shouldBe fqn2
        td2.fingerprint shouldBe WrapWithAnnotatedFingerprint
        td2.explicitlySpecified shouldBe true
        td2.selectors shouldBe Array(new TestSelector("it should do something"))
    }
    def `should throw NPE from constructor if null passed`: Unit = {
      val fullyQualifiedName: String = "com.myproject.SomeSpec"
      val fingerprint: Fingerprint = SuiteSubclassFingerprint
      val selectors: Array[Selector] = Array(new SuiteSelector)
      val invalidCombos =
        Table(
          ("fullyQualifiedName", "fingerprint", "selectors"),
          (        null        ,  fingerprint ,  selectors ),
          ( fullyQualifiedName ,     null     ,  selectors ),
          ( fullyQualifiedName ,  fingerprint ,    null    )
        )
      forAll (invalidCombos) { (fqn, fp, sel) =>
        a [NullPointerException] should be thrownBy {
          new TaskDef(fqn, fp, false, sel)
        }
      }
    }
    def `should have a properly behaving equals method`: Unit = {
      td1 shouldEqual td1
      td1 shouldEqual (
        new TaskDef(
          fqn1,
          SuiteSubclassFingerprint,
          false,
          Array(new SuiteSelector)
        )
      )
      td1 should not equal null
      td1 should not equal "howdy"
      td1 should not equal td2
    }
    def `should have a properly behaving hashCode method`: Unit = {
      td1.hashCode shouldEqual td1.hashCode
      td1.hashCode shouldEqual (
        new TaskDef(
          fqn1,
          SuiteSubclassFingerprint,
          false,
          Array(new SuiteSelector)
        ).hashCode
      )
      td1.hashCode should not equal td2.hashCode
      td2.hashCode shouldEqual td2.hashCode
      td2.hashCode shouldEqual (
        new TaskDef(
          fqn2,
          WrapWithAnnotatedFingerprint,
          true,
          Array(new TestSelector("it should do something"))
        ).hashCode
      )
    }
    def `should have a pretty toString`: Unit = {
      td1.toString should startWith ("TaskDef(com.myproject.SomeSpec, ")
      td1.toString should endWith (", false, [SuiteSelector])")
      td2.toString should startWith ("TaskDef(com.myproject.SomeOtherSpec, ")
      td2.toString should endWith (", true, [TestSelector(it should do something)])")
    }
  }
}

