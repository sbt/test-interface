package sbt.testing

import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.refspec.RefSpec

class UnitSpec extends RefSpec with Matchers with TableDrivenPropertyChecks {
  def red(): String = "der".reverse
}
