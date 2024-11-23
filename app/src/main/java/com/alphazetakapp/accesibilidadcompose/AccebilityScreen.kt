package com.alphazetakapp.accesibilidadcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun AccessibleScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Icono de volver atrás
        IconButton(
            onClick = { /* Acción para regresar */ },
            modifier = Modifier.semantics {
                contentDescription = "Volver atrás"
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Volver atrás"
            )
        }

        // Imagen con descripción
        Image(
            painter = painterResource(id = R.drawable.ic_product_image),
            contentDescription = "Imagen del producto",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        // Título y descripción del producto
        Text(
            text = "Producto de Ejemplo",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.semantics { contentDescription = "Título del producto" }
        )
        Text(
            text = "Este es un producto de ejemplo. Precio: $19.99",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.semantics { contentDescription = "Descripción y precio del producto" }
        )

        // Formulario con etiquetas y botón
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Nombre:", modifier = Modifier.semantics { contentDescription = "Campo para nombre" })
            BasicTextField(
                value = TextFieldValue(),
                onValueChange = { /* actualizar valor */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.Gray),
                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.padding(8.dp)) {
                        innerTextField()
                    }
                }
            )

            Button(
                onClick = { /* Acción al presionar botón */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics { contentDescription = "Botón de acción" }
            ) {
                Text("Enviar")
            }
        }
    }
}