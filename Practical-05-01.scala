
object InventoryManagement {

  def getProductList(): List[String] = {
    var productList = List[String]()
    var productName = ""

    while (productName != "done") {
      print("Enter the product name: ")
      productName = scala.io.StdIn.readLine()
      if (productName != "done") {
        productList = productList :+ productName
      }
    }
    productList
  }

  def printProductList(productList: List[String]): Unit = {
    for (n <- productList.indices) {
      println(s"${n + 1} - ${productList(n)}")
    }
  }

  def getTotalProducts(productList: List[String]): Int = {
    val total = productList.length
    total
  }

  def options(optNumber: Int, productList: List[String]): List[String] = {
    optNumber match {
      case 1 =>
        val newProductList = getProductList()
        println("Products entered.")
        newProductList
      case 2 =>
        printProductList(productList)
        productList
      case 3 =>
        val total = getTotalProducts(productList)
        println(s"Total number of products: $total")
        productList
      case 4 =>
        println("Exiting...")
        productList
      case _ =>
        println("Invalid option")
        productList
    }
  }

  def main(args: Array[String]): Unit = {
    var optNumber = 0
    var productList = List[String]()

    while (optNumber != 4) {
      println("Inventory Management System.")
      println("Option 1: Enter Products")
      println("Option 2: Print Products")
      println("Option 3: Total number of products")
      println("Option 4: Exit")
      print("Enter the option number: ")
      optNumber = scala.io.StdIn.readLine().toInt

      productList = options(optNumber, productList)
    }
  }
}
