package com.fabianospdev.volunteer_comp.domain.models.login.authenticationmodel

import com.google.gson.annotations.SerializedName


object SignUpTokenSample {
    data class SignUpTokenSampleRequest(
        @SerializedName("returnSecureToken")
        val returnSecureToken: Boolean
    )

    data class SignUpTokenSampleResponse(
        @SerializedName("email")
        val email: String,
        @SerializedName("expiresIn")
        val expiresIn: String,
        @SerializedName("idToken")
        val idToken: String,
        @SerializedName("localId")
        val localId: String,
        @SerializedName("refreshToken")
        val refreshToken: String
    )

    enum class AuthErrorCode(private val errorMessage: String) {
        EMAIL_NOT_FOUND("No user record corresponding to this identifier. The user may have been deleted."),
        INVALID_PASSWORD("The password is invalid or the user does not have a password."),
        USER_DISABLED("The user account has been disabled by an administrator.");

        fun getAuthErrorMessage(): String {
            return errorMessage
        }
    }

    val requestMap: Map<String, Class<*>> = mapOf("signUpTokenSampleRequest" to SignUpTokenSampleRequest::class.java)

    val responseMap: Map<String, Class<*>> = mapOf("signUpTokenSampleResponse" to SignUpTokenSampleResponse::class.java)

    val errorCodeMap: Map<String, AuthErrorCode> = mapOf(
        "EMAIL_NOT_FOUND" to AuthErrorCode.EMAIL_NOT_FOUND,
        "INVALID_PASSWORD" to AuthErrorCode.INVALID_PASSWORD,
        "USER_DISABLED" to AuthErrorCode.USER_DISABLED
    )

    override fun toString(): String {
        return " SignUpTokenSample(requestMap=$requestMap, responseMap=$responseMap, errorCodeMap=$errorCodeMap)"
    }
}