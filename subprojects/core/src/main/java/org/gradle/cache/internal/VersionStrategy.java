/*
 * Copyright 2016 the original author or authors.
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

package org.gradle.cache.internal;

enum VersionStrategy {
    /**
     * A separate cache instance for each Gradle version. This is the default.
     */
    CachePerVersion,
    /**
     * A single cache instance shared by all Gradle versions. It is the caller's responsibility to make sure that this is shared only with
     * those versions of Gradle that are compatible with the cache implementation and contents.
     */
    SharedCache
}
