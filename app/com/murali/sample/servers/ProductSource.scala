package com.murali.sample.servers

import com.murali.sample.models.{Laptop, Pc, Product}

class ProductSource {

  val products = Set(
    Product("1", "Dell laptop", Laptop),
    Product("2", "lenovo laptop", Laptop),
    Product("3", "HP", Pc ),
    Product("4", "Asus", Pc),
    Product("5", "DEll", Pc),
    Product("6", "HP", Pc),
    Product("7", "lenovo", Pc)
  )

  def save(product: Product) = products + product
}
