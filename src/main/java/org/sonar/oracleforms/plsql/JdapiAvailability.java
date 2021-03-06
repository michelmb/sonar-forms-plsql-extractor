/*
 * Forms PL/SQL Extractor
 * Copyright (C) 2014 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.oracleforms.plsql;

class JdapiAvailability {
  private static final String JDAPI_CLASSNAME = "oracle.forms.jdapi.Jdapi";

  void check() {
    check(JDAPI_CLASSNAME);
  }

  void check(String classname) {
    if (!isAvailableInClasspath(classname)) {
      throw new IllegalStateException("Oracle JDAPI file (usually named frmjdapi.jar) is not available in classpath");
    }
  }

  boolean isAvailableInClasspath(String classname) {
    try {
      JdapiAvailability.class.getClassLoader().loadClass(classname);
      return true;

    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}
