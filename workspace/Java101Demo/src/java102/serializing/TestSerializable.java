package java102.serializing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializable {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Item item = new Item(1, "Iphone", 33333);
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(item);
		
		for(byte b: baos.toByteArray()){
			System.out.print(b);
		}
		System.out.println();
		ByteArrayInputStream bias = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bias);
		Item deserializedObj = (Item) ois.readObject();
		System.out.println(deserializedObj);
		System.out.println(item == deserializedObj);

	}

}
