package com.androidlearn.digishop.ui.login

import com.androidlearn.digishop.models.BaseModel

class LoginPresenter(var iView: ILoginView<String> , var interactor : LoginInteractor ) : ILoginView<String> {




    fun loginUser( username : String , password : String ) {
        showProgressBar()
        interactor.getLogin(username  , password ,this )

    }

    override fun showProgressBar() {
        iView.showProgressBar();
    }

    override fun hideProgressBar() {
        iView.hideProgressBar()
    }

    override fun onUsernameError() {
        hideProgressBar()
        iView.onUsernameError()
    }

    override fun onPasswordError() {
        hideProgressBar()
        iView.onPasswordError()
    }

    override fun onSuccess(responseMessage: String) {
        hideProgressBar()
        iView.onSuccess(responseMessage)
    }

    override fun onFailureError(errorResponseMessage: String) {
        hideProgressBar()
       iView.onFailureError(errorResponseMessage)
    }


}