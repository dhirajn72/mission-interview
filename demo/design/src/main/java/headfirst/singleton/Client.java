package headfirst.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Client {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SingletonPerfect instance = SingletonPerfect.getInstance();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("singletonperfect.ser")));
		System.out.println("Object serialized");
		System.out.println(instance);
		objectOutputStream.writeObject(instance);
		objectOutputStream.close();
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("singletonperfect.ser")));
		Object obj = objectInputStream.readObject();
		if(obj instanceof SingletonPerfect){
			SingletonPerfect deserialObj = (SingletonPerfect) obj;
			System.out.println("Object deserialized");
			System.out.println(deserialObj);
		}
		objectInputStream.close();
	}
}
