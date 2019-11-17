package com.murali.sample.controllers

import com.murali.sample.servers.ProductSource
import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class HomeController @Inject() (cc: ControllerComponents,
                                configuration: Configuration,
                                productSource: ProductSource,
                               ) extends AbstractController(cc){

  def index = Action {implicit request =>
    Ok(getRequest)
  }

  def getRequest (implicit request: Request[_]) = {

    val products = productSource.products

    s"response from ${request.host}" + request.uri + products
  }

}



