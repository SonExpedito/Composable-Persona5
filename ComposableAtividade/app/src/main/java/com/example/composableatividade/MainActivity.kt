package com.example.composableatividade

import android.R
import android.annotation.SuppressLint
import android.icu.text.ListFormatter.Width
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.ExtraBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.core.util.Preconditions
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.Carousel
import androidx.tv.material3.CarouselDefaults
import androidx.tv.material3.CarouselState
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.example.composableatividade.ui.theme.ComposableAtividadeTheme
import java.time.format.TextStyle
import kotlin.math.absoluteValue



class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}




@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun App() {
    ComposableAtividadeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Row {
                Column {

                    SimpleCenterAlignedTopAppBar()



                }
            }



        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview()
fun AppPreview(){
    App()


}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleCenterAlignedTopAppBar() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xC4, 0x0, 0x2, 0xFF)
                ),
                title = {
                    Text(
                        " Home",
                        style = androidx.compose.ui.text.TextStyle(
                            fontWeight = ExtraBold,
                            color = Color(0, 0, 0, 255),
                            fontSize = 30.sp
                            ),


                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            painter = painterResource(id = com.example.composableatividade.R.drawable.icone),
                            contentDescription = "Localized description",
                            tint = Color.Unspecified,


                        )
                    }
                },

            )

        }


        ,content = { innerPadding ->  ProjetoConfig() }

    )
}




@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Banner(

){



        var title = "Phantom Thieves"

        Card( modifier = Modifier
            .height(200.dp)
            .padding(20.dp)
            .background(color = Color.Black)



        ) {

            Box(modifier = Modifier.height(200.dp)

            ){
                Image(painter = painterResource(id = com.example.composableatividade.R.drawable.banner),
                    contentDescription = "Banner",
                    //Mexe com todo container ao redor da imagem
                    modifier = Modifier
                        .fillMaxWidth(),
                    //ContentScale Mexe com as propriedades da Imagem
                    contentScale = ContentScale.FillWidth,
                )

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 350f
                        )

                    )
                ){


                }

                Box(modifier = Modifier
                    .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ){
                    Text(text = title, style = androidx.compose.ui.text.TextStyle(
                        color = Color.White, fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                          shadow = Shadow(
                              color = Color(254, 0, 0, 255),
                              offset = Offset(0f,9f),

                          )  )
                        ,modifier = Modifier.offset(0.dp,6.dp),

                    )

                }

            }





        }

    }


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarrosselImage() {
    val pagerState = rememberPagerState(
        initialPage = 1,
        initialPageOffsetFraction = 0f
    ) {
        4
    }
    val imagens = listOf(
        com.example.composableatividade.R.drawable.metal,
        com.example.composableatividade.R.drawable.joker,
        com.example.composableatividade.R.drawable.sakura,
        com.example.composableatividade.R.drawable.cat
    )

    val distancia = 500.0
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
       Text(text = "Personagens", color = Color(254, 254, 254, 255),
            fontWeight = Bold,
           fontSize = 27.sp,
            style = androidx.compose.ui.text.TextStyle(
                    shadow = Shadow(
                        color = Color(254, 0, 0, 255),
                        offset = Offset(0f,5f),



                    )
            )
       )



    HorizontalPager(state = pagerState, contentPadding = PaddingValues(horizontal = 129.dp),
        modifier = Modifier
            .height(250.dp)
            .padding(4.dp, 0.dp),


            ) { page ->



        Card(
            Modifier
                .height(140.dp)
                .width(100.dp)

                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = (
                            (pagerState.currentPage - page) + pagerState
                                .currentPageOffsetFraction
                            )

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
        ) {
            Box(){
                Image(painter = painterResource(id = imagens[page]), contentDescription ="",
                    contentScale = ContentScale.FillBounds)
            }
        }
    }
    }
}







@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProjetoConfig(){
        Column(
            Modifier
                .background(color = Color(0, 0, 0, 255))
                .fillMaxSize()){


            Box(modifier = Modifier.size(100.dp,46.dp))

            Row  (
                Modifier.background(color = Color(3, 3, 3, 255))
            ){
                Banner()
            }

            Row(){
                ThatsaSimpleText()

            }

            Row (){
                CarrosselImage()
            }

        }

}


@Composable
fun ThatsaSimpleText(){
        Row(modifier = Modifier.padding(vertical = 30.dp)) {
            Box(){
                        Image(painter = painterResource(id = com.example.composableatividade.R.drawable.effet), contentDescription = "Effeito")

                     Column {
                            Box(){
                                Image(painter = painterResource(id = com.example.composableatividade.R.drawable.meuman),
                                contentDescription = "Starboy",
                                modifier = Modifier.size(200.dp)

                                )

                            }
                         }

                    Column(modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .offset(142.dp, 75.dp)

                    ) {
                            Text(text = "Persona 5 é um jogo em que suas decisões possuem impacto, entre no jogo e faça parte dos Phantom Thieves roubando e salvando o coração das pessoas.",
                                style = androidx.compose.ui.text.TextStyle(color = Color(255, 255, 255, 255)

                                ),
                                textAlign = TextAlign.Justify,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .width(200.dp)
                                    .shadow(5.dp)

                                )
                        FilledTonalButton(onClick = { /*TODO*/ },

                                    modifier = Modifier.offset(50.dp)
                                        .border(width = 2.dp,
                                            color = Color(251, 135, 133, 255),
                                            shape = RoundedCornerShape(size = 25.dp)
                                        )
                            ,
                                    colors = androidx.compose.material3.ButtonDefaults.filledTonalButtonColors(Color(
                                        228,
                                        0,
                                        0,
                                        255
                                    ),

                                    )
                            ) {
                                    Icon(painter = painterResource(id = com.example.composableatividade.R.drawable.chibijoker),
                                        contentDescription = "Chibizinho",
                                        tint = Color.Unspecified,
                                        modifier = Modifier.size(34.dp)

                                    )
                                   Text("Se Junte")
                               }

                    }

            }
        }


}




@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun ComponentesPreview(){
    Banner()
}


