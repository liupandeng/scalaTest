import java.io.File

import scala.io.Source

object Implicit extends App{
  //隐式参数(针对方法)，上下文有合适的变量，编译器自动为隐式参数传值
  implicit var count = 1 ;
  def add( a: Int)(implicit b: Int ):Int={
    a+b;
  }
  // 隐式类型转换(针对类型转换)
  implicit def double2Int(d:Double) = d.toInt

  // 隐式类(针对类的转换) - 只能在静态对象中使用
  implicit class RichFile( file:File)  {
    def read = Source.fromFile(file).mkString
  }

 // implicit def file2RichFile(file:File)= new RichFile(file:File)


  val s:Int = 20.6
  println(add(10))
  println(s)

  val file = new File("F:\\mrdata\\order\\input\\练习题.txt")


  println(s"FileContent = ${file.read}")
}

object Test extends App{

 // println(add(10))
}