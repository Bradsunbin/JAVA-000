import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

class HelloXlassLoader extends ClassLoader {



 public static void main(String[] args) throws ClassNotFoundException {

     Class<?> hello = new HelloXlassLoader().findClass("Hello");

    try {
        Object hello_obj = hello.newInstance();
         Method hello_method = hello.getMethod("hello");
         hello_method.invoke(hello_obj);
     } catch (IllegalAccessException e) {
         e.printStackTrace();
     } catch (InstantiationException e) {
         e.printStackTrace();
     } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    }
 }
@Override
 protected Class<?> findClass(String name) throws ClassNotFoundException{
     String file_path = System.getProperty("user.dir")+ "/Hello_xclass/Hello.xlass";
    try {
        byte[] bytes = Files.readAllBytes(Paths.get(file_path));
        for (int i = bytes.length - 1; i >= 0; i--) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);

    } catch (IOException e) {
        e.printStackTrace();
        throw new ClassNotFoundException();
    }



}

}
