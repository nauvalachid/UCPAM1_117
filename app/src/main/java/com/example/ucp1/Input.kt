package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ucp1.R
import kotlinx.coroutines.selects.select

@Preview(showBackground = true)
@Composable
fun Input(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var tahunmasuk by remember { mutableStateOf("") }

    var datatahunmasuk= listOf("2020", "2021","2022")
    var confemail by remember { mutableStateOf("") }
    var confnotelepon by remember { mutableStateOf("") }
    var confalamat by remember { mutableStateOf("") }
    var conftahunmasuk by remember { mutableStateOf("") }

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderSection()
        TextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(text = "email")
            },
            placeholder = {
                Text(text = "isi email anda")
            },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = notelepon,
            onValueChange = { notelepon = it },
            label = {
                Text(text = "notelepon")
            },
            placeholder = {
                Text(text = "isi notelepon anda")
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = {
                Text(text = "alamat")
            },
            placeholder = {
                Text(text = "isi alamat anda")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Row (modifier = Modifier.fillMaxWidth()){
            datatahunmasuk.forEach { selectedtahunmasuk ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = tahunmasuk == selectedtahunmasuk, onClick = {
                            tahunmasuk = selectedtahunmasuk
                        })
                    Text(text = selectedtahunmasuk)
                }
            }
        }
        Button(onClick = {
            confemail = email
            confnotelepon = notelepon
            confalamat = alamat
        }) {
            Text(text = "Simpan")
        }
        TampilData(
            parameterName = "email",
            argu = confemail
        )
        TampilData(
            parameterName = "notelepon",
            argu = confnotelepon
        )
        TampilData(
            parameterName = "alamat",
            argu = confalamat
        )
        TampilData(
            parameterName = "tahun",
            argu = conftahunmasuk
        )
    }
}

@Composable
fun TampilData(
    parameterName: String, argu : String
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = parameterName,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = argu,
                modifier = Modifier.weight(2f)
            )
        }
    }
}


@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(30.dp)
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {

                Image(
                    painter = painterResource(id = R.drawable.kmti), contentDescription = "",
                    modifier = Modifier.clip(CircleShape)
                )
                Icon(
                    Icons.Filled.Check,
                    contentDescription = "",
                    modifier = Modifier.size(30.dp).background(Color.Red)
                )
            }
            Column(
                modifier = Modifier.padding(14.dp)
            ) {
                Text(text = "Teknologi Informasi")
                Text(text = "Universitas Muhammadiyah Yogyakarta")
            }
        }
    }
}