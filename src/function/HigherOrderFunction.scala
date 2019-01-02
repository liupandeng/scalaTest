package function

import java.util.Date

import function.Currying.midMin

/**
  * 高阶函数：函数作为方法的参数
  */
object HigherOrderFunction  extends App{
  //定义函数
  val power= (x: Int)=>x*x
  val sum: (Int , Int)=>Int = (x,y)=>x+y
  //方法:参数为函数的签名
  def callfunction(f1:Int=>Int,f2:(Int,Int)=>Int,x:Int,y:Int)={
    println(s"power(${y}):"+f1(y))
    println(s"sum(${x},${y}):"+f2(x,y))
  }

  //执行
  callfunction(power,sum,2,3)
}

/**
  * 部分参数应用函数：绑定一些参数，其余参数后续传入
  */
object PartialParameterApplicationFunction extends App {
  //需绑定的参数值：目前时间
  val date1 = new Date()
  //原方法
  def method(d :Date , log:String)={
    println(s"${d}：log:${log}")
  }
  //部分参数应用函数,注意=后面的写法
  val pPAFunction:(String)=>Unit = method(date1,_:String)

  //调用，并执行
  pPAFunction("部分参数应用函数正执行...")

}

/**
  * 柯里化：将两个参数的函数遍变成一个参数的新函数,
  *        新的函数返回一个以原有第二个参数为参数的函数
  * val add=(x:Int,y:Int)=>x+y 变为 val add(x:Int)(y:Int)=x+y
  *
  *
  *   //柯里化演变过程
      //  def minus(a:Int)={
      //    (b:Int)=>a-b
      //  }
      //
      //  val add=(x:Int)=>(y:Int)=>x+y
  */
object Currying extends App {
  //定义有两个参数的方法
//  def minus(a:Int,b:Int):Int={
//     a-b
//  }
//
//  //定义有两个参数的函数
//  def add=(x:Int,y:Int)=>x+y

  //柯里化
  def minus(a:Int)(b:Int)=a-b
  def add(a:Int)(b:Int)=a+b

  //调用执行
   val midMin = minus(9)(2)
  val midAdd = add(3)(2)
  println("柯里化减法："+midMin)
  println("柯里化加法："+midAdd)

  val midMin1 = minus(9)_
  val resMin=midMin1(2)
  val midAdd1 = add(3)_
  val resAdd=midAdd1(2)
  println("柯里化减法："+resMin)
  println("柯里化加法："+resAdd)


}

/**
  * 偏函数：一组case语句，可用于模式匹配
  * Scala中的Partia Function是一个Trait，
  * 其的类型为PartialFunction[A,B]，
  * 其中接收一个类型为A的参数，返回一个类型为B的结果。
  */
object PartialFunction extends App{
  def varpf : PartialFunction[Int,String]={
    case 1=>"one"
    case 2=>"two"
    case _ =>"any"
  }

  def methodpf(num : String)= num match {
    case "one"=>1
    case "two"=>2
    case _=>0
  }

  println(varpf(1))
  println(methodpf("one"))

}


