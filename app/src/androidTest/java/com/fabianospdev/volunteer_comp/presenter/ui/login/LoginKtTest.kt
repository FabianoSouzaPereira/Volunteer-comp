import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.fabianospdev.volunteer_comp.presenter.ui.home.Home
import com.fabianospdev.volunteer_comp.presenter.ui.login.Login
import com.fabianospdev.volunteer_comp.presenter.ui.theme.VolunteercompTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testLoginScreen() {
        val navController = TestNavHostController(composeTestRule.activity)
        composeTestRule.setContent {
            val context = composeTestRule.activity.applicationContext
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            VolunteercompTheme {
                // Login(navController = navController, "Login", null, null)
                NavHost(navController, startDestination = "login") {
                    composable("login") {
                        Login(navController, "Login", null, null)
                    }
                    composable("home") {
                        Home(navController = navController, name = "Home", context = context)
                    }
                    composable("settings") {
                        Home(navController = navController, name = "Settings", context = context)
                    }
                }
            }
        }
        Thread.sleep(5000)
        composeTestRule.onNodeWithText("Go to Home").performClick()
    }
}
