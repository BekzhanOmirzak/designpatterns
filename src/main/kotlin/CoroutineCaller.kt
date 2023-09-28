interface CoroutineCaller {

    suspend fun apiCallMethod(block: suspend () -> Any): Any

}