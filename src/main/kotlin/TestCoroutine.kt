import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking<Unit> {

    launch {
        try {
            coroutineScope {
                launch {
                    delay(Long.MAX_VALUE)
                }
            }
        } catch (ex: CancellationException) {
            println(ex)
        } catch (e: Exception) {
            println(e)
        } finally {

        }
    }
    println("취소")
    delay(1000L)
    coroutineContext[Job]?.cancelChildren()
}