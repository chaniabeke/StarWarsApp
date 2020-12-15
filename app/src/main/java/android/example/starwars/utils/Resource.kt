package android.example.starwars.utils

/**
 * A generic class that return a Resource object based on the status
 * @param status (enum)
 * @param data data object
 * @param message string with error message
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object{

        fun<T> success(data: T): Resource<T>{
            return  Resource(Status.SUCCESS, data, null)
        }

        fun<T> error(message: String? ,data: T? = null): Resource<T>{
            return  Resource(Status.ERROR, data, message)
        }

        fun<T> loading(data: T?=null): Resource<T>{
            return  Resource(Status.LOADING, data, null)
        }

    }
}