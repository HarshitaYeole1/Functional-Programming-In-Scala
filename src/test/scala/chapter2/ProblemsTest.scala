package chapter2

/**
  * Created by harshita on 11/3/17.
  */
import org.scalatest.{FlatSpec, Matchers}

class ProblemsTest extends FlatSpec with Matchers{

  val fibonacci = new Problems()
  "Fibonacci" should "return the nth fibonacci number" in{
    fibonacci.fib(5) should be (5)
  }

  val isSorted = new Problems()
  "isSorted" should "return true if array is sorted according to given comparison function" in {

    isSorted.isSorted(Array(1,2,3,4,5), {(a: Int, b: Int) => a < b }) shouldBe true
    isSorted.isSorted(Array(5,4,3,2), {(a: Int, b: Int) => a < b }) shouldBe false
    isSorted.isSorted(Array(5,4,3,2), {(a: Int, b: Int) => a > b }) shouldBe true
  }

  val compose = new Problems()
  "compose" should "compose two functions" in {
    val f = (x: Int) => 50 - x
    val add = (x: Int) => x + 10
    val sine = compose.compose(add, f)
    println(sine(30))
  }
}
