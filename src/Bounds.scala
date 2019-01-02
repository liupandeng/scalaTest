import java.util.Comparator

/**
  * 上界
  * @param o1
  * @param o2
  * @tparam T
  */
class Bounds[T<:Comparable[T]](o1:T, o2:T) {
    //比较大小
  def bigger= if (o1.compareTo(o2)>0) o1 else o2


}

/**
  * 视图界定
  * @param o1
  * @param o2
  * @param ev$1
  * @tparam T
  */

class ViewBounds[T<% Comparable[T]](o1:T, o2:T) {
  //比较大小
  def bigger= if (o1.compareTo(o2)>0) o1 else o2
}

/**
  * 上下文界定
  * @param o1
  * @param o2
  * @param ev$1
  * @param comp
  * @tparam T
  */
//class contextBounds[T:Ordering](o1:T,o2:T)(implicit comp: Ordering[T]){
//
//  def bigger = if (comp.compare(o1,o2)>0) o1 else o2
//}

//class contextBounds[T:Ordering](o1:T,o2:T){
//   def inner(implicit comp: Ordering[T]) = comp.compare(o1,o2)
//   def bigger = if (inner>0) o1 else o2
//}

class contextBounds[T:Ordering](o1:T,o2:T){
  def comp = implicitly[Ordering[T]]
  def bigger = if (comp.compare(o1,o2)>0) o1 else o2
}

//class Student(var name:String, var age:Int) extends Ordered[Student]{
//  override def compare(that: Student): Int = that.age - this.age
//
//  override def toString: String = this.name + ","+this.age
//}

class Student(var name:String, var age:Int){
  override def toString: String = this.name + ","+this.age
}

object test extends App{
//  val b =  new Bounds("asd","sad")
//  val c =  new Bounds[Integer](1,2)
//  val d =  new ViewBounds(1,2)
//  val e =  new ViewBounds(3L,2L)
//
//  println(b.bigger)
//  println(c.bigger)
//  println(d.bigger)
//  println(e.bigger)

implicit  val comStu=  new Ordering[Student]{
    override def compare(x: Student, y: Student): Int = x.age - y.age
  }

//  implicit  def comStu1(student:Student)=  new Ordered[Student]{
//    override def compare(that: Student): Int = student.age - that.age
//  }


  val s1 = new Student("lw",23)
  val s2 = new Student("lpd",20)
  val v = new contextBounds(s1,s2)
  println(v.bigger)




}

/**
  * 上下文界定
  * @param weight
  */
class A(val weight: Int)

object ContextBound {


  def max[T: Comparator](a: T, b: T) = {
    val c = implicitly[Comparator[T]]
    if (c.compare(a, b) < 0) b else a
  }

  def main(args: Array[String]) {
    //implicitly查找的是类型为Comparator[T]的隐式值，而不是隐式类型转换函数
    implicit val toComparator = new Comparator[A] {
      override def compare(o1: A, o2: A): Int = o1.weight - o2.weight;
    }
    println(max(new A(300), new A(400)).weight)
  }
}