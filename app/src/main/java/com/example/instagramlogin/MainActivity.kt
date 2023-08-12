package com.example.instagramlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramlogin.ui.theme.InstagramLoginTheme
import com.example.instagramlogin.ui.theme.instagram


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    LoginTitle()
                    Email()
                    Password()
                    button()
                }
            }
        }
    }
}

@Composable
fun LoginTitle(){
    Column(
        modifier = Modifier
            .padding(bottom = 250.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = "Instagram",
            fontFamily = instagram,
            fontSize = 50.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(80.dp))
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(){

    val text = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text.value,
            onValueChange = {
                text.value = it
            },
            label = { Text("Phone number, username or email address", style = TextStyle(color = Color.White))}

        )
        Spacer(modifier = Modifier.height(170.dp))

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(){

    val text = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        var passwordVisibility by remember { mutableStateOf(false) }

        val icon = if (passwordVisibility)
            painterResource(id = R.drawable.visibility)
        else
            painterResource(id = R.drawable.visibility_off)

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text.value,
            onValueChange = {
                text.value = it
            },
            label = { Text("Password", style = TextStyle(color = Color.White))},
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisibility = !passwordVisibility
                    }
                ){
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()

        )
        Row(
            modifier = Modifier.padding(10.dp),
        ){
            Text(
                modifier = Modifier.padding(start = 200.dp),
                text = "forgotten password",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun button(){
    Column(
        modifier = Modifier.padding(top = 180.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            modifier = Modifier.width(375.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimary),
            onClick = {
            },


        ){
            Text(
                text = "Log In",
                color = Color.White
            )

        }

        Divider(
            modifier = Modifier
                .width(width = 375.dp)
                .padding(top = 10.dp),
            color = Color.White,
            thickness = 1.dp
        )
        Text(
            text = "Não tem uma conta? Cadastra-se",
            color = Color.White,

        )


    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InstagramLoginTheme {
        LoginTitle()
        Email()
        Password()
        button()

    }
}

