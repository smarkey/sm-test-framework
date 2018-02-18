package com.stevenm

import org.scalatest.{AppendedClues, FlatSpecLike, Inside, Matchers}
import org.scalatest.concurrent.{Eventually, ScalaFutures}

class BjssApiSpec extends FlatSpecLike with Matchers with AppendedClues with Inside with ScalaFutures with Eventually {

  markup {
    """
      |# regres.in API
      |
      | Test your front-end against a real API. A hosted REST-API ready to respond to your AJAX requests.
      |
      |## Create
      |
      |## Read
      |
      |## Update
      |
      |## Delete
      |
    """.stripMargin
  }

  final val behaviour = new BehaviorWord

  behaviour of "reqres.in API"
}
