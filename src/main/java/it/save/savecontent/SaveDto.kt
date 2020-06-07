/*
 * Copyright 2020 Vignesh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.save.savecontent

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class SaveDto(val key: String, val content: String, val expiresIn: Int? = null) {
    fun toSave(): Save {
        val expiryTime = Calendar.getInstance().apply { if (expiresIn != null) add(Calendar.MINUTE, expiresIn) }
        return Save(key, content, expiryTime.timeInMillis)
    }
}