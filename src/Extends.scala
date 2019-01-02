trait Swam{
  def swamming(): Unit ={
    println("swaming trait!")
  }
}
abstract class  Animal{
  val leibie:String = "animal"
  def sleep()
  def eat()
}

class Dog extends Animal with Swam {
  override def sleep(): Unit = {
    println("dog is sleeping...")
  }

  override def eat(): Unit = {
    println("dog is eating...")
  }
}
object Extends extends App{
  val d = new Dog();
  d.sleep()
  d.swamming()

  type A= Dog
  val typedog = new A();
  println("---别名")
  typedog.sleep()

}
