package week1Examples

/**
 * Calculate the power of a number.
 * @param base the number to be raised
 * @param exponent the exponent
 * @return the number raised to the exponent
 */
/*
 *  Complexity:
 *      in terms of time - O(n)
 *      in terms of extra space - O(1)
 */
fun powerOfIterative(base: Int, exponent: Int ) : Int {
    var res = 1
    for( e in 1 .. exponent)
        res*= base

    return res;
}

/**
 * Depth of the recursion:
 * Complexity:
 *      in terms of time - O(n)
 *      in terms of extra space - O(n)
 */
fun powerOfRecursive(base: Int, exponent: Int ) : Int {
    return if (exponent == 0)  1
           else base *powerOfRecursive(base, exponent - 1)
}

/**
 * Calculate the power as follows:
 *   pow(b, 0) = 1
 *   pow(b, n) = pow(b, n/2)* pow(b, n/2) for n even
 *   pow(b, n) = b * pow(b, n/2)* pow(b, n/2) for n odd * Depth of the recursion:
 * Depth of the recursion: lg n
 * Complexity:
 *      in terms of time - O(n)
 *      in terms of extra space - O(lg n)
 */
fun powerOfN(number: Int, exponent: Int ) : Int  {
    if (exponent == 0 ) return 1
    else if( exponent % 2 == 0 )
        return powerOfN(number, exponent/2)* powerOfN(number, exponent/2)
    else
        return number* powerOfN(number, exponent/2)* powerOfN(number, exponent/2)
}

/**
 * Complexity:
 *      in terms of time - O(lg n)
 *      in terms of extra space - O(lg n)
 */
fun powerOf( number: Int, exponent: Int ) : Int  {
    if (exponent == 0 ) return 1
    else {
        val aux = powerOf(number, exponent / 2)
        if (exponent % 2 == 0)
            return aux * aux
        else
            return number * aux * aux
    }
}