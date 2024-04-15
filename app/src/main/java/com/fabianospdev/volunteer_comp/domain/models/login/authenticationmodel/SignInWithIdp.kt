package com.fabianospdev.volunteer_comp.domain.models.login.authenticationmodel

import com.google.gson.annotations.SerializedName

object SignInWithIdp {
    data class SignInWithIdpRequest(
        @SerializedName("postBody")
        val postBody: String,
        @SerializedName("requestUri")
        val requestUri: String,
        @SerializedName("returnIdpCredential")
        val returnIdpCredential: Boolean,
        @SerializedName("returnSecureToken")
        val returnSecureToken: Boolean
    )

    data class SignInWithIdpResponse(
        @SerializedName("displayName")
        val displayName: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("emailVerified")
        val emailVerified: Boolean,
        @SerializedName("expiresIn")
        val expiresIn: String,
        @SerializedName("federatedId")
        val federatedId: String,
        @SerializedName("firstName")
        val firstName: String,
        @SerializedName("fullName")
        val fullName: String,
        @SerializedName("idToken")
        val idToken: String,
        @SerializedName("lastName")
        val lastName: String,
        @SerializedName("localId")
        val localId: String,
        @SerializedName("oauthIdToken")
        val oauthIdToken: String,
        @SerializedName("photoUrl")
        val photoUrl: String,
        @SerializedName("providerId")
        val providerId: String,
        @SerializedName("rawUserInfo")
        val rawUserInfo: String,
        @SerializedName("refreshToken")
        val refreshToken: String
    )

    val requestMap: Map<String, Class<*>> = mapOf("signInWithIdpRequest" to SignInWithIdpRequest::class.java)

    val responseMap: Map<String, Class<*>> = mapOf("signInWithIdpResponse" to SignInWithIdpResponse::class.java)

    val errorCodeMap: Map<String, AuthErrorCode> = mapOf(
        "EMAIL_NOT_FOUND" to AuthErrorCode.EMAIL_NOT_FOUND,
        "INVALID_PASSWORD" to AuthErrorCode.INVALID_PASSWORD,
        "USER_DISABLED" to AuthErrorCode.USER_DISABLED
    )

    enum class AuthErrorCode(val errorMessage: String) {
        EMAIL_EXISTS("o endereço de e-mail já está sendo usado por outra conta."),
        OPERATION_NOT_ALLOWED("o login por senha está desabilitado para este projeto."),
        TOO_MANY_ATTEMPTS_TRY_LATER("bloqueamos todas as solicitações deste dispositivo devido a atividades incomuns. Tente mais tarde."),
        EMAIL_NOT_FOUND("No user record corresponding to this identifier. The user may have been deleted."),
        INVALID_PASSWORD("The password is invalid or the user does not have a password."),
        USER_DISABLED("The user account has been disabled by an administrator.");


        fun getAuthErrorMessage(): String {
            return errorMessage
        }
    }

    override fun toString(): String {
        return "AuthenticationModel(requestMap=$requestMap, responseMap=$responseMap, errorCodeMap=$errorCodeMap)"
    }
}