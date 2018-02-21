package com.stevenm

import com.github.agourlay.cornichon.CornichonFeature
import com.github.agourlay.cornichon.core.FeatureDef

class BjssApiSpec extends CornichonFeature {

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

  def feature: FeatureDef = Feature("Reqres API") {

    Scenario("Create: create user") {

      When I get(s"https://reqres.in/api/users").withParams(
        "name" -> "John Smith",
        "job" -> "Smith"
      )

      Then assert status.is(200)
    }

    Scenario("Read: list users") {

      When I post(s"https://reqres.in/api/users?page=1")

      Then assert status.is(201)
    }

    Scenario("Update: update user") {

      When I put(s"https://reqres.in/api/users/2").withParams(
        "name" -> "John Smith",
        "job" -> "Developer"
      )

      Then assert status.is(200)
    }

    Scenario("Delete: delete user") {

      When I delete(s"https://reqres.in/api/users/2")

      Then assert status.is(204)
    }
  }
}
