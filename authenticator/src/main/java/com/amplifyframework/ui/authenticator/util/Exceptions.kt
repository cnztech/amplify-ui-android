/*
 * Copyright 2023 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amplifyframework.ui.authenticator.util

import com.amplifyframework.auth.AuthException
import java.net.UnknownHostException

/**
 * Exception that is passed to the errorContent if the application does not have the auth plugin
 * configured when attempting to use Authenticator
 */
class MissingConfigurationException : AuthException(
    "Missing auth configuration",
    "Make sure the Auth plugin is added and Amplify.configure is called. See " +
        "https://docs.amplify.aws/lib/auth/getting-started/q/platform/android/ for details"
)

/**
 * Exception that is passed to the errorContent if the configuration passed to the auth plugin is missing a required
 * property or has an invalid property
 */
class InvalidConfigurationException(message: String, cause: Exception?) : AuthException(
    message = message,
    recoverySuggestion = "Check that the configuration passed to Amplify.configure has all required fields",
    cause = cause
)

internal fun Throwable.isConnectivityIssue(): Boolean {
    if (this is UnknownHostException) {
        return true
    }
    return when (val cause = this.cause) {
        null -> false
        else -> cause.isConnectivityIssue()
    }
}
