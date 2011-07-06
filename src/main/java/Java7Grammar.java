/*
 * Copyright 2011 Yusuke Yamamoto
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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public class Java7Grammar {
    public static void main(String[] args) {
        String specVersion = System.getProperty("java.specification.version");
        // String-switch
        switch (specVersion) {
            case "1.7":
                System.out.println("Java 7");
                break;
            case "1.6":
                System.out.println("Java 6");
                break;
            case "1.5":
                System.out.println("Java 5");
                break;
            case "1.4":
                System.out.println("Java 1.4.2");
                break;
            default:
                System.out.println("Java 1.3.1 or earlier");
        }

        // diamond operator
        List<String> strs = new ArrayList<>();
        strs.add("foo");
        strs.add("bar");
        System.out.println(strs);

        // Binary integral literals
        // underscores in numeric literals
        int value = 0b0000_0111;

        // multi catch
        try {
            Method method = Class.forName("Java7Grammar").getDeclaredMethod("hello", Integer.class);
            method.invoke(Java7Grammar.class, value);
        } catch (NoSuchMethodException | ClassNotFoundException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void hello(Integer value) {
        System.out.println("Hello Java " + value);
    }
}
