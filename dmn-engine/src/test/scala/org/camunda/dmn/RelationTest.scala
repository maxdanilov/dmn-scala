package org.camunda.dmn

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.camunda.dmn.DmnEngine._
import java.time.LocalDate

class RelationTest extends FlatSpec with Matchers with DecisionTest {
  
  lazy val applicantData = parse("/relation/ApplicantData.dmn")
    
  "A relation" should "return a list of contexts" in
  {
    eval(applicantData, "applicantData", Map()) should be(
        Result(Map("CreditHistory" -> List(
          Map(
            "recordDate" -> LocalDate.parse("2008-03-12"),
            "event" -> "home mortgage",
            "weight" -> 100
          ),
          Map(
            "recordDate" -> LocalDate.parse("2011-04-01"),
            "event" -> "foreclosure warning",
            "weight" -> 150    
          ))))) 
  }
    
}