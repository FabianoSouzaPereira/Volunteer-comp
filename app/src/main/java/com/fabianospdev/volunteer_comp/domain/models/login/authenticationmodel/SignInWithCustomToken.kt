package com.fabianospdev.volunteer_comp.domain.models.login.authenticationmodel

import com.google.gson.annotations.SerializedName


object SignInWithCustomToken {
    data class SignInWithCustomTokenRequest(
        @SerializedName("returnSecureToken")
        val returnSecureToken: Boolean,
        @SerializedName("token")
        val token: String
    )

    data class SignInWithCustomTokenResponse(
        @SerializedName("expiresIn")
        val expiresIn: String,
        @SerializedName("idToken")
        val idToken: String,
        @SerializedName("refreshToken")
        val refreshToken: String,
        @SerializedName("SignInWithCustomToken")
        val error: Error?
    )

    enum class AuthErrorCode(private val errorMessage: String) {
        EMAIL_NOT_FOUND("No user record corresponding to this identifier. The user may have been deleted."),
        INVALID_PASSWORD("The password is invalid or the user does not have a password."),
        USER_DISABLED("The user account has been disabled by an administrator.");

        fun getAuthErrorMessage(): String {
            return errorMessage
        }
    }

    val requestMap: Map<String, Class<*>> = mapOf("signInWithCustomTokenRequest" to SignInWithCustomTokenRequest::class.java)

    val responseMap: Map<String, Class<*>> = mapOf("signInWithCustomTokenResponse" to SignInWithCustomTokenResponse::class.java)

    val errorCodeMap: Map<String, AuthErrorCode> = mapOf(
        "EMAIL_NOT_FOUND" to AuthErrorCode.EMAIL_NOT_FOUND,
        "INVALID_PASSWORD" to AuthErrorCode.INVALID_PASSWORD,
        "USER_DISABLED" to AuthErrorCode.USER_DISABLED
    )

    override fun toString(): String {
        return "SignUpWithPassword(requestMap=$requestMap, responseMap=$responseMap, errorCodeMap=$errorCodeMap)"
    }
}