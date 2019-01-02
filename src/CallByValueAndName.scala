/**
  * 传值调用和传名调用
  * 变量名和变量类型使用 => 符号来设置传名调用
  */
object CallByValueAndName extends App {
  var money = 100

  def cost(): Int = {
    money = money - 10
    money
  }

  def count(): Int = {
    cost
    money
  }


  def printlnByValue(x: Int) = {
    for (i <- 0 to 3)
      println(s"----传值： ${x}")
  }

  def printlnByName(x: => Int) = {
    for (i <- 0 to 3)
      println(s"----传名：${x}")
  }

  def printlnByName1(x:() => Int) = {
    for (i <- 0 to 3){
      println("参数： " + x)
      println(s"传名1：${x}")
    }

  }

  printlnByName(count)
  printlnByName1(count)
  printlnByValue(count)


}
