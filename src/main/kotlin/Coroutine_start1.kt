import kotlinx.coroutines.*

fun main() =  // Executes in main thread

    // Create a coroutine that blocks the current main Thread
    //Create a coroutine that runs on main thread
    runBlocking {

        println("Main Program start on : ${Thread.currentThread().name}") // main thread

        GlobalScope.launch { // Create a background Coroutine that runs on a background thread

            println("Fake work Start : ${Thread.currentThread().name}") // Thread:T1

            delay(1000) // Coroutine is suspended but thread: T1 is free(not blocked)

            println("Fake work finished : ${Thread.currentThread().name}") //Either T1 or some other thread

        }
        delay(2000) //main thread : wait for coroutine to finish( practically not a right way)


        println("Main Program Ends on : ${Thread.currentThread().name}") // main thread
    }
