package com.nero.upstox.presentation

sealed class ResourceUI<out T> {
    data class Success<out T>(val data: T) : ResourceUI<T>()
    data class Error(val message: String?) : ResourceUI<Nothing>()
    data object Loading : ResourceUI<Nothing>()
}