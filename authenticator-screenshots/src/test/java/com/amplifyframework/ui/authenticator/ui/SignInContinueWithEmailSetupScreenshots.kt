/*
 * Copyright 2024 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

package com.amplifyframework.ui.authenticator.ui

import com.amplifyframework.ui.authenticator.ScreenshotTestBase
import com.amplifyframework.ui.authenticator.SignInContinueWithEmailSetupState
import com.amplifyframework.ui.authenticator.enums.AuthenticatorInitialStep
import com.amplifyframework.ui.authenticator.enums.AuthenticatorStep
import com.amplifyframework.ui.authenticator.forms.FieldConfig
import com.amplifyframework.ui.authenticator.forms.FieldKey
import com.amplifyframework.ui.authenticator.mockFieldData
import com.amplifyframework.ui.authenticator.mockFieldState
import com.amplifyframework.ui.authenticator.mockForm
import org.junit.Test

class SignInContinueWithEmailSetupScreenshots : ScreenshotTestBase() {

    @Test
    fun default_state() {
        screenshot {
            SignInContinueWithEmailSetup(mockSignInContinueWithEmailSetupState())
        }
    }

    private fun mockSignInContinueWithEmailSetupState() = object : SignInContinueWithEmailSetupState {
        override val form = mockForm(
            mockFieldData(
                config = FieldConfig.Text(FieldKey.Email),
                state = mockFieldState(content = "email@email.com")
            )
        )
        override fun moveTo(step: AuthenticatorInitialStep) {}
        override suspend fun continueSignIn() {}
        override val step = AuthenticatorStep.SignInContinueWithEmailSetup
    }
}
