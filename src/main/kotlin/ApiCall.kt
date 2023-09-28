object ApiCall : CoroutineCaller {

    override suspend fun apiCallMethod(block: suspend () -> Any): Any {
        println("Before api call")
        val result = block()
        println("After api call")
        return result
    }

}

class ApiCallClass : CoroutineCaller {

    override suspend fun apiCallMethod(block: suspend () -> Any): Any {

        return block()
    }

}

data object FourthStage : Stage

