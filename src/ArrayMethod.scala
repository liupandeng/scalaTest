import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * 数组的定义
  * map:将某个函数应用到集合中的每个元素并产出其结果的集合 f(x)=y
  * |flatten:把嵌套的结构展开.
  * |flatMap:接收一个可以处理嵌套列表的函数，然后把返回结果连接起来。
  * |foreach:foreach和map相似，只不过它没有返回值，foreach只要是为了对参数进行作用。
  */
object ArrayMethod extends App {
  //定义数组
  val array = Array[Int](3,4,3,5,7,2,1,4,5)
  val fixarray = new Array[Int](4)
  val words = Array("hello world hello scale","good good study")
  //变长数组（数组缓冲）
  val ab = ArrayBuffer[Int]()
  println(ab)
  ab += (1,2,3)
  ab ++= Array(4,5)
  ab ++= ArrayBuffer(6,7)
  ab.insert(1,0,1,2,3)
  ab.remove(2)
  println("---"+ab)

  ab.remove(1,2)
  println(ab)

  //用+=在尾部添加元素
  ab += 2

  //在尾部添加多个元素
  ab += (1,2,3,4,5)

  //通过++=往数组缓冲后面追加集合
  ab ++= Array(6,7,8,9)

  //使用trimEnd(n)移除尾部n个元素
  ab.trimEnd(3)

  //在下标3之前插入元素,下标从0开始
  ab.insert(3, 33)

  //插入多个元素，第一个值为index，后面所有的值为要插入的值
  ab.insert(3,3,4,5,6)

  //移除某个位置的元素
  ab.remove(3)

  //移除从下标为n开始（包括n）的count个元素
  ab.remove(2, 2)


  println(ab)



  //map
  val map  = array.map(_*2);
  println(map.toBuffer)

  val map2  = array.map((_,1));
  println(map2.toBuffer)

  val wordsArr = words.map(_.split(" "))
  //flatten
  println(wordsArr.flatten.toBuffer)
  //flatMap
  val fm = words.flatMap(_.split(" "))
  //foreach
  fm.foreach(x=>print(x+" "))


}

/**
  * seq序列
  * 可变序列
  */
object mutListTest extends App {

  val ab = ListBuffer[Int]()
  println(ab)
  ab += (1,2,3)
  println(ab)

  ab ++= List(4,5)
  println(ab)
  ab ++= ListBuffer(6,7)
  println(ab)
  ab.insert(1,0,1,2,3)
  println("---insert"+ab)
  ab.remove(2)
  println("---remove"+ab)

  ab.remove(1,2)
  println(ab)

}

/**
  * seq序列
  * 不可变序列
  */
object ImmutListTest extends App {
  val arr = List(List(1, 2, 3), List(3, 4, 5), List(2), List(0))

  val list1 = List(1)
  val ss1 = List(2,3)
  println(ss1.par)

  println("list1:"+list1)
  //往list1前面插入一个元素
  val list2 = 0::list1
  val list3 = 0+:list1
  val list4 = list1.::(0)
  val list5 = list1.+:(0)
  println("前面list1:"+list1)
  println("前面list2:"+list2)
  println("前面list2:"+list3)
  println("前面list2:"+list4)
  println("前面list2:"+list5)

  //往list1后面插入一个元素
  val lst2 = list1.:+(0)
  val lst3 = list1:+0
  println("后面lst1:"+list1)
  println("后面lst5:"+lst2)
  println("后面lst5:"+lst3)

  //两个list合并操作
  val lt2 = list1++ss1
  val lt3= list1++:ss1
  val lt4 = list1:+ss1
  val lt5= list1.:::(ss1)

  println("集合lst1:"+list1)
  println("集合lst5:"+lt2)
  println("集合lst5:"+lt3)
  println("集合lst5:"+lt4)
  println("集合lst5:"+lt5)

}

/**
  * map映射
  */
object mapTest extends App {
  val map =  new mutable.HashMap[String,Int]()
  map("spark") =1
  println(map)
  map.put("storm",3)
  map += (("hadoop",2))
  println(map)

  map-="spark"
  println(map)

  val r:Int =map("a")
   val rv:Option[Int] = map.get("d")







}

/**
  * 元祖
  */
object tupleTest extends App {
  val t =(1,"s",true)
  val t1 =  new Tuple1(3)
  println(t._3)
  t.productIterator.foreach((x=>print(x+" ")))
  println()
  println("------")
  val t2 = new Tuple2(2,"t")
  val swap = t2.swap
  swap.productIterator.foreach(println)


}