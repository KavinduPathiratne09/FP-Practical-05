object FibSeq {
    def fibonacci(n: Int): Int = n match {
        case 0 => 0
        case 1 => 1
        case _ => fibonacci(n - 1) + fibonacci(n - 2)
    }

    def fibonacciSeq(n: Int): Unit = {
        if (n > 0) fibonacciSeq(n - 1)
        print(s"${fibonacci(n)}  ")
    }

    def main(args: Array[String]): Unit = {
        print("Enter the number of Fibonacci numbers needed: ")
        val n = scala.io.StdIn.readLine().toInt
        fibonacciSeq(n - 1)
    }
}