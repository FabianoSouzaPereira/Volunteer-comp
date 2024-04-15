package com.fabianospdev.volunteer_comp.domain.abstract_repositories

import com.fabianospdev.volunteer_comp.domain.models.login.authenticationmodel.LoggedInUser
import com.fabianospdev.volunteer_comp.domain.models.login.authenticationmodel.SignUpWithPassword

interface AbstractLoginRepository {
    var email: String
    var password: String
    var loggeedInUser: LoggedInUser?
    val isLoogecIn: Boolean

    suspend fun logout(username: String)
    suspend fun login(username: String, password: String, returnSecureToken: Boolean = true): SignUpWithPassword.SignUpResponse
    suspend fun setLoggedInUser(loggedInUser: LoggedInUser)
}