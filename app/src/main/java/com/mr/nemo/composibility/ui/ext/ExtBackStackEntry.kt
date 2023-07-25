package com.mr.nemo.composibility.ui.ext

import android.os.Bundle
import androidx.navigation.NavBackStackEntry

fun NavBackStackEntry.requiredArguments(): Bundle =
    checkNotNull(arguments) { "Arguments at route:\"${destination.route}\" were expected, but none were provided!" }
