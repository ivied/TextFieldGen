package com.coolhabit.textfieldgencompose.textField.finish

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coolhabit.textfieldgencompose.baseui.extensions.conditional
import com.coolhabit.textfieldgencompose.textField.extensions.toAlign
import com.coolhabit.textfieldgencompose.textField.extensions.toFont
import com.coolhabit.textfieldgencompose.textField.extensions.toKeyboardType

@Composable
fun FinishScreen(
    viewModel: FinishViewModel,
    showLink: (String) -> Unit,
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(Modifier.fillMaxWidth()) {
            state.settings.forEach { item ->
                var input by remember { mutableStateOf(TextFieldValue("")) }
                val borderWidth = item.borderWidth
                val borderColor = item.borderColor
                val backgroundColor = item.backgroundColor
                val placeholderColor = item.placeholderTextColor
                val underlineColor = item.underlineColor
                val textColor = item.textColor
                val align = item.align.toAlign()
                val font = item.font.toFont()
                val keyboardType = item.keyboardType.toKeyboardType()
                val maxStroke = item.maxStroke
                var scrollState = rememberScrollState()
                val sizeHeight = item.size.height
                val sizeWidth = item.size.width
                val sizeMinHeight = item.size.minHeight
                val sizeMinWidth = item.size.minWidth
                val shadowColor = item.shadow.shadowColor
                val linkColor = item.url?.urlText?.color
                val mAnnotatedLinkString =
                    if (item.content.isNotEmpty() && !item.url?.urlText?.content.isNullOrEmpty()) {
                        buildAnnotatedString {

                            // creating a string to display in the Text
                            val mStr = item.content

                            // word and span to be hyperlinked
                            val mStartIndex = mStr.indexOf(item.url?.urlText?.content!!)
                            val mEndIndex = mStartIndex + item.url?.urlText?.content!!.length

                            append(mStr)
                            addStyle(
                                style = SpanStyle(
                                    color = if (!item.textColor.clear) Color(
                                        textColor.red,
                                        textColor.green,
                                        textColor.blue
                                    ) else Color.White,
                                    textDecoration = TextDecoration.Underline,
                                ), start = mStartIndex, end = mEndIndex
                            )

                            // attach a string annotation that
                            // stores a URL to the text "link"
                            addStringAnnotation(
                                tag = "URL",
                                annotation = item.url?.urlText?.content!!,
                                start = mStartIndex,
                                end = mEndIndex
                            )
                        }
                    } else null

                if (item.isInput) {
                    Box(
                        Modifier
                            .wrapContentSize()
                            .align(align)
                            .conditional(item.position.x != 0 || item.position.y != 0) {
                                offset(item.position.x.dp, item.position.y.dp)
                            }) {
                        TextField(
                            value = input,
                            textStyle = TextStyle(
                                fontSize = item.fontSize.sp,
                                fontFamily = font,
                                letterSpacing = item.lineSpace.sp
                            ),
                            placeholder = {
                                Text(text = item.placeholderText)
                            },
                            onValueChange = { text ->
                                if (text.text.length <= maxStroke) input = text
                                input = text
                            },
                            modifier = Modifier
                                .layoutId(item.id)
                                .border(
                                    BorderStroke(
                                        width = borderWidth.dp,
                                        color = if (!item.borderColor.clear) Color(
                                            borderColor.red,
                                            borderColor.green,
                                            borderColor.blue
                                        ) else Color.White
                                    )
                                )
                                .conditional(item.isInputFieldHeightDynamic) {
                                    wrapContentHeight()
                                }
                                .conditional(sizeHeight != 0) {
                                    height(sizeHeight.dp)
                                }
                                .conditional(sizeWidth != 0) {
                                    width(sizeWidth.dp)
                                }
                                .conditional(sizeHeight == 0 && sizeMinHeight == 0) {
                                    wrapContentHeight()
                                }
                                .conditional(sizeWidth == 0 && sizeMinWidth == 0) {
                                    wrapContentWidth()
                                }
                                .conditional(sizeHeight == 0 && sizeMinHeight != 0) {
                                    requiredHeight(sizeMinWidth.dp)
                                }
                                .conditional(sizeWidth == 0 && sizeMinWidth != 0) {
                                    requiredWidth(sizeMinWidth.dp)
                                }
                                .conditional(item.isScrollable) {
                                    horizontalScroll(scrollState)
                                }
                                .padding(
                                    top = item.rimPadding.dp,
                                    start = if (item.leftPadding != 0) item.leftPadding.dp else item.rimPadding.dp,
                                    end = if (item.rightPadding != 0) item.rightPadding.dp else item.rimPadding.dp,
                                    bottom = if (item.bottomPadding != 0) item.bottomPadding.dp else item.rimPadding.dp
                                )
                                .drawBehind {
                                    if (!item.underlineColor.clear) {
                                        drawLine(
                                            color = if (!item.underlineColor.clear) Color(
                                                underlineColor.red,
                                                underlineColor.green,
                                                underlineColor.blue
                                            ) else Color.White,
                                            start = Offset(0f, size.height),
                                            end = Offset(size.width, size.height),
                                            strokeWidth = item.underlineThickness.dp.toPx()
                                        )
                                    }
                                }
                                .conditional(!item.shadow.shadowColor.clear) {
                                    shadow(
                                        shape = RoundedCornerShape(item.shadow.shadowRadius.dp),
                                        ambientColor = Color(
                                            shadowColor.red,
                                            shadowColor.green,
                                            shadowColor.blue,
                                        ),
                                        elevation = item.shadow.shadowOffset.dp
                                    )
                                },
                            shape = RoundedCornerShape(item.cornerRadius.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = if (!item.backgroundColor.clear) Color(
                                    backgroundColor.red,
                                    backgroundColor.green,
                                    backgroundColor.blue
                                ) else Color.White,
                                placeholderColor = if (!item.placeholderTextColor.clear) Color(
                                    placeholderColor.red,
                                    placeholderColor.green,
                                    placeholderColor.blue
                                ) else Color.White,
                                textColor = if (!item.textColor.clear) Color(
                                    textColor.red,
                                    textColor.green,
                                    textColor.blue
                                ) else Color.White,
                            ),
                            visualTransformation = if (!item.isSecureText) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                            maxLines = if (item.lines != 0) item.lines else 1,
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                } else {
                    if (mAnnotatedLinkString.isNullOrEmpty()) {
                        Card(
                            modifier = Modifier
                                .wrapContentSize()
                                .align(align)
                                .conditional(item.position.x != 0 || item.position.y != 0) {
                                    offset(item.position.x.dp, item.position.y.dp)
                                }
                                .border(
                                    BorderStroke(
                                        width = borderWidth.dp,
                                        color = if (!item.borderColor.clear) Color(
                                            borderColor.red,
                                            borderColor.green,
                                            borderColor.blue
                                        ) else Color.White
                                    )
                                )
                                .layoutId(item.id)
                                .conditional(item.isInputFieldHeightDynamic) {
                                    wrapContentHeight()
                                }
                                .conditional(sizeHeight != 0) {
                                    height(sizeHeight.dp)
                                }
                                .conditional(sizeWidth != 0) {
                                    width(sizeWidth.dp)
                                }
                                .conditional(sizeHeight == 0 && sizeMinHeight == 0) {
                                    wrapContentHeight()
                                }
                                .conditional(sizeWidth == 0 && sizeMinWidth == 0) {
                                    wrapContentWidth()
                                }
                                .conditional(sizeHeight == 0 && sizeMinHeight != 0) {
                                    requiredHeight(sizeMinWidth.dp)
                                }
                                .conditional(sizeWidth == 0 && sizeMinWidth != 0) {
                                    requiredWidth(sizeMinWidth.dp)
                                }
                                .conditional(item.isScrollable) {
                                    horizontalScroll(scrollState)
                                }
                                .padding(
                                    top = item.rimPadding.dp,
                                    start = if (item.leftPadding != 0) item.leftPadding.dp else item.rimPadding.dp,
                                    end = if (item.rightPadding != 0) item.rightPadding.dp else item.rimPadding.dp,
                                    bottom = if (item.bottomPadding != 0) item.bottomPadding.dp else item.rimPadding.dp
                                )
                                .drawBehind {
                                    if (!item.underlineColor.clear) {
                                        drawLine(
                                            color = if (!item.underlineColor.clear) Color(
                                                underlineColor.red,
                                                underlineColor.green,
                                                underlineColor.blue
                                            ) else Color.White,
                                            start = Offset(0f, size.height),
                                            end = Offset(size.width, size.height),
                                            strokeWidth = item.underlineThickness.dp.toPx()
                                        )
                                    }
                                },
                            shape = RoundedCornerShape(item.cornerRadius.dp),
                            backgroundColor = if (!item.backgroundColor.clear) Color(
                                backgroundColor.red,
                                backgroundColor.green,
                                backgroundColor.blue
                            ) else Color.White,
                        ) {
                            Text(
                                color = if (!item.textColor.clear) Color(
                                    textColor.red,
                                    textColor.green,
                                    textColor.blue
                                ) else Color.White,
                                modifier = Modifier,
                                text = item.content,
                                style = TextStyle(
                                    fontSize = item.fontSize.sp,
                                    fontFamily = font,
                                    letterSpacing = item.lineSpace.sp,
                                    shadow = Shadow(
                                        color = Color(
                                            shadowColor.red,
                                            shadowColor.green,
                                            shadowColor.blue,
                                        ),
                                        offset = Offset(
                                            item.shadow.shadowOffset.toFloat(),
                                            item.shadow.shadowOffset.toFloat()
                                        ),
                                        blurRadius = item.shadow.shadowRadius.toFloat(),
                                    ),
                                ),
                                maxLines = if (item.lines != 0) item.lines else 1,
                            )
                        }
                    } else {

                        Card(
                            modifier = Modifier
                                .align(align)
                                .layoutId(item.id)
                                .conditional(item.position.x != 0 || item.position.y != 0) {
                                    offset(item.position.x.dp, item.position.y.dp)
                                }
                                .conditional(item.isInputFieldHeightDynamic) {
                                    wrapContentHeight()
                                }
                                .conditional(sizeHeight != 0) {
                                    height(sizeHeight.dp)
                                }
                                .conditional(sizeWidth != 0) {
                                    width(sizeWidth.dp)
                                }
                                .conditional(sizeHeight == 0 && sizeMinHeight == 0) {
                                    wrapContentHeight()
                                }
                                .conditional(sizeWidth == 0 && sizeMinWidth == 0) {
                                    wrapContentWidth()
                                }
                                .conditional(sizeHeight == 0 && sizeMinHeight != 0) {
                                    requiredHeight(sizeMinWidth.dp)
                                }
                                .conditional(sizeWidth == 0 && sizeMinWidth != 0) {
                                    requiredWidth(sizeMinWidth.dp)
                                }
                                .conditional(item.isScrollable) {
                                    horizontalScroll(scrollState)
                                }
                                .padding(
                                    top = item.rimPadding.dp,
                                    start = if (item.leftPadding != 0) item.leftPadding.dp else item.rimPadding.dp,
                                    end = if (item.rightPadding != 0) item.rightPadding.dp else item.rimPadding.dp,
                                    bottom = if (item.bottomPadding != 0) item.bottomPadding.dp else item.rimPadding.dp
                                )
                                .drawBehind {
                                    if (!item.underlineColor.clear) {
                                        drawLine(
                                            color = if (!item.underlineColor.clear) Color(
                                                underlineColor.red,
                                                underlineColor.green,
                                                underlineColor.blue
                                            ) else Color.White,
                                            start = Offset(0f, size.height),
                                            end = Offset(size.width, size.height),
                                            strokeWidth = item.underlineThickness.dp.toPx()
                                        )
                                    }
                                }
                                .wrapContentSize()
                                .border(
                                    BorderStroke(
                                        width = borderWidth.dp,
                                        color = if (!item.borderColor.clear) Color(
                                            borderColor.red,
                                            borderColor.green,
                                            borderColor.blue
                                        ) else Color.White
                                    )
                                ),
                            shape = RoundedCornerShape(item.cornerRadius.dp),
                            backgroundColor = if (!item.backgroundColor.clear) Color(
                                backgroundColor.red,
                                backgroundColor.green,
                                backgroundColor.blue
                            ) else Color.White,
                        ) {
                            ClickableText(
                                modifier = Modifier,
                                text = mAnnotatedLinkString,
                                style = TextStyle(
                                    fontSize = item.fontSize.sp,
                                    fontFamily = font,
                                    letterSpacing = item.lineSpace.sp,
                                    shadow = Shadow(
                                        color = Color(
                                            shadowColor.red,
                                            shadowColor.green,
                                            shadowColor.blue,
                                        ),
                                        offset = Offset(
                                            item.shadow.shadowOffset.toFloat(),
                                            item.shadow.shadowOffset.toFloat()
                                        ),
                                        blurRadius = item.shadow.shadowRadius.toFloat(),
                                    ),
                                ),
                                onClick = {
                                    mAnnotatedLinkString
                                        .getStringAnnotations("URL", it, it)
                                        .firstOrNull()?.let { stringAnnotation ->
                                            showLink(stringAnnotation.item)
                                        }
                                }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    viewModel.startAgain()
                },
            ) {
                Text(text = "Start Again")
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color.Red
            )
        }
    }
}
