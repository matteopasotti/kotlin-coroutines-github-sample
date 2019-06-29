package com.matteopasotti.githubapp

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

fun <T> T.toDeferred() = GlobalScope.async { this@toDeferred }