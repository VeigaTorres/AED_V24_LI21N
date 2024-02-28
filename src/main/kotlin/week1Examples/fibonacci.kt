package week1Examples

/**
 * Calculate the enesim number of the Fibonacci sequence.
 * Fibonacci sequence is defined as follows:
 *    f(0) = 0
 *    f(1) = 1
 *    f( n ) = (f(n-1) + f(n -2) para n > 1
 * @param n the number to calculate the Fibonacci sequence
 */
/**
 * Depth of the recursion: n
 * Complexity:
 *  in terms of time - 2^n (exponecial)
 *  in terms of extra space - n (linear)
 */
fun fibonacciRecursive( n: Int ) : Int  {
    return if(n == 0) 0
           else if ( n== 1 )  1
           else  fibonacciRecursive(n-1)+ fibonacciRecursive( n-2)
}

/**
 * Using memorization
 *  Complexity:
 *  in terms of time - O(n)
 *  in terms of extra space -O(n)
 */
fun fibonacciMemoryN( n:Int ): Int {
    if ( n < 2 ) return n
    val array= Array<Int>(n+1){0} // Extra space n
    array[1]= 1
    for( i in 2 until array.size)
        array[i] = array[i-1] + array[i-2]
    return array[n]
}

/**
 * Complexity:
 *  in terms of time - O(n)
 *  in terms of extra space - O(1)
 */
fun fibonacci( n:Int ): Int  {
   // The dimension of the array is 2 independent of the value of n,
   // then extra space is constant.
   val array = arrayOf( 0, 1 )
   TODO()
   return array[1]
}