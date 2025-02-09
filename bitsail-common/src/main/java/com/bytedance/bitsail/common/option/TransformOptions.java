/*
 * Copyright 2022-2023 Bytedance Ltd. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.bytedance.bitsail.common.option;

import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

import static com.bytedance.bitsail.common.option.ConfigOptions.key;

/**
 * The set of configuration options relating to transform config.
 */
public interface TransformOptions {
  String JOB_TRANSFORM = "job.transform";
  String TRANSFORM_PREFIX = JOB_TRANSFORM + ".";

  /**
   * Metric tag for indicating reader type.
   */
  ConfigOption<String> TRANSFORM_METRIC_TAG_NAME =
      key(TRANSFORM_PREFIX + "metric_tag_name")
          .noDefaultValue(String.class);

  ConfigOption<List<Map<String, Object>>> TRANSFORM_CONFIG_LIST =
      key(TRANSFORM_PREFIX + "transform_conf_list")
          .onlyReference(new TypeReference<List<Map<String, Object>>>() {
          });

  interface BaseTransformOptions {
    ConfigOption<String> TRANSFORM_TYPE =
        key(TRANSFORM_PREFIX + "transform_type")
            .noDefaultValue(String.class);

    ConfigOption<String> PARTITION_COLUMN_NAME =
        key(TRANSFORM_PREFIX + "partition_column_name")
            .noDefaultValue(String.class);

    ConfigOption<String> PARTITIONER_TYPE =
        key(TRANSFORM_PREFIX + "partitioner_type")
            .defaultValue("hash");

    ConfigOption<String> MAP_FUNCTION_TYPE =
        key(TRANSFORM_PREFIX + "map_function_type")
            .noDefaultValue(String.class);

    ConfigOption<List<String>> APPEND_STRING_COLUMNS =
        key(TRANSFORM_PREFIX + "append_string_columns")
            .onlyReference(new TypeReference<List<String>>() {
            });

    ConfigOption<List<String>> APPEND_STRING_VALUES =
        key(TRANSFORM_PREFIX + "append_string_values")
            .onlyReference(new TypeReference<List<String>>() {
            });
  }
}
