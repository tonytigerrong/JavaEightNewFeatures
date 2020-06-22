package com.corejava.interviews.genericsdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		
		Grandpa grandpa = new Grandpa();
		Father father = new Father();
		Child child  = new Child();
		
		List<Child> _childs = new ArrayList<Child>();
		_childs.add(child);
		
		List<Father> _fathers = new ArrayList<Father>();
		_fathers.add(father);
//		_fathers.add(child); // error
		
		List<Grandpa> _grandpas = new ArrayList<Grandpa>();
		_grandpas.add(grandpa);
		
		List<? extends Father> afterFather = _fathers;
//		afterFather = _childs; // error
		
		List<? super Father> beforeFather = _grandpas;
//		beforeFather.add(_fathers); // error
		
		
		
		//List of grand children
	      List<GrandChildClass> grandChildren = new ArrayList<GrandChildClass>();
	      grandChildren.add(new GrandChildClass());
	      addGrandChildren(grandChildren);
	       
	      //List of grand childs
	      List<ChildClass> childs = new ArrayList<ChildClass>();
	      childs.add(new GrandChildClass());
	      addGrandChildren(childs);
	       
	      //List of grand supers
	      List<SuperClass> supers = new ArrayList<SuperClass>();
	      supers.add(new GrandChildClass());
	      addGrandChildren(supers);
	      
	      List<? extends ChildClass> afterChild = childs;
	      afterChild = grandChildren;
	     
//	      afterChild = supers; // compile error
	      
	      List<? super ChildClass> beforeChild = childs;
	      beforeChild = supers;
//	      beforeChild = grandChildren; // compile error
	      
	}
	public static void addGrandChildren(List<? super GrandChildClass> grandChildren) {
		   grandChildren.add(new GrandChildClass());  
	}
	
	
}
class SuperClass{
}
class ChildClass extends SuperClass{
}
class GrandChildClass extends ChildClass{
}