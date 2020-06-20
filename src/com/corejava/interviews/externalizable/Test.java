package com.corejava.interviews.externalizable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.corejava.interviews.serializabledemo.Address;
import com.corejava.interviews.serializabledemo.Person;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Person person = new Person();
		Address address = new Address();
		address.setApt("unit2"); address.setStreet("my street name"); address.setCity("New Yorks"); address.setCountry("USA");
		person.setName("David"); person.setAge(21); person.setAddress(address);
		
		FileOutputStream fos = new FileOutputStream("./person.externalizable");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(person);
		oos.flush();
		oos.close();
		System.out.println("write to file:  "+person);
		
		FileInputStream fis = new FileInputStream("./person.externalizable");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person p = (Person) ois.readObject();
		ois.close();
		System.out.println("read from file: "+p);
		
	}

}
