package pmislabs.ivanov

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pmislabs.ivanov.ui.theme.LabaTheme
import pmislabs.ivanov.ui.theme.getThemeColor

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            LabaTheme {
                NavHost(navController = navController, startDestination = "home_screen")     //навигация
                {
                    composable("home_screen") {
                        Home_Screen {
                            navController.navigate("about_screen")
                        }
                    }
                    composable("about_screen") {
                        About_Screen()
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Home_Screen(onClick: () -> Unit) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        titleContentColor = getThemeColor().primary,
                        containerColor = getThemeColor().secondary
                    ),
                    title = {
                        Text(
                            text = resources.getString(R.string.app_name),
                            fontSize = 25.sp
                        )
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        onClick()
                    },
                    contentColor = getThemeColor().primary,
                    containerColor = getThemeColor().secondary
                ) {
                    Icon(Icons.Default.Info, contentDescription = "Add")
                }
            }) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .background(getThemeColor().background),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                Text(
                    text = "Этап: Лаба 2. Навигация",
                    modifier = Modifier
                        .padding(60.dp, 10.dp)
                        .fillMaxSize(),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp

                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun About_Screen() {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = getThemeColor().secondary,
                        titleContentColor = getThemeColor().primary,
                    ),
                    title = {
                        Text("О приложении")
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        Toast.makeText(this, "No function for this button", Toast.LENGTH_SHORT)
                            .show()

                    },
                    contentColor = getThemeColor().primary,
                    containerColor = getThemeColor().secondary
                ) {
                    Icon(Icons.Default.CheckCircle, contentDescription = "Back")
                }
            }) { innerPadding ->
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) //адаптивная верстка (для вертикальной версии)
                Column(
                    modifier = Modifier
                        .background(getThemeColor().background)
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Spacer(modifier = Modifier.height(40.dp))
                    Image(
                        painter = painterResource(R.mipmap.ic_launcher_foreground),
                        alignment = Alignment.Center,
                        contentDescription = null,
                        modifier = Modifier
                            .size(230.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterHorizontally)
                            .border(2.dp, getThemeColor().primary, CircleShape)
                            .background(color = getThemeColor().secondary)
                    )
                    Text(
                        modifier = Modifier.padding(all = 15.dp),
                        text = resources.getString(R.string.about_text),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(
                        text = resources.getString(R.string.app_version),
                        modifier = Modifier.padding(60.dp, 10.dp),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.fillMaxHeight())
                }
            else                                                                           //адаптивная верстка (для вертикальной версии)
                Row (
                    modifier = Modifier
                        .background(getThemeColor().background)
                        .padding(innerPadding),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Spacer(modifier = Modifier.height(40.dp))
                    Image(
                        painter = painterResource(R.mipmap.ic_launcher_foreground),
                        alignment = Alignment.Center,
                        contentDescription = null,
                        modifier = Modifier
                            .size(230.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterVertically)
                            .border(2.dp, getThemeColor().primary, CircleShape)
                            .background(color = getThemeColor().secondary)
                    )
                    Column {
                        Spacer(modifier = Modifier.height(50.dp))
                        Text(
                            modifier = Modifier.padding(all = 15.dp),
                            text = resources.getString(R.string.about_text),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(50.dp))
                        Text(
                            text = resources.getString(R.string.app_version),
                            modifier = Modifier.padding(60.dp, 10.dp),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.fillMaxHeight())
                    }
                }
        }

    }


}

