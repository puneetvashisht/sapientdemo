package com.demo_04.dateTime;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



public class NashornDemo {
//	scripting engine object is the sole entry point to the Oracle Nashorn interpreter
	private static ScriptEngineManager engineManager = new ScriptEngineManager();
	
//	"Javascript "and "ECMAScript" are aliases for nashorn (default 
//	JavaScript engine bundled with JVM)
	private static ScriptEngine engine = engineManager.getEngineByName("nashorn");
	
	private static void executeJs() throws Throwable {
		engine.eval("function sum(a, b) { return a + b; }");
		System.out.println(engine.eval("sum(1, 2);"));
	}
	
	private static void invokeJs() throws FileNotFoundException, NoSuchMethodException, ScriptException{
		Invocable invocable = (Invocable) engine;
//		String scriptFile = "F:\\workspaces\\Java8\\Java8Features\\src\\com\\demo_05\\nashorn\\script.js";
		String scriptFile = "src/com/demo_05/nashorn/script.js";
		FileReader fr = new FileReader(scriptFile);
		BufferedReader br = new BufferedReader(fr);
		
		engine.eval(br);

		System.out.println(invocable.invokeFunction("mul", 10, 2)); 
	}
	
	private static void convertToReferenceOnJavaInterface() throws FileNotFoundException, ScriptException{
		Invocable invocable = (Invocable) engine;
		String scriptFile = "src/com/demo_05/nashorn/script.js";
		FileReader fr = new FileReader(scriptFile);
		BufferedReader br = new BufferedReader(fr);
		
		engine.eval(br);
	       
		Multiplier multiplier = invocable.getInterface(Multiplier.class);
		if (multiplier == null) {
			System.out.println("If your interface is not public, Make it");
	       	throw new IllegalStateException("The script does not implement the Multiplier interface.");
	       }		
		System.out.println(multiplier.mul(2, 3)); 
	}
	
	private static void runJavaInNashorn() throws FileNotFoundException, ScriptException{
		Invocable invocable = (Invocable) engine;
		String scriptFile = "src/com/demo_05/nashorn/Java.js";
		FileReader fr = new FileReader(scriptFile);
		BufferedReader br = new BufferedReader(fr);
		
		engine.eval(br);
	}
	
	public static void main(String... args) throws Throwable {
		executeJs();
//		invokeJs();
//		convertToReferenceOnJavaInterface();
//		runJavaInNashorn();
	  }
}