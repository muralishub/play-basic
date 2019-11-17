package com.murali.sample.utils

import com.murali.sample.models.{Product, ProductCategory}
import play.api.libs.functional.syntax.unlift
import play.api.libs.json.{JsPath, Reads, Writes}
import play.api.libs.functional.syntax._

trait JsonParsers {
  implicit val categoryWrites: Writes[ProductCategory] = (
    (JsPath \ "cId").write[Int] and
      (JsPath \ "cName").write[String]
    )(unlift(ProductCategory.unapply))

  implicit val categoryReads: Reads[ProductCategory] =
    (JsPath \ "cId").read[Int].and((JsPath \ "cName").read[String])(ProductCategory.apply _)

  implicit val productWrites: Writes[Product] = (
    (JsPath \ "id").write[String] and
      (JsPath \ "name").write[String] and
      (JsPath \ "category").write[ProductCategory]
    )(unlift(Product.unapply))

  implicit val productReads: Reads[Product] =
    (JsPath \ "id").read[String].and((JsPath \ "name").read[String]).and((JsPath \ "category").read[ProductCategory])(Product.apply _)

}
