package com.murali.sample.controllers


import com.murali.sample.servers.ProductSource
import com.murali.sample.utils.JsonParsers
import javax.inject._
import play.api._
import play.api.libs.json._
import play.api.mvc._

@Singleton
class HomeController @Inject() (cc: ControllerComponents,
                                configuration: Configuration,
                                productSource: ProductSource,
                               ) extends AbstractController(cc) with JsonParsers{



  //get all products default 10 products , can get second page
  def index = Action {implicit request =>
    Ok(getRequest)
  }

  def getRequest (implicit request: Request[_]) = {
     print(s"response from ${request.host}${request.uri}")

    val products = productSource.products
    Json.toJson(products)
   }


  TODO
  //get product by id



  TODO
  //get products by category




}



