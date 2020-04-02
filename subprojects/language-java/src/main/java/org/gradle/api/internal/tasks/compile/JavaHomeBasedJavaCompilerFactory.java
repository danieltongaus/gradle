/*
 * Copyright 2015 the original author or authors.
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

package org.gradle.api.internal.tasks.compile;

import org.gradle.internal.Factory;
import org.gradle.internal.jvm.Jvm;

import javax.tools.JavaCompiler;
import java.io.File;
import java.io.Serializable;
import java.util.List;

public class JavaHomeBasedJavaCompilerFactory implements Factory<JavaCompiler>, Serializable {
    private final List<File> compilerPluginsClasspath;

    public JavaHomeBasedJavaCompilerFactory(List<File> compilerPluginsClasspath) {
        this.compilerPluginsClasspath = compilerPluginsClasspath;
    }

    @Override
    public JavaCompiler create() {
        return new JdkTools(Jvm.current(), compilerPluginsClasspath).getSystemJavaCompiler();
    }
}
