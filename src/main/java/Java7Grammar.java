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

//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public class Java7Grammar {
    public static void main(String[] args) throws Exception {
        String specVersion = System.getProperty("java.specification.version");
        // String-switch
        switch (specVersion) {
            case "1.7":
                System.out.println("Java SE 7");
                break;
            case "1.6":
                System.out.println("Java SE 6");
                break;
            case "1.5":
                System.out.println("Java2 SE 5.0");
                break;
            case "1.4":
                System.out.println("Java2 SE 1.4.2");
                break;
            default:
                System.out.println("Java2 SE 1.3.1 or earlier");
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
            System.out.println("Boom!");
            // to make it compatible with Java 6 or earlier, do NOT touch the exception
            // otherwise you'll see : java.lang.ClassNotFoundException: java.lang.ReflectiveOperationException
//            e.printStackTrace();
//            throw e;
        }

        // to make it compatible with Java 6 or earlier, you cannot use try-catch-with-resources
/*
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/etc/hosts")))) {
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
*/
    }

    public static void hello(Integer value) {
        System.out.println("Hello Java " + value);
    }
}
