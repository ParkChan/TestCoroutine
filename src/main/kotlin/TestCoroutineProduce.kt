import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking<Unit> {


    val integers = generateInt()
    val sqaures = generateSquare(integers)

    repeat(5) {
        println(sqaures.receive())
    }

    coroutineContext.cancelChildren()
}

fun CoroutineScope.generateInt() = produce<Int> {
    var value = 0
    while(true)
        this.send(++value)
}
fun CoroutineScope.generateSquare(integers : ReceiveChannel<Int>) = produce<Int> {
    for(i in integers) {
        this.send(i*i)
    }
}