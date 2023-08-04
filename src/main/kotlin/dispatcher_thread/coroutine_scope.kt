package dispatcher_thread

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

fun main(args: Array<String>) :Unit = runBlocking {

    println("runBlocking : $this")

    launch {
        println("launch : $this")

        launch{
            println("Child launch : $this")
        }
    }

    async {
        println("async : $this")
    }

    println("..some other code ..")
}