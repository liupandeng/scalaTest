class student(var name: String, var age: Int)

object HelloWorld {


  def main(args: Array[String]): Unit = {
    /*   var name = "lpd"
       val age = 18
       println("name:" + name, "age:" + age)
       println(f"$name%s 姓名 $age%d 年龄")
       println(s"$name 姓名 $age 年龄")
       println(s"1+2=${1 + 2}")

       val s = new student("lp", 19)
       println(s"${s.age},${s.name}")

       val i = 13
       var t = if (i > 10) {
         i
         i * i;
         i + 3 ;i+5
       }
       else {
         0;
         2
         100
       }
       println(t)

       val r = if(i<8) i
       println(r)


       var arr = Array(1,2,3,4,5)
       for(ele<-arr)
         println(ele)

       println("until 前闭后开--------")
       for(i<- 0 until arr.length)
         println(arr(i))

       println(" to 前后闭--------")
       for(i<- 0 to arr.length-1)
         println(arr(i))

       println("--打印偶数")
       for(ele<-arr if ele%2==0)
         println(ele)

       println("--双重for循环")
       for(i<-1 to 3 ;j<-2 to 5 )
         print((10*i+j)+" ")

       val r1 =for(ele <-arr if ele%2==0)
         yield ele
       println(r1)

       println("sayHello-----")
       sayHello

       println("sayHello1-----")
       sayHello1

       println("sayHello1-----")
       sayHello1()*/

    println("函数----")
    println(f1(3, 5));
    println(f2(3, 5));
    println(f3(3, 5));


  }

  //方法
  def sayHello = println("hello");

  def sayHello1() = println("hello2");
  //函数
  val f1: (Int, Int) => Int = (a: Int, b: Int) => a * b
  //记住以下两种
  var f2 = (a: Int, b: Int) => a + b
  val f3: (Int, Int) => Int = (a, b) => a * b


}
