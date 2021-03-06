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

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("api/v1/save")
class SaveController @Autowired constructor(private val service: SaveService) {

    @GetMapping(path = ["{contentKey}"])
    fun retrieveSavedContent(@PathVariable("contentKey") contentKey: String): SaveDto {
        return service.getSavedContent(contentKey).toSaveDto()
    }

    @PostMapping
    fun saveContent(@RequestBody contentObject: SaveDto) {
        service.saveContent(contentObject.toSave())
    }
}