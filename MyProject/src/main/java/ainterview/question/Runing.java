package ainterview.question;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runing {
	int ab;
	int abcd;

	public Runing(int abc) {
		abcd = ab + abc;
		System.out.println("sum : " + abcd);
	}

	public static void main(String[] args) throws UnknownHostException {

		new Runing(new Integer(4));

		// int in = process();
		String ine = null;
		String st = "ss";
		boolean ch = ine instanceof Object;
		System.out.println(" Instance check " + ch);
		if (st instanceof Object) {
			System.out.println(" st instance of Object and its value " + st);
		} else {
			System.out.println(" Not an object " + st);
		}

		Runtime r = Runtime.getRuntime();

		long freemem = r.freeMemory();
		long totalmem = r.totalMemory();
		long maxmem = r.maxMemory();
		long diff = totalmem - freemem;

		System.out.println(" Free Memory : " + freemem);
		System.out.println(" Max Memory : " + totalmem);
		System.out.println(" Diff " + diff + " Availabe Process : " + r.availableProcessors());
		try {
			FileReader fr = new FileReader("D:/test.txt");

			System.out.println(" File Read " + fr.read());
		} catch (Exception e) {
			e.printStackTrace();
		}

		int x = 9;
		if (x == 9) {
			// int x =8;
			System.out.println("x is 9");
		}

		/*
		 * Configuration cf = new Configuration(); System.out.println("cf : " +
		 * cf); Configuration conf= cf.addXML(
		 * "D:/eclipse/workspace/MyProject/WebContent/resources/persistence-beans.xml"
		 * ); SessionFactory sf=cf.buildSessionFactory();
		 * System.out.println("Session fatory : " + sf);
		 */

		InetAddress obj1 = InetAddress.getByName("sanfoundary.com");
		InetAddress obj2 = InetAddress.getByName("sanfoundary.com");
		boolean xa = obj1.equals(obj2);
		System.out.println(xa);
		System.out.println("-----------------------");
		String dk = "dhiraj";
		char[] cha = new char[8];
		dk.getChars(2, 5, cha, 0);
		for (char chh : cha) {
			System.out.println("Character copied : " + chh);
		}

		int num = 10;
		for (int i = 10; i > 1; --i) {
			System.out.println(" value of I : " + i);
			num = num;
			System.out.println(" Number : " + num);
		}

		Map<Integer, String> mp = new HashMap();

		for (int i = 0; i < 10; i++) {
			String value = "Dhiraj - " + i;
			mp.put(i, value);
		}
		Iterator it = mp.keySet().iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(" Map Value : " + mp.get(obj));
		}

		Queue queueA = new LinkedList();

		queueA.add("element 0");
		queueA.add("element 1");
		queueA.add("element 2");

		for (int ab = 0; ab < 3; ab++) {
			System.out.println(" Que element : " + queueA);
		}

		// access via Iterator
		Iterator iterator = queueA.iterator();
		while (iterator.hasNext()) {
			String element = (String) iterator.next();
			System.out.println(" Que Iteration : " + element);
		}

		Stack sk = new Stack();
		sk.add("1");
		sk.add("2");
		sk.add("3");

		for (int ab = 0; ab < 3; ab++) {
			System.out.println(" Stack element : " + sk.elements().nextElement());
		}

		System.out.println("======================");
		Deque<String> deque = new LinkedList<String>();
		deque.add("one");
		deque.add("two");
		deque.add("three");
		deque.add("four");
		for (int i = 0; i < deque.size();) {
		System.out.println("poll last : " + deque.pollLast());
		}
	
		r.gc();

	}

	public static int process() {
		String st = null;
		return Integer.parseInt(st);
	}
}
