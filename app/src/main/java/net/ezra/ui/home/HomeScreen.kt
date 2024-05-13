package net.ezra.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.database.collection.LLRBNode
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_VIEW_PROD
import net.ezra.R
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_SEARCH
import net.ezra.navigation.ROUTE_SIGNUP
import net.ezra.navigation.ROUTE_VIEW_STUDENTS


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }
    var showMenu by remember { mutableStateOf(false) }
    val mContext = LocalContext.current

    LaunchedEffect(Unit) {
        // Show the dialog after a delay of 2 seconds
        delay(2000)
        showDialog = true
    }

    if (showDialog) {
        Column (){
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.img_2),
                contentDescription = ""
            )
        }
        AlertDialog(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(16.dp)) ,
            onDismissRequest = { showDialog = false },
            title = { Text(" Yamral") },
            text = {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.img_2),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        contentScale = ContentScale.Crop
                    )

                }
            } ,
            confirmButton = {
                Button(
                    onClick = {
                        // Dismiss the dialog
                        showDialog = false
                    } , modifier = Modifier .background(Color.Transparent),

                ) {
Icon(imageVector =Icons.Default.Clear , contentDescription ="" , tint = Color.White)
                }

            }
        )
    }
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val context = LocalContext.current.applicationContext
    val selectcted = remember {
        mutableStateOf(Icons.Default.Home)

    }
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT,"")
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)





    Icon(

        imageVector = Icons.Default.KeyboardArrowRight, contentDescription = ""
    )
    ModalNavigationDrawer(

        gesturesEnabled = true,
        drawerContent = {

            ModalDrawerSheet {

                Box(
                    modifier = Modifier
                        .background(color = Color.Red)
                        .fillMaxWidth()
                        .height(200.dp),

                    )
                {


                    Text(text = "")
                    androidx.compose.foundation.Image(
                        painter = painterResource(id = R.drawable.l),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth, modifier = Modifier
                            .fillMaxWidth()
                            .size(200.dp)

                    )

                }
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xffddadaf))) {

                    Column {
                        Spacer(modifier = Modifier.height(10.dp))

                        Divider()
                        NavigationDrawerItem(label = { Text(text = "Add product") },
                            selected = false,
                            onClick = {
                                navController.navigate(ROUTE_ADD_PRODUCT) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }

                                }


                            })
                        Spacer(modifier = Modifier.height(10.dp))
                        Divider()
                        NavigationDrawerItem(label = { Text(text = "Contacts") },
                            selected = false, onClick = {
                                navController.navigate(ROUTE_DASHBOARD) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            })
                        Spacer(modifier = Modifier.height(10.dp))
                        Divider()
                        NavigationDrawerItem(label = { Text(text = "About") },
                            selected = false, onClick = {
                                navController.navigate(ROUTE_ABOUT) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            })



                    }

                }
            }
        },

    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Yamral Fashion ") },
                    backgroundColor = Color(0XFF),

//                        , Color =  TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent )

                    elevation = 0.dp,
                    actions = {

                        IconButton(
                            onClick = { showMenu = !showMenu },
                            modifier = Modifier.background(Color.Transparent)
                        ) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "",)
                            //                            )
                        }
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ) {
                            DropdownMenuItem(onClick = {    val shareIntent=Intent(Intent.ACTION_SEND)
                                shareIntent.type="text/plain"
                                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://www.yamralfashion.com/")
                                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
                            }) {
                                Icon(imageVector = Icons.Filled.Share, contentDescription = "")
                            }
                            DropdownMenuItem(onClick = {    val simToolKitLaunchIntent =
                                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                            }) {
                                Icon(imageVector = Icons.Filled.Send, contentDescription = "")

                            }
                        }
                    }


                )
            },


            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }

                    }, backgroundColor = Color(0xffbc8f8f),
                    contentColor = Color.White
                )
                {

                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = null,
                        tint = Color.White
                    )

                }


            }

        )

        {

            Box {
                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Column(


                    modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally


                ) {




                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxSize()
                            .horizontalScroll(state = ScrollState(2)),


                    ) {

                        Button(
                            onClick = {
                                navController.navigate(ROUTE_VIEW_PROD) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            },

                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.outlinedButtonColors(Color(0xffC77A43)),
                            border = BorderStroke(1.5.dp, Color.Transparent),
                            contentPadding = PaddingValues(15.dp),
                            modifier = Modifier
                                .height(50.dp)
                                .width(150.dp)
                        ) {
                            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")

                            Text("shop", color = Color.White)
                        }

                    }
                Spacer(modifier = Modifier.height(10.dp))



                        Text(
                            text = "YAMRAL FASHION STORE",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                                color = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            textAlign = TextAlign.Center,

                            )

                FloatingActionButton(
                    onClick = { }, backgroundColor = Color(0xffbc8f8f),
                    contentColor = Color.White
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "",
                    )

                }


//                        Card(
//                            modifier = Modifier
//                                .background(Color.Black)
//                                .size(width = 100.dp, height = 50.dp)
//
//
//                        ) {
////                            Text(
//                                modifier = Modifier
//
//                                    .clickable {
//                                        navController.navigate(ROUTE_VIEW_PROD) {
//                                            popUpTo(ROUTE_HOME) { inclusive = true }
//                                        }
//                                    },
//                                text = "shop",
//                                textAlign = TextAlign.Center,
//                                fontSize = 20.sp,
//                                color = MaterialTheme.colorScheme.onSurface
//                            )
//                        }
//                    }

//
//                    Text(
//                        text = stringResource(id = R.string.developer),
//                        fontSize = 20.sp,
//                    )
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_LOGIN) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Login Here",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )


//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_ADD_PRODUCT) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Add Products",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
            }


//Card (
//    modifier=Modifier
//        .fillMaxSize()
//        ,
//    shape = RoundedCornerShape(15.dp),
////    elevation =5.dp
//
//){
//    Box  (modifier = Modifier.height(200.dp)){
//        androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.splash),
//            contentDescription ="",
////            contentScale =contentScale.Crop
//            )
//        Text(text = )

        }

    }


//


//    }
//
//
//
//    }
//


//    Column() {
//        Row {


//            Scaffold(
//                topBar =
//                {
//                    TopAppBar(title = { Text(text = "") })
//
//                    IconButton(onClick = { }) {
//                        Icon(imageVector = Icons.Default.Menu, contentDescription = "")
//
//
//                    }
//
//                },
//
//
//
//
//                bottomBar = {
//                    BottomAppBar {
//                        Text(text = "")
//                    }
//
//                },
//                floatingActionButton = {
//                    FloatingActionButton(onClick = {  }) {
//                     Icon(imageVector = Icons.Filled.Home, contentDescription ="" )
//
//                    }
//                }
//
//            ) {
//                Column(modifier=Modifier
//                    ) {
//                    Text(text = "body")
//
//                }
//            }
//
//
//
//                }


//        }
//
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight()
//                .padding(10.dp)
//                .padding(top = 10.dp)
//
//        ) {
//            Text(text = stringResource(id = R.string.mit))
//            Text(text = "this is the homepage")
//
//            Text(
//                modifier = Modifier
//                    .clickable {
//                        navController.navigate(ROUTE_ABOUT) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }
//                    },
//                text = "about"
//            )
//
//            Button(onClick = {
//                navController.navigate(ROUTE_ABOUT) {
//                    popUpTo(ROUTE_HOME) { inclusive = true }
//                }
//            }) {
//
//                Text(text = "sketchy about")
//
//            }
//
//            Text(
//                modifier = Modifier
//                    .clickable {
//                        navController.navigate(ROUTE_CONTACT) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }
//                    },
//                text = "Contact"
//            )
//
//            Card(
//                colors = CardDefaults.cardColors(Color(0xffE52C04)),
//                elevation = CardDefaults.cardElevation(5.dp)
//
//            ) {
//
//
//            }
//
//
//            Text(
//                modifier = Modifier
//                    .clickable {
//                        navController.navigate(ROUTE_PRODUCTS) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }
//                    },
//                text = "go to products screen"
//
//            )
//
//            Button(onClick = {
//                navController.navigate(ROUTE_MIT) {
//                    popUpTo(ROUTE_HOME) { inclusive = true }
//                }
//            }) {
//
//                Text(text = "fuurye")
//
//            }
//
//            Text(
//                modifier = Modifier
//
//                    .clickable {
//                        navController.navigate(ROUTE_MIT) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }
//                    },
//                text = "go to mit",
//                textAlign = TextAlign.Center,
//                color = MaterialTheme.colorScheme.onSurface
//            )
//
//            Text(
//                modifier = Modifier
//                    .clickable {
//                        navController.navigate(ROUTE_SHOP) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }
//                    },
//                text = "go to shop screen",
//                textAlign = TextAlign.Center,
//                color = MaterialTheme.colorScheme.onSurface
//            )
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//
//
//            OutlinedButton(onClick = {
//
//                navController.navigate(ROUTE_ADD_STUDENTS) {
//                    popUpTo(ROUTE_HOME) { inclusive = true }
//                }
//
//            }) {
//
//                Text(text = "Add Students")
//
//            }
//
//
//        }
//
//    }
//}
}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    HomeScreen(rememberNavController())
}















//package net.ezra.ui.home
//
//import android.annotation.SuppressLint
//import android.media.Image
//import android.provider.ContactsContract.CommonDataKinds.Im
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.ScrollState
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.horizontalScroll
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.AlertDialog
//import androidx.compose.material.Divider
//import androidx.compose.material.DropdownMenu
//import androidx.compose.material.DropdownMenuItem
//import androidx.compose.material.FloatingActionButton
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Surface
//import androidx.compose.material.TopAppBar
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowForward
//import androidx.compose.material.icons.filled.Call
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material.icons.filled.MoreVert
//import androidx.compose.material.icons.filled.Refresh
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.DrawerState
//import androidx.compose.material3.DrawerValue
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.ModalDrawerSheet
//import androidx.compose.material3.ModalNavigationDrawer
//import androidx.compose.material3.NavigationDrawerItem
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.Text
//import androidx.compose.material3.rememberDrawerState
//import androidx.compose.material3.rememberModalBottomSheetState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavGraph
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import kotlinx.coroutines.coroutineScope
//import kotlinx.coroutines.delay
//import net.ezra.navigation.ROUTE_ABOUT
//import net.ezra.navigation.ROUTE_HOME
//
//import net.ezra.R
//import net.ezra.navigation.ROUTE_ADD_PRODUCT
//import net.ezra.navigation.ROUTE_ADD_STUDENTS
//import net.ezra.navigation.ROUTE_LOGIN
//import net.ezra.navigation.ROUTE_SIGNUP
//import net.ezra.navigation.ROUTE_VIEW_PROD
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun HomeScreen(navController: NavHostController) {
//    var showDialog by remember { mutableStateOf(false) }
//    var showMenu by remember { mutableStateOf(false)}
//
//    LaunchedEffect(Unit) {
//        // Show the dialog after a delay of 2 seconds
//        delay(2000)
//        showDialog = true
//    }
//
//    if (showDialog) {
//        AlertDialog(
//            modifier = Modifier .
//            background(Color.Gray),
//            onDismissRequest = { showDialog = false },
//            title = { Text(" Yamral") },
//            text = { Text("welcome") },
//            confirmButton = {
//                Button(
//                    onClick = {
//                        // Dismiss the dialog
//                        showDialog = false
//                    }
//                ) {
//                    Text(
//                        modifier = Modifier
//                            .background(Color.Black)
//
//                            .clickable {
//                                navController.navigate(ROUTE_LOGIN) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//
//                        text = "LOGIN")
//                }
//                Spacer(modifier = Modifier.height(30.dp))
//                Button(modifier = Modifier.background(Color.Black),
//                    onClick = {
//                        // Dismiss the dialog
//                        showDialog = false
//                    }
//                ) {
//                    Text(
//                        modifier = Modifier
//                            .background(Color.Black)
//
//                            .clickable {
//                                navController.navigate(ROUTE_SIGNUP) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//
//                        text = "SIGNUP")
//                }
//            }
//        )
//    }
//    val navigationController = rememberNavController()
//    val coroutineScope = rememberCoroutineScope()
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
//    val context = LocalContext.current.applicationContext
//    val selectcted = remember {
//        mutableStateOf(Icons.Default.Home)
//    }
//
//    ModalNavigationDrawer(
//
//        gesturesEnabled = true,
//        drawerContent = {
//            ModalDrawerSheet {
//
//                Box(
//                    modifier = Modifier
//                        .background(color = Color.Red)
//                        .fillMaxWidth()
//                        .height(200.dp),
//
//                    )
//                {
//
//                    Text(text = "")
//                    androidx.compose.foundation.Image(
//                        painter = painterResource(id = R.drawable.l),
//                        contentDescription = "",
//                        contentScale = ContentScale.FillWidth, modifier = Modifier
//                            .fillMaxWidth()
//                            .size(200.dp)
//
//                    )
//
//                }
//
//
//
//                Divider()
//                NavigationDrawerItem(label = { Text(text = "About") },
//                    selected = false,
//                    onClick = {
//                        navController.navigate(ROUTE_ABOUT) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//
//                        }
//                    })
//                Divider()
//                NavigationDrawerItem(label = { Text(text = "sketchy about") },
//                    selected = false, onClick = {
//                        navController.navigate(ROUTE_ABOUT) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }
//                    })
//                Divider()
//                NavigationDrawerItem(label = { Text(text = "add students") },
//                    selected = false, onClick = {
//                        navController.navigate(ROUTE_ADD_STUDENTS) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }
//                    })
//
//
//
//            }
//
//
//        },
//    ) {
//        Scaffold(
//            topBar = {
////                TopAppBar(
////                    title = { Text("Title") },
////                    actions = {
////
////                        IconButton(onClick = { showMenu = !showMenu }) {
////                            Icon(imageVector = Icons.Default.MoreVert, contentDescription ="" )
////                        }
////                        DropdownMenu(
////                            expanded = showMenu,
////                            onDismissRequest = { showMenu = false }
////                        ) {
////                            DropdownMenuItem(onClick = { /*TODO*/ }) {
////                                Icon(imageVector =Icons.Filled.Refresh , contentDescription ="" )
////                            }
////
////                            DropdownMenuItem(onClick = {  }) {
////                                Icon(imageVector = Icons.Filled.Call, contentDescription = "")
////                            }
////                        }
////                    }
////
////
////
////
////                )
////            },
//
//
//                TopAppBar(title = { Text(text = "") })
//
//                IconButton(onClick = {
//
//                }) {
//                    Icon(
//                        imageVector = Icons.Default.ArrowForward, contentDescription = ""
//                    )
//
//
//                }
//
//            },
//
//
////            bottomBar = {
////                BottomAppBar(
////                    modifier = Modifier
////
////
////                ) {
////
////                    Button(
////                        onClick = {
////                            navController.navigate(ROUTE_LOGIN) {
////                                popUpTo(ROUTE_HOME) { inclusive = true }
////                            }
////                        },
////                        shape = RoundedCornerShape(10.dp),
////                        colors = ButtonDefaults.outlinedButtonColors(Color(0xffC77A43)),
////                        border = BorderStroke(1.5.dp, Color.Transparent),
////                        contentPadding = PaddingValues(15.dp),
////                        modifier = Modifier
////                            .height(50.dp)
////                            .width(500.dp)
////
////                    ) {
////                        Text("LOGIN- EXPLORE YOUR STYLE", color = Color.White)
////                    }
////
////
////                    Spacer(modifier = Modifier.width(0.dp))
////                    Button(
////                        onClick = {
////                            navController.navigate(ROUTE_SIGNUP) {
////                                popUpTo(ROUTE_HOME) { inclusive = true }
////                            }
////                        },
////                        shape = RoundedCornerShape(10.dp),
////                        colors = ButtonDefaults.outlinedButtonColors(Color(0xffC77A43)),
////                        border = BorderStroke(1.5.dp, Color.Transparent),
////                        contentPadding = PaddingValues(15.dp),
////                        modifier = Modifier
////                            .height(50.dp)
////                            .width(500.dp)
////
////                    ) {
////                        Text("CREAT AN ACCOUNT", color = Color.White)
////                    }
////
////                }
////            },
////            floatingActionButton = {
////                FloatingActionButton(
////                        onClick = {
////                            navController.navigate(ROUTE_LOGIN) {
////                                popUpTo(ROUTE_HOME) { inclusive = true }
////                            }
////                        },
////                shape = RoundedCornerShape(10.dp),
//////                colors = ButtonDefaults,
//////                border = BorderStroke(1.5.dp, Color.Transparent),
//////                contentPadding = PaddingValues(15.dp),
////                modifier = Modifier
////                    .height(100.dp)
////                    .width(150.dp)
////
////                ) {
////                Text(" LOGIN- EXPLORE YOUR STYLE ", color = Color.White)
////            }
////
////                Spacer(modifier = Modifier.width(20.dp))
////
////                Button(
////                    onClick = {
////                        navController.navigate(ROUTE_VIEW_PROD) {
////                            popUpTo(ROUTE_HOME) { inclusive = true }
////                        }
////                    },
////                    shape = RoundedCornerShape(10.dp),
////                    colors = ButtonDefaults.outlinedButtonColors(Color(0xffC77A43)),
////                    border = BorderStroke(1.5.dp, Color.Transparent),
////                    contentPadding = PaddingValues(15.dp),
////                    modifier = Modifier
////                        .height(50.dp)
////                        .width(150.dp)
////
////                ) {
////                    Text(" CREAT AN ACCOUNT  ", color = Color.White)
////                }
//
////            }
////
////
////        )
//        {
//            Box {
//
//
//                androidx.compose.foundation.Image(
//                    painter = painterResource(id = R.drawable.img_1),
//                    contentDescription = "",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize())}
//            Column(
////                modifier = Modifier
////                    .fillMaxSize()
////                    .background(color = Color(0xff8f341e))
//                modifier = Modifier
//                    .size(width = 450.dp, height = 150.dp)
//
//            ) {    Spacer(modifier = Modifier.height(50.dp))
//
//
//                Row(
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .horizontalScroll(state = ScrollState(2))
//
//                ) {
//
//                    Button(
//                        onClick = {
//                            navController.navigate(ROUTE_ADD_PRODUCT) {
//                                popUpTo(ROUTE_HOME) { inclusive = true }
//                            }
//                        },
//                        shape = RoundedCornerShape(10.dp),
//                        colors = ButtonDefaults.outlinedButtonColors(Color(0xffC77A43)),
//                        border = BorderStroke(1.5.dp, Color.Transparent),
//                        contentPadding = PaddingValues(15.dp),
//                        modifier = Modifier
//                            .height(50.dp)
//                            .width(150.dp)
//                    ) {
//                        Text("Add Product", color = Color.White)
//                    }
//
//                    Spacer(modifier = Modifier.width(50.dp))
//
//                    Button(
//                        onClick = {
//                            navController.navigate(ROUTE_VIEW_PROD) {
//                                popUpTo(ROUTE_HOME) { inclusive = true }
//                            }
//                        },
//                        shape = RoundedCornerShape(10.dp),
//                        colors = ButtonDefaults.outlinedButtonColors(Color(0xffC77A43)),
//                        border = BorderStroke(1.5.dp, Color.Transparent),
//                        contentPadding = PaddingValues(15.dp),
//                        modifier = Modifier
//                            .height(50.dp)
//                            .width(150.dp)
//
//                    ) {
//                        Text("shop", color = Color.White)
//                    }
//
//
////
//                }}}})
//
////Spacer(modifier =Modifier.height(30.dp) )
////                        Card(
////                            modifier = Modifier
////                                .background(Color.DarkGray)
////                                .fillMaxWidth()
////                                .height(80.dp)
////                                .padding(all = 16.dp),
////
////                        ) {
////                            Text(text = "Card 1")
////                        }
////                        Card(
////                            modifier = Modifier
////                                .background(Color.DarkGray)
////                                .fillMaxWidth()
////                                .height(80.dp)
////                                .padding(all = 16.dp),
////
////                        ) {
////                            Text(text = "Card 2")
////                        }
////                Row(
////                    modifier = Modifier.fillMaxWidth()
////                ) {
////                    Button(
////                        onClick = {},
////                        modifier = Modifier.padding(horizontal = 8.dp)
////                    ) {
////                        Text(text = "Button 1")
////                    }
////                    Button(
////                        onClick = {},
////                        modifier = Modifier.padding(horizontal = 8.dp)
////                    ) {
////                        Text(text = "Button 3")
////                    }
////                    Button(
////                        onClick = {},
////                        modifier = Modifier.padding(horizontal = 8.dp)
////                    ) {
////                        Text(text = "Button 2")
////                    }
////                }
//            }
//
//
////                            Card(modifier = Modifier
////                                .background(Color.DarkGray)
////                                .size(width = 500.dp, height = 98.dp),
////                                onClick = {
////                                    navController.navigate(ROUTE_ABOUT) {
////                                        popUpTo(ROUTE_HOME) { inclusive = true }
////                                    }
////                                }) {
////                                Image(
////                                    painter = painterResource(id = R.drawable.img),
////                                    contentDescription = "Nusa Penida",
////                                    modifier = Modifier
////                                        .size(50.dp),
////                                )
////                                Text(text = "Running 7 days", textAlign = TextAlign.Justify, color = Color.White)
////
////
////                            }
////                        }
//
////                        Spacer(modifier = Modifier.height(2500.dp))
//
////                        Row(
////                            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
////                            modifier = Modifier
////                                .fillMaxSize()
////                       ) {
////                            Text(text = "Workout Programs", color = Color.White, textAlign = TextAlign.Left)
////
////                            Text(text = "See All", color = Color.Green, textAlign = TextAlign.End)
////                        }
////
//
////                    Button(
////                        onClick = {
////                            navController.navigate(ROUTE_LOGIN) {
////                                popUpTo(ROUTE_HOME) { inclusive = true }
////                            }
////                        },
////                        shape = RoundedCornerShape(10.dp),
////                        colors = ButtonDefaults.outlinedButtonColors(Color(0xffC77A43)),
////                        border = BorderStroke(1.5.dp, Color.Transparent),
////                        contentPadding = PaddingValues(15.dp),
////                        modifier = Modifier
////                            .height(50.dp)
////                            .width(500.dp)
////
////                    ) {
////                        Text("LOGIN- EXPLORE YOUR STYLE", color = Color.White)
////                    }
////                    Spacer(modifier = Modifier.width(20.dp))
////
////                    Button(
////                        onClick = {
////                            navController.navigate(ROUTE_SIGNUP) {
////                                popUpTo(ROUTE_HOME) { inclusive = true }
////                            }
////                        },
////                        shape = RoundedCornerShape(10.dp),
////                        colors = ButtonDefaults.outlinedButtonColors(Color(0xffC77A43)),
////                        border = BorderStroke(1.5.dp, Color.Transparent),
////                        contentPadding = PaddingValues(15.dp),
////                        modifier = Modifier
////                            .height(50.dp)
////                            .width(500.dp)
////
////                    ) {
////                        Text("CREAT AN ACCOUNT", color = Color.White)
////                    }
//
//
//
//
//
////Card (
////    modifier=Modifier
////        .fillMaxSize()
////        ,
////    shape = RoundedCornerShape(15.dp),
//////    elevation =5.dp
////
////){
////    Box  (modifier = Modifier.height(200.dp)){
////        androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.splash),
////            contentDescription ="",
//////            contentScale =contentScale.Crop
////            )
////        Text(text = )
//
//                }
//
//
////
//
//
////    }
////
////
////
////    }
////
//
//
//
//
////    Column() {
////        Row {
//
//
////            Scaffold(
////                topBar =
////                {
////                    TopAppBar(title = { Text(text = "") })
////
////                    IconButton(onClick = { }) {
////                        Icon(imageVector = Icons.Default.Menu, contentDescription = "")
////
////
////                    }
////
////                },
////
////
////
////
////                bottomBar = {
////                    BottomAppBar {
////                        Text(text = "")
////                    }
////
////                },
////                floatingActionButton = {
////                    FloatingActionButton(onClick = {  }) {
////                     Icon(imageVector = Icons.Filled.Home, contentDescription ="" )
////
////                    }
////                }
////
////            ) {
////                Column(modifier=Modifier
////                    ) {
////                    Text(text = "body")
////
////                }
////            }
////
////
////
////                }
//
//
////        }
////
////        Column(
////            modifier = Modifier
////                .fillMaxWidth()
////                .wrapContentHeight()
////                .padding(10.dp)
////                .padding(top = 10.dp)
////
////        ) {
////            Text(text = stringResource(id = R.string.mit))
////            Text(text = "this is the homepage")
////
////            Text(
////                modifier = Modifier
////                    .clickable {
////                        navController.navigate(ROUTE_ABOUT) {
////                            popUpTo(ROUTE_HOME) { inclusive = true }
////                        }
////                    },
////                text = "about"
////            )
////
////            Button(onClick = {
////                navController.navigate(ROUTE_ABOUT) {
////                    popUpTo(ROUTE_HOME) { inclusive = true }
////                }
////            }) {
////
////                Text(text = "sketchy about")
////
////            }
////
////            Text(
////                modifier = Modifier
////                    .clickable {
////                        navController.navigate(ROUTE_CONTACT) {
////                            popUpTo(ROUTE_HOME) { inclusive = true }
////                        }
////                    },
////                text = "Contact"
////            )
////
////            Card(
////                colors = CardDefaults.cardColors(Color(0xffE52C04)),
////                elevation = CardDefaults.cardElevation(5.dp)
////
////            ) {
////
////
////            }
////
////
////            Text(
////                modifier = Modifier
////                    .clickable {
////                        navController.navigate(ROUTE_PRODUCTS) {
////                            popUpTo(ROUTE_HOME) { inclusive = true }
////                        }
////                    },
////                text = "go to products screen"
////
////            )
////
////            Button(onClick = {
////                navController.navigate(ROUTE_MIT) {
////                    popUpTo(ROUTE_HOME) { inclusive = true }
////                }
////            }) {
////
////                Text(text = "fuurye")
////
////            }
////
////            Text(
////                modifier = Modifier
////
////                    .clickable {
////                        navController.navigate(ROUTE_MIT) {
////                            popUpTo(ROUTE_HOME) { inclusive = true }
////                        }
////                    },
////                text = "go to mit",
////                textAlign = TextAlign.Center,
////                color = MaterialTheme.colorScheme.onSurface
////            )
////
////            Text(
////                modifier = Modifier
////                    .clickable {
////                        navController.navigate(ROUTE_SHOP) {
////                            popUpTo(ROUTE_HOME) { inclusive = true }
////                        }
////                    },
////                text = "go to shop screen",
////                textAlign = TextAlign.Center,
////                color = MaterialTheme.colorScheme.onSurface
////            )
////
////            Spacer(modifier = Modifier.height(10.dp))
////
////
////
////            OutlinedButton(onClick = {
////
////                navController.navigate(ROUTE_ADD_STUDENTS) {
////                    popUpTo(ROUTE_HOME) { inclusive = true }
////                }
////
////            }) {
////
////                Text(text = "Add Students")
////
////            }
////
////
////        }
////
////    }
////}
//
//
////@Preview(showBackground = true)
////@Composable
////fun PreviewLight() {
////    HomeScreen(rememberNavController())
////}
//
//
//package net.ezra.ui.home
//
//
//
//
//
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import androidx.activity.compose.ManagedActivityResultLauncher
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.ActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.animation.core.Animatable
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
////noinspection UsingMaterialAndMaterial3Libraries
//import androidx.compose.material.BottomNavigation
////noinspection UsingMaterialAndMaterial3Libraries
//import androidx.compose.material.BottomNavigationItem
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountCircle
//import androidx.compose.material.icons.filled.ArrowForward
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material3.Card
//import androidx.compose.material3.CenterAlignedTopAppBar
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import net.ezra.R
//import net.ezra.navigation.ROUTE_ADD_PRODUCT
//import net.ezra.navigation.ROUTE_ADD_STUDENTS
//import net.ezra.navigation.ROUTE_HOME
//import net.ezra.navigation.ROUTE_LOGIN
//import net.ezra.navigation.ROUTE_SEARCH
//import net.ezra.navigation.ROUTE_VIEW_PROD
//
//
//data class Screen(val title: String, val icon: Int)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeScreen(navController: NavHostController) {
//
//    var isDrawerOpen by remember { mutableStateOf(false) }
//
//    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
//        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->
//
//        }
//
//
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Text(text = stringResource(id = R.string.apen))
//                },
//                navigationIcon = @Composable {
//                    if (!isDrawerOpen) {
//                        IconButton(onClick = { isDrawerOpen = true }) {
//                            Icon(
//                                Icons.Default.Menu,
//                                contentDescription = "Menu",
//                                tint = Color.White
//                                )
//                        }
//                    }
//                },
//
//                actions = {
//                    IconButton(onClick = {
//                        navController.navigate(ROUTE_LOGIN) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }
//
//                    }) {
//                        Icon(
//                            imageVector = Icons.Filled.AccountCircle,
//                            contentDescription = null,
//                            tint = Color.White
//                        )
//                    }
//                },
//
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xffee9a63),
//                    titleContentColor = Color.White,
//
//                )
//
//            )
//        },
//
//        content = @Composable {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .clickable {
//                        if (isDrawerOpen) {
//                            isDrawerOpen = false
//                        }
//                    }
//            ) {
//                Image(painter = painterResource(id = R.drawable.img_1),
//                    contentDescription = "Logo",
//                    modifier = Modifier
//
//                        .fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                )
//
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize(),
//
//
////                        .background(Color(0xff9AEDC9)),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Row {
//
//
//                    Card(modifier = Modifier
//                        .background(Color.Black)
//                        .size(width = 500.dp, height = 98.dp),verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        onClick = {
//                            navController.navigate(ROUTE_ADD_PRODUCT) {
//                                popUpTo(route = ROUTE_HOME) { inclusive = true }
//                            }
//                        })}
//
//                   Row {
//                       Card(modifier = Modifier
////                           .background(Color.Black)
//                           .size(width = 100.dp, height = 50.dp)
//
//                       ) {
//                           Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_ADD_PRODUCT) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Add Products",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface)
////                           Text(
////                               text = stringResource(id = androidx.core.R.string.call_notification_answer_action),
////                               fontSize = 20.sp,
////                               modifier = Modifier
////                                   .padding(16.dp)
////                                   .clickable {
////
////                                       val intent = Intent(Intent.ACTION_DIAL)
////                                       intent.data = Uri.parse("tel:+254796759850")
////
////                                       callLauncher.launch(intent)
////                                   }
////                           )
//                       }
////                       Spacer(modifier =Modifier.height=50.dp )
//                   }
//                    Row {
//                        Card(modifier = Modifier
////                           .background(Color.Black)
//                            .size(width = 100.dp, height = 50.dp)
//
//
//                        ) {
//                            Text(
//                                modifier = Modifier
//
//                                    .clickable {
//                                        navController.navigate(ROUTE_VIEW_PROD) {
//                                            popUpTo(ROUTE_HOME) { inclusive = true }
//                                        }
//                                    },
//                                text = "shop",
//                                textAlign = TextAlign.Center,
//                                fontSize = 20.sp,
//                                color = MaterialTheme.colorScheme.onSurface)}}
//
//
//                    Text(
//                        text = stringResource(id = R.string.developer),
//                        fontSize = 20.sp,
//                    )
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_LOGIN) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Login Here",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//
//
////                    Text(
////                        modifier = Modifier
////
////                            .clickable {
////                                navController.navigate(ROUTE_ADD_PRODUCT) {
////                                    popUpTo(ROUTE_HOME) { inclusive = true }
////                                }
////                            },
////                        text = "Add Products",
////                        textAlign = TextAlign.Center,
////                        fontSize = 20.sp,
////                        color = MaterialTheme.colorScheme.onSurface
////                    )
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_ADD_STUDENTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Add Students",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_VIEW_PROD) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "view Products",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Text(
//                        text = "You're welcome",
//                        fontSize = 30.sp,
//                        color = Color.White
//                    )
//
//                    Row {
//                        Card(modifier = Modifier
////                           .background(Color.Black)
//                            .size(width = 500.dp, height = 98.dp)
//                            ,
//
//                        ) {
//                            Text(
//                                modifier = Modifier
//
//                                    .clickable {
//                                        navController.navigate(ROUTE_LOGIN) {
//                                            popUpTo(ROUTE_HOME) { inclusive = true }
//                                        }
//                                    },
//                                text = "log in here",
//                                textAlign = TextAlign.Center,
//                                fontSize = 20.sp,
//                                color = MaterialTheme.colorScheme.onSurface)}}
//                    Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "")
//
//                }
//
//            }
//
//        },
////        modifier = Column(
////            modifier = Modifier.size(width = 450.dp, height = 150.dp)
////        ) {
////            Card(modifier = Modifier
////                .background(Color.DarkGray)
////                .size(width = 500.dp, height = 98.dp),
////                onClick = {
////                    navController.navigate(ROUTE_ABOUT) {
////                        popUpTo(route = ROUTE_HOME) { inclusive = true }
////                    }
////                }) },
//
//        bottomBar = { BottomBar(navController = navController) }
//
//
//
//
//
//
//
//    )
//
//    AnimatedDrawer(
//        isOpen = isDrawerOpen,
//        onClose = { isDrawerOpen = false }
//    )
//}
//
//fun Card(
//    modifier: Modifier,
//    onClick: () -> Unit,
//    verticalArrangement: Arrangement.HorizontalOrVertical,
//    horizontalAlignment: Alignment.Horizontal
//) {
//
//}
//
//fun ModalNavigationDrawer(gesturesEnabled: Boolean, drawerContent: @Composable () -> Unit) {
//
//}
//
//@Composable
//fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
//
//
//
//    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }
//    val navigationController = rememberNavController()
//
//    LaunchedEffect(isOpen) {
//        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
//    }
//
//    Surface(
//        modifier = Modifier
//            .fillMaxHeight()
//            .width(drawerWidth.value.dp)
//            ,
//        color = Color.LightGray,
////        elevation = 16.dp
//    ) {
//        Column {
//
////            Text(
////                text = "Drawer Item 1"
////
////            )
////            Text(
////                text = "Drawer Item 2"
////            )
////            Text(
////                text = "Drawer Item 3",
////                modifier = Modifier.clickable {  }
////            )
////            Spacer(modifier = Modifier.height(16.dp))
////            Text(text = stringResource(id = R.string.developer))
//
//        }
//    }
//}
//
//
//
//
//
//
//@Composable
//fun BottomBar(navController: NavHostController) {
//    val selectedIndex = remember { mutableStateOf(0) }
//    BottomNavigation(
//        elevation = 10.dp,
//        backgroundColor = Color(0xff0FB06A)
//
//
//    ) {
//
//        BottomNavigationItem(icon = {
//            Icon(imageVector = Icons.Default.Home,"", tint = Color.White)
//        },
//            label = { Text(text = "Home",color =  Color.White) }, selected = (selectedIndex.value == 0), onClick = {
//
//            })
//
//        BottomNavigationItem(icon = {
//            Icon(imageVector = Icons.Default.Favorite,"",tint = Color.White)
//        },
//            label = { Text(text = "Favorite",color =  Color.White) }, selected = (selectedIndex.value == 1), onClick = {
//
//            })
//
//        BottomNavigationItem(icon = {
//            Icon(imageVector = Icons.Default.Person, "",tint = Color.White)
//        },
//            label = { Text(
//                text = "Students",
//                color =  Color.White) },
//            selected = (selectedIndex.value == 2),
//            onClick = {
//
//                navController.navigate(ROUTE_SEARCH) {
//                    popUpTo(ROUTE_HOME) { inclusive = true }
//                }
//
//            })
//
//    }
//}