package ao.co.isptec.aplm.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ao.co.isptec.aplm.helloandroid.ui.theme.HelloAndroidTheme

class MensagemActivity : ComponentActivity() {
    val NULLMENSAGE = "Nehuma Mensagem foi recebida.";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val mensagem = intent.getStringExtra("EXTRA_MENSAGEM")
            ?: NULLMENSAGE;
        val words = mensagem.trim().replace("\\s+".toRegex(), " ").split(" ") ?: listOf();
        val bundle = PalavraBundle(words);
        val summary = gerarResumo(bundle);
        setContent {
            HelloAndroidTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = summary
                        )
                        Button(
                            onClick = {
                                finish();
                            }
                        ) {
                            Text("Voltar");
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    HelloAndroidTheme {
        Greeting2("Android")
    }
}