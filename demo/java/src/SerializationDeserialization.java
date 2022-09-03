import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDeserialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Ser ser = new Ser(1, "test");
		FileOutputStream fos = new FileOutputStream("test.ser");
		ObjectOutputStream obj = new ObjectOutputStream(fos);
		obj.writeObject(ser);
		System.out.println("Object serialized");
		FileInputStream fis = new FileInputStream("test.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ser = (Ser) ois.readObject();
		System.out.println("Objeect desialized : " + ser);
	}

	static class Ser implements Serializable {
		public int id;
		public String name;

		Ser(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Ser{" +
					"id=" + id +
					", name='" + name + '\'' +
					'}';
		}
	}
}
