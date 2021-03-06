/*
 * Copyright 2017 NAVER Corp.
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

package com.navercorp.pinpoint.profiler.context.provider.stat.response;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.navercorp.pinpoint.profiler.context.active.ActiveTraceRepository;
import com.navercorp.pinpoint.profiler.monitor.metric.response.DefaultResponseTimeMetric;
import com.navercorp.pinpoint.profiler.monitor.metric.response.ResponseTimeMetric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Taejin Koo
 */
public class ResponseTimeMetricProvider implements Provider<ResponseTimeMetric> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ActiveTraceRepository activeTraceRepository;

    @Inject
    public ResponseTimeMetricProvider(ActiveTraceRepository activeTraceRepository) {
        this.activeTraceRepository = activeTraceRepository;
    }

    @Override
    public ResponseTimeMetric get() {
        if (activeTraceRepository != null) {
            return new DefaultResponseTimeMetric(activeTraceRepository);
        } else {
            return ResponseTimeMetric.UNSUPPORTED_RESPONSE_TIME_METRIC;
        }
    }

}
