package week11HashTable

import week9Collection.LinkedCollection
import java.util.TreeSet

fun listTopTen(values: Array<Int> ) {
    val topTen = TreeSet<Int>()
    for( v in values ) {
        if( topTen.size < 10 ) topTen.add(v)
        else {
            val less= topTen.first()
            if ( less < v ) {
                topTen.remove( less )
                topTen.add( v )
            }
        } }
    topTen.forEach{ println(it) }
}

fun wordsThatOcurrMost( list: Collection<String> ):Set<String> {
    val words= HashMap<String, Int>()
    // Contar o número de ocorrências de cada palavra.
    for ( w in list ) {
        var c = words.get( w ) // (1)
        if ( c == null ) c = 0 // (2)
        // (1) e (2) podem ser substituidas por: val c = words.getOrDefault(w, 0);
        words.put( w, c + 1 )
    }
    if ( words.isEmpty() ) return emptySet()
    //Obter a vista correspondente à coleção de contadores.
    val counts = words.values
    val maxOcurr = counts.max()
    // Remover do CONTENTOR ASSOCIATIVO, as palavras que não têm
    // o máximo de ocorrências.
    counts.retainAll( listOf( maxOcurr ) )
    return words.keys
}

fun partition( c: Collection<Int>,
               pred: (Int)-> Boolean): Collection<Int> {
    val result = LinkedCollection<Int>();
    for( element in c )
        if ( pred(element) )
            result.addFirst(element)
        else
            result.addLast( element );
    return result;
}

