/*
 * Copyright (C) 2013 salesforce.com, inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.auraframework.util.type.converter;

import org.auraframework.annotations.Annotations.ServiceComponent;
import org.auraframework.util.date.AuraDateUtil;
import org.auraframework.util.type.Converter;
import org.springframework.context.annotation.Lazy;

import java.util.Calendar;


/**
 * Used by aura.util.type.TypeUtil
 */
@Lazy
@ServiceComponent
public class StringToCalendarConverter implements Converter<String, Calendar> {

    @Override
    public Calendar convert(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        Long milliseconds;
        try {
            milliseconds = Long.valueOf(value);
        } catch (NumberFormatException nfe) {
            milliseconds = AuraDateUtil.isoToLong(value);
        }
        Calendar cal = null;
        if(milliseconds != null) {
            cal = Calendar.getInstance();
            cal.setTimeInMillis(milliseconds);
        }
        return cal;
    }

    @Override
    public Class<String> getFrom() {
        return String.class;
    }

    @Override
    public Class<Calendar> getTo() {
        return Calendar.class;
    }

    @Override
    public Class<?>[] getToParameters() {
        return null;
    }
}
