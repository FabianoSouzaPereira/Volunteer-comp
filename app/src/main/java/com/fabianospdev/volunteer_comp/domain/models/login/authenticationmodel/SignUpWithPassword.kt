package com.fabianospdev.volunteer_comp.domain.models.login.authenticationmodel

import com.google.gson.annotations.SerializedName

class SignUpWithPassword {
    data class SignUpRequest(
        @SerializedName("email")
        val email: String,
        @SerializedName("password")
        val password: String,
        @SerializedName("returnSecureToken")
        val returnSecureToken: Boolean?
    )

    data class SignUpResponse(
        @SerializedName("displayName")
        val displayName: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("expiresIn")
        val expiresIn: String,
        @SerializedName("idToken")
        val idToken: String,
        @SerializedName("localId")
        val localId: String,
        @SerializedName("refreshToken")
        val refreshToken: String,
        @SerializedName("registered")
        val registered: Boolean,
        @SerializedName("SignUpWithPassword")
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


    val requestMap: Map<String, Class<*>> = mapOf("signUpRequest" to SignUpRequest::class.java)

    val responseMap: Map<String, Class<*>> = mapOf("signUpResponse" to SignUpResponse::class.java)

    val errorCodeMap: Map<String, AuthErrorCode> = mapOf(
        "EMAIL_NOT_FOUND" to AuthErrorCode.EMAIL_NOT_FOUND,
        "INVALID_PASSWORD" to AuthErrorCode.INVALID_PASSWORD,
        "USER_DISABLED" to AuthErrorCode.USER_DISABLED
    )

    override fun toString(): String {
        return "SignUpWithPassword(requestMap=$requestMap, responseMap=$responseMap, errorCodeMap=$errorCodeMap)"
    }
}