/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.kafka.controller;

import org.apache.kafka.common.protocol.ApiMessageAndVersion;

import java.util.List;
import java.util.Objects;

class ControllerResultAndOffset<T> extends ControllerResult<T> {
    private final long offset;

    ControllerResultAndOffset(long offset,
                              List<ApiMessageAndVersion> records,
                              T response) {
        super(records, response);
        this.offset = offset;
    }

    public long offset() {
        return offset;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || (!o.getClass().equals(getClass()))) {
            return false;
        }
        ControllerResultAndOffset other = (ControllerResultAndOffset) o;
        return records().equals(other.records()) &&
            response().equals(other.response()) &&
            offset == other.offset;
    }

    @Override
    public int hashCode() {
        return Objects.hash(records(), response(), offset);
    }
}
