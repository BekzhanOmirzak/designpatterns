class AccountRepositoryImpl(
    private val apiService: ApiService
) : CoroutineCaller by ApiCallClass() {

    suspend fun getPersonalInfo(): String {
        return apiCallMethod {
            apiService.getPersonalInfo()
        } as String
    }

}