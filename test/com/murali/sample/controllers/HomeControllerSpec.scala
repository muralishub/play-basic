package com.murali.sample.controllers

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.murali.sample.servers.ProductSource
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.libs.json.{JsArray, JsLookupResult, JsValue}
import play.api.test.Helpers.{contentType, _}
import play.api.test._
import play.libs.Json

class HomeControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with MockitoSugar {

    implicit val actor = ActorSystem()
    implicit val materializer = ActorMaterializer()


  "HomeController" must {
    "render index page using controller instance" in {
      val controller = new HomeController(stubControllerComponents(),app.configuration, app.injector.instanceOf[ProductSource] )
      val result = controller.index().apply(FakeRequest(GET, "/index"))

      status(result) mustBe(200)
      contentType(result) mustBe(Some("application/json"))
      val count = Json.parse(contentAsString(result)).size

      count must be(7)
    }

    "render index page using inject" in {
      val controller = inject[HomeController]
      val result = controller.index().apply(FakeRequest(GET, "/index"))

      status(result) mustBe(200)

      contentType(result) mustBe(Some("application/json"))
      val count = Json.parse(contentAsString(result)).size

      count must be(7)
    }

    "render index page from the router" in {
      val request = FakeRequest(GET, "/")

      val result = route(app, request).get

      status(result) mustBe(200)

      contentType(result) mustBe(Some("application/json"))
      val count = Json.parse(contentAsString(result)).size
      count must be(7)
    }

  }
}
