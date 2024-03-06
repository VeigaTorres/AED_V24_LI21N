package week1Examples

/**
 * Find the subarray (l,r) in the array that has the maximum sum.
 * @param array the array to be verified
 * @param left the left index of the array
 * @param right the right index of the array
 * @return the Triple (l, r, sum)
 *  Complexity:
 *      in terms of time - O(n^2)
 *      in terms of extra space - O(1)
 */
fun maximumSubArray( array: Array<Double>, left: Int, right:Int ):Triple<Int,Int,Double> {
    if ( left > right ) return Triple(left, right, 0.0)
    var res = Triple(left, left, array[left])
    for( l in left .. right ) {
        var sum = 0.0
        for (r in l..right) {
            sum += array[r]
            if ( sum > res.third)
                res = Triple (l, r, sum)
        }
    }
    return  res
}

/**
 *  Complexity:
 *      in terms of time - O(n)
 *      in terms of extra space - O(1)
 */
fun maximumSubArrayKadane( array: Array<Double>, left: Int, right: Int ):Triple<Int,Int,Double> {
    if ( left > right ) return Triple(left, right, 0.0)
    var res = Triple(left, left, array[left])
    var sum = 0.0
    var l = left
    for (r in left .. right) {
        sum += array[r]
        if ( sum > res.third)
            res = Triple(l, r, sum)
        if ( sum < 0 ) {
            sum = 0.0
            l = r+1
        }
    }
    return res

}