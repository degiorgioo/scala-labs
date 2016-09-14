package org.scalalabs.basic.lab02
/**
 * This Lab contains exercises where the usage of
 * higher order collection methods can be rehearsed.
 */

object CollectionExercise02 {

  class Person(val age: Int, val name: String)

  /**
   * Take a look at the java class: {@link ImperativeSample}. The
   * groupAdultsPerAgeGroup is implemented using an imperative programming
   * style.
   * In this exercise you will rewrite the groupAdultsPerAgeGroup method
   * using a functional approach.
   * The method does the following:
   * 1. filter out all adults (>= 18) of the list of persons
   * 2. sort the list by name
   * 3. group each person by their age group, e.g. 30 -> Seq(duke, jeniffer)
   */
  def groupAdultsPerAgeGroup(persons: Seq[Person]): Map[Int, Seq[Person]] = {
    persons.filter(_.age >= 18)
      .sortBy(_.name)
      .groupBy(_.age / 10 * 10)
  }
}

/*========================================================== */

object CollectionExercise03 {
  /**
   * Create a method that checks that each subsequent value is greater than
   * the previous one.
   * E.g.:
   * checkValuesIncrease(Seq(1,2,3)) == true
   * checkValuesIncrease(Seq(1,2,2)) == false
   */
  def checkValuesIncrease[T <% Ordered[T]](seq: Seq[T]): Boolean =
    if (seq.size > 1) seq.sliding(2).forall(l ⇒ l(0) < l(1)) else true

}
/*========================================================== */

object CollectionExercise04 {
  /**
   * Calculate the length of the longest word in a list of sentences.
   * To keep it simple it's ok to use String.split to extract all words of a sentence.
   */
  def calcLengthLongestWord(lines: String*): Int = {
    lines.map(_.split(" ").map(_.length).max).max
    //or: 
    lines.flatMap(_.split(" ").map(_.length)).max
  }
}

object CollectionExercise05 {
  /**
   * Filter all even numbers of the given sequence using foldLeft.
   * E.g. Seq(1,2,3) is Seq(2)
   */
  def filterWithFoldLeft(seq: Seq[Int]): Seq[Int] = {
    seq.foldLeft(Seq.empty[Int])((cum, i) ⇒ if (i % 2 == 0) cum :+ i else cum)
  }
  /**
   * Group all numbers based on whether they are even or odd using foldLeft.
   * For even use 'true' for odd use 'false'.
   * E.g: Seq(1,2,3) is Map(true -> Seq(2), false -> Seq(1,3))
   */
  def groupByWithFoldLeft(seq: Seq[Int]): Map[Boolean, Seq[Int]] = {
    seq.foldLeft(Map[Boolean, Seq[Int]]()) { (map, next) ⇒
      val key = next % 2 == 0
      map + (key -> (map.getOrElse(key, Seq()) :+ next))
    }
    //simpler
    seq.foldLeft(Map[Boolean, Seq[Int]]().withDefaultValue(Seq.empty[Int])) { (map, next) ⇒
      val key = next % 2 == 0
      map + ((key, (map(key) :+ next)))
    }

  }
}

