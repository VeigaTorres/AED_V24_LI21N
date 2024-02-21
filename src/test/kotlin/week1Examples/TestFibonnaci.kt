package week1Examples

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestFibonnaci {

    val fibonnaciFunction:(Int)-> Int = ::fibonacciMemoryN
    @Test
    fun testFirsts(){
        assertEquals(0, fibonnaciFunction(0))
        assertEquals(1, fibonnaciFunction(1))
        assertEquals(1, fibonnaciFunction(2))
    }
    @Test
    fun testSmallValues(){
        assertEquals( 377, fibonnaciFunction(14))
        assertEquals( 4181, fibonnaciFunction(19))
    }

/*    @Test
    fun test(){
        fibonnaciFunction( 500000)
    }
 */
}