import java.io.Serializable

interface Iterable<out T> {
    operator fun iterator(): Iterator<T>
}
interface Sequence<out T> {
    operator fun iterator(): Iterator<T>
}
//generateSequence(0) { it + 1 }.sorted().take(10).toList()

//fun productionsSortAndProcessingList(): Double {
//    return productsList.sortedBy { it.price }.filter { it.bought}.map {it.price}.average()
//}

//fun productsSortAndProcessingSequence(): Double {
//    return productsList.asSequence().sortedBy { it.price }.filter { it.bought}.map { it.price }.average()
//}
//productsList.asSequence().filter { it.bought }.map { it.price }.average()
//productsList.stream().filter { it.bought }.mapToDouble { it.price }.average().orElse(0.0)

fun <T> random(one: T,two: T,three:T):T = TODO()

fun <K,V> put(key: K,value: V): Unit = TODO()

class Box<T>(t: T) {
    var value = t
}

fun <T : Comparable<T>>min(first: T,second: T):T {
    val k = first.compareTo(second)
    return if (k <= 0) first else second
}

fun <T>minSerializable(first: T,second: T): T
where T : Comparable<T>,T : Serializable{
    val k = first.compareTo(second)
    return if (k <= 0) first else second
}

//class SerializableYear(val value: Int) ; Comparable<SerializableYear>,Serializable {
//    override fun compareTo(other: SerializableYear): Int = this.value.compareTo(other.value)
//}

interface Comparable<in T> {
    operator  fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0)
    val y: Comparable<Double> = x
}

class array<T>(val size: Int) {
    fun get(index: Int): T {TODO()}
    fun set(index: Int, value: T):Nothing {TODO()}
}

fun main(args: Array<String>) {
    val seq = sequenceOf(1,2,3)
    print(seq.filter{it % 2 == 1})

    print(seq.filter{it % 2 == 1}.toList())
    val list = listOf(1,2,3)

    print(list.filter{it % 2 == 1})

    generateSequence(0) { it + 1 }.take(10).sorted().toList()

    val str: String = random("hello","hola","bonjour")
    val any: Any = random("a", 1, false);
    put(0,"value0")

    val box: Box<Int> = Box<Int>(1)

//    val a: Int = min(4, 5)
//    val b: String = min("e","c")
}