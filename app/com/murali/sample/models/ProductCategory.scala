package com.murali.sample.models

sealed trait ProductCategory {
  def cId: Int
  def cName: String
}

case object Pc extends ProductCategory {
  val cId = 1
  val cName = "PC"
}
case object Laptop extends ProductCategory {
  val cId = 2
  val cName = "Laptop"
}


object ProductCategory {
  def apply(id: Int, name: String): ProductCategory = ProductCategory(id, name)
  def unapply(category: ProductCategory) = Some((category.cId, category.cName))
}
