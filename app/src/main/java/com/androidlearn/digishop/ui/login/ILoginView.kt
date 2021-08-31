package com.androidlearn.digishop.ui.login

interface ILoginView<T> {

    fun showProgressBar()
    fun hideProgressBar()
    fun onUsernameError()
    fun onPasswordError()
    fun onSuccess(responseMessage: T)
    fun onFailureError(errorResponseMessage: T)

}