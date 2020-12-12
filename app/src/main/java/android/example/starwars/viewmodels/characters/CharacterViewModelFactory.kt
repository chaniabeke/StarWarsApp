package android.example.starwars.viewmodels.characters

/**class CharacterViewModelFactory(
    private val apiService : StarWarsApiService
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharactersViewModel::class.java)) {
            return CharactersViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}*/