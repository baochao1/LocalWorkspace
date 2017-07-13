package main.webapp;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Sysinprint {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("what's your name?");
		String name = in.nextLine();
		System.out.println(name);
	}
}
