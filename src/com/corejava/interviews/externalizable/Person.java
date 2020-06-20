package com.corejava.interviews.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.corejava.interviews.externalizable.Address;

public class Person implements Externalizable {
	private String name;
	private int age;
	private Address address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String toString(){
		return "[name: "+this.name+", age: "+this.age+", address:"+address.getCity()+" ]";
	}
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		this.name = arg0.readUTF();
		this.age = arg0.readInt();
		this.address = (Address) arg0.readObject();
		
	}
	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		arg0.writeUTF(this.name);
		arg0.writeInt(this.age);
		arg0.writeObject(this.address);
	}
	
}
