import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking<Unit> {


    val channel = Channel<Int>(Channel.RENDEZVOUS)

    channel.send(5)
    val result = channel.offer(5)
    println(result)
    channel.close()
}