package week1Examples

/*
 * Complexity of the algorithms in this file are:
 *  in terms of time - n (linear)
 *  in terms of extra space - constante (independent of the size of the array)
 */
/**
 * Verify if the array contains the value.
 * @param array the array to be verified
 * @param value the value to be verified
 * @return true if the value is in the array, false otherwise
 */
fun contains( array: Array<Int>, value: Int ): Boolean {
    for(v in array){
        if ( v == value ) return true
    }
    return false
}

/**
 * Find the index of the value in the array.
 * @param array the array to be verified
 * @param value the value to be verified
 * @return the index of the value in the array or -1 if the value is not in the array
 */
fun indexOf( array: Array<Int>, value: Int ): Int {
    for ( i in array.indices ){
        if( array[i] == value) return i
    }
    return -1
}

/**
 * Find the maximum value in the array. The array must not be empty.
 * @param array the array to be verified
 * @return the maximum value in the array
 */
fun max( array: Array<Int> ): Int {
    require(array.isNotEmpty()){"Array empty"}
    var maximum = array[0]
    for( i in 1 until  array.size) {
        if( array[i] > maximum ) maximum = array[i]
    }
    return maximum
}
