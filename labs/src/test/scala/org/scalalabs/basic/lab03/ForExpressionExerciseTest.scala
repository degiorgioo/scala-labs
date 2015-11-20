package org.scalalabs.basic.lab03

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

/**
 * @see ForExpressionExercise01
 */
@RunWith(classOf[JUnitRunner])
class ForExpressionExerciseTest extends Specification {

  "ForExpressionExercise01" should {
    "find largest palindrom using a for expression" in {
      9009 === ForExpressionExercise01.largestPalindromWithForExpression(2)
      906609 === ForExpressionExercise01.largestPalindromWithForExpression(3)
    }
  }

}