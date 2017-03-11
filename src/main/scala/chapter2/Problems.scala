package chapter2

/**
  * Created by harshita on 11/3/17.
  */

import scala.annotation.tailrec

class Problems {

  def fib(i: Int): Int = {
    @tailrec
    def fibonacci(i: Int, prev: Int, cur: Int): Int = i match {
      case 0 => prev
      case 1 => cur
      case _ => fibonacci(i-1, cur, prev+cur)
    }
    fibonacci(i, 0, 1)
  }

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @tailrec
    def check(n: Int): Boolean = {
      if(n >= (as.length - 1)) true
      else if (ordered(as(n), as(n+1))) check(n+1)
      else false
    }
    check(0)
  }

  //converts a function f of two arguments into a function of one argument that partially applies f
  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a,b)
  }

  //Implement uncurry, which reverses the transformation of curry.
  // Note that since => associates to the right, A => (B => C) can be written as A => B => C.
  //...should convert a function of one argument to a function of two arguments
  def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  //  Implement the higher-order function that composes two functions.

  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    a => f(g(a))
  }

}