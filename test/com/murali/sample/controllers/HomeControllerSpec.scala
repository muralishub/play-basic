package com.murali.sample.controllers

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test.Helpers._
import play.api.test._

class HomeControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  implicit val actor = ActorSystem()
  implicit val materializer = ActorMaterializer()


  "HomeController" must {
    "render index page using controller instance" in {


      val controller = new HomeController(stubControllerComponents(),app.configuration)
      val result = controller.index().apply(FakeRequest(GET, "/index"))

      status(result) mustBe(200)
      contentType(result) mustBe(Some("text/plain"))
      contentAsString(result) must include("index")

    }

    "render index page using inject" in {
      val controller = inject[HomeController]
      val result = controller.index().apply(FakeRequest(GET, "/index"))

      status(result) mustBe(200)
      contentType(result) mustBe(Some("text/plain"))
      contentAsString(result) must include("index")
    }

    "render index page from the router" in {
      val request = FakeRequest(GET, "/index")

      val result = route(app, request).get

      status(result) mustBe(200)
      contentType(result) mustBe(Some("text/plain"))
      contentAsString(result) must include("index")
    }

  }
}
