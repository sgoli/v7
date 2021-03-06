/*
 * Copyright (C) 2013 David Sowerby
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package uk.co.q3c.v7.i18n;

import java.util.EnumMap;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public abstract class EnumResourceBundle<E extends Enum<E>> extends ResourceBundle {

	@Override
	public Enumeration<String> getKeys() {
		throw new RuntimeException("getKeys() replaced in V7, use getMap() instead");
	}

	@Override
	protected Object handleGetObject(String arg0) {
		throw new RuntimeException("handleGetObject() replaced in V7, use getValue() instead");
	}

	public String getValue(E key) {
		if (key == null) {
			return null;
		}
		String value = getMap().get(key);
		if (value != null) {
			return value;
		}
		@SuppressWarnings("unchecked")
		EnumResourceBundle<E> enumparent = (EnumResourceBundle<E>) parent;
		if (enumparent == null) {
			throw new MissingResourceException("resource not defined", this.getClass().getName(), key.name());
		}
		return enumparent.getValue(key);

	}

	public abstract EnumMap<E, String> getMap();
}