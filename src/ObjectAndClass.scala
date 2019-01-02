class Student private(var name:String,val age:Int)  {
     private[this] var sex:String =_;
  def this( name:String,  age:Int, sex:String){
    this(name,age)
    this.sex = sex
  }

}

object Student extends App {
  def apply(  ): Unit ={
    println("------空参")
  }
  val s = new Student("lpd",20);
  println("--伴生类"+s.name)
  println(s.age)
  val s1 = new Student("lw",12,"male")
  val s2 = Student();

 // println(s1.sex) //本类可访问
}

object ObjectAndClass {
  def main(args: Array[String]): Unit = {

    //val s = new Student("lpd",20); //本类和伴生类可访问
//    println(s.name)
//    println(s.age)
    val s1 = new Student("lw",12,"male")
  //  println(s1.sex) //本类可访问
    println(s1.age)
  }

}
