package com.project.libs.base

sealed class Result<T>(val isSuccess: Boolean){

    class Success<T>(val data: T): Result<T>(isSuccess = true)

    class Error<T>(val message: String?): Result<T>(isSuccess = false)
}