package com.nero.upstox.domain

sealed class ResourceData<out T> {
    data class Success<out T>(val data: T) : ResourceData<T>()
    data class Error(val message: String? = null) : ResourceData<Nothing>()
}