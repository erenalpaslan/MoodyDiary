package com.easylife.mooddiary.ui.view.newdiary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.easylife.mooddiary.R

/**
 * Created by erenalpaslan on 16.09.2022
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewDiarySecondPage(
    isExpanded: MutableState<Boolean>,
    onSaveClicked: (String, String) -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }

    if (isExpanded.value) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
        ) {
            val (pageNameRef, titleRef, descriptionRef, saveBtnRef) = createRefs()
            Text(
                text = stringResource(id = R.string.new_diary_add_note),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(pageNameRef) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                color = Color.Black
            )
            TextField(
                value = title,
                onValueChange = {
                    title = it
                },
                modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(pageNameRef.bottom, 32.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.fillToConstraints
                }
            )
            TextField(
                value = description,
                onValueChange = {
                    description = it
                },
                modifier = Modifier.constrainAs(descriptionRef) {
                    top.linkTo(titleRef.bottom, 10.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.fillToConstraints
                }
            )
            Button(
                onClick = {
                    onSaveClicked(title, description)
                },
                modifier = Modifier
                    .constrainAs(saveBtnRef) {
                        top.linkTo(descriptionRef.bottom, 10.dp)
                        bottom.linkTo(parent.bottom, 10.dp)
                        start.linkTo(parent.start, 16.dp)
                        end.linkTo(parent.end, 16.dp)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text(text = stringResource(id = R.string.button_save))
            }
        }
    }
}