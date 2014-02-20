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
package org.auraframework.impl.root.theme;

import org.auraframework.def.DefDescriptor;
import org.auraframework.def.StyleDef;
import org.auraframework.def.ThemeDef;
import org.auraframework.impl.system.DefDescriptorImpl;

/**
 * Utilities for working with {@link ThemeDef}s.
 */
public final class Themes {
    public static DefDescriptor<ThemeDef> getLocalTheme(DefDescriptor<StyleDef> styleDef) {
        String fmt = String.format("%s:%s", styleDef.getNamespace(), styleDef.getName());
        return DefDescriptorImpl.getInstance(fmt, ThemeDef.class);
    }

    public static DefDescriptor<ThemeDef> getNamespaceDefaultTheme(DefDescriptor<?> descriptor) {
        String fmt = String.format("%s:%sTheme", descriptor.getNamespace(), descriptor.getNamespace());
        return DefDescriptorImpl.getInstance(fmt, ThemeDef.class);
    }
}
