/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.provider

import org.gradle.api.internal.provider.AbstractLanguageInterOpIntegrationTest
import org.gradle.integtests.fixtures.ToBeFixedForInstantExecution

abstract class AbstractNestedBeanLanguageInterOpIntegrationTest extends AbstractLanguageInterOpIntegrationTest {
    abstract void pluginDefinesTask()

    @ToBeFixedForInstantExecution(
        because = "Kotlin Gradle Plugin",
        bottomSpecs = ["NestedBeanKotlinInterOpIntegrationTest"]
    )
    def "attaches diagnostic information to property"() {
        pluginDefinesTask()

        buildFile << """
            apply plugin: SomePlugin

            println "flag = " + tasks.someTask.params.flag
        """

        when:
        run()

        then:
        outputContains("flag = task ':someTask' property 'params.flag'")
    }
}
