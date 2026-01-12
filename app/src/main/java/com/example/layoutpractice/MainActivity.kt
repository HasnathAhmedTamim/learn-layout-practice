package com.example.layoutpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutpractice.ui.theme.LayoutPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutPracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Day1ModifierPractice()
                    Day2ColumnPractice()
                }
            }
        }
    }
}


@Composable
fun Day1ModifierPractice() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "DAY 1: Modifiers",
            style = MaterialTheme.typography.headlineMedium
        )

        // Exercise 1: Padding and Background
        Text(
            text = "Box with padding",
            modifier = Modifier
                .size(300.dp,300.dp).background(Color.Yellow)
                .padding(40.dp),
            color = Color.White
        )

        // Exercise 2: Size modifiers
        Text(
            text = "Fixed size box",
            modifier = Modifier
                .size(200.dp, 60.dp)
                .background(Color.Cyan),
            color = Color.White
        )

        // Exercise 3: Fill width
        Text(
            text = "Full width",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .padding(16.dp),
            color = Color.White
        )
//         My custom text
        Text(
            text = "my custom text",
            modifier = Modifier.fillMaxSize()
                .background(Color(0xFFFF9800))
                .padding(16.dp),
            color = Color.White
        )
    }

}


//@Preview(showBackground = true)
//@Composable
//fun PreviewDay1() {
//    LayoutPracticeTheme {
//        Day1ModifierPractice()
//    }
//}

@Composable
fun Day2ColumnPractice() {
    // Example 1: Top arrangement
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        Text("DAY 2: Column Arrangements", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Practice: Items at Top
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.Top
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(50.dp).background(Color.Green))
            Box(modifier = Modifier.size(50.dp).background(Color.Blue))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Practice: Items Centered
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(50.dp).background(Color.Green))
            Box(modifier = Modifier.size(50.dp).background(Color.Blue))
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text("First")
            Text("Middle")
            Text("Last")
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewDay2() {
//    LayoutPracticeTheme {
//        Day2ColumnPractice()
//    }
//}

@Composable
fun Day3RowAndAlignment() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("DAY 3: Row & Alignment", style = MaterialTheme.typography.headlineMedium)

        // Horizontal arrangement
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFFE3F2FD)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(50.dp).background(Color.Green))
            Box(modifier = Modifier.size(50.dp).background(Color.Blue))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("First Line")
        Text("Second Line")

        // Alignment practice
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFFFF3E0)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Text("Top Aligned")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFF3E5F5)),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Center Aligned")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFE8F5E9)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Text("Bottom Aligned")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDay3() {
    LayoutPracticeTheme {
        Day3RowAndAlignment()
    }
}
