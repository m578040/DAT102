package no.hvl.dat102;

import java.util.*;

public class TidPaSok {
	public static void main(String[] args) {
		int tall = 376;
		int antElement = 100000;
		int område = 999999;
		Random tilfeldig = new Random();
		HashSet<Integer> hSet = new HashSet<Integer>(100000);
		Integer[] tab = new Integer[100000];
		Integer[] sokeTall = new Integer[10000];
		int hSetAntall = 0;
		int tabAntall = 0;
		
		for (int i = 0; i < antElement; i++) {
			tall = (tall + 45713) % 1000000;
			hSet.add(tall);
			tab[i] = tall;
		}
		
		Arrays.sort(tab);
		
		for (int i = 0; i < sokeTall.length; i++) {
			sokeTall[i] = tilfeldig.nextInt(område);
		}
		
		long startTid = System.nanoTime();
		for (Integer i : sokeTall) {
			if (hSet.contains(i)) {
				hSetAntall++;
			}
		}
		long sluttTid = System.nanoTime();
		double hSetTid = ((double)(sluttTid - startTid))/1000000;
		
		startTid = System.nanoTime();
		for (Integer i : sokeTall) {
			int funnet = Arrays.binarySearch(tab, i);
			if (funnet >= 0) {
				tabAntall++;
			}
		}
		sluttTid = System.nanoTime();
		double tabTid = ((double)(sluttTid - startTid))/1000000;
		
		System.out.println("HashSet:");
		System.out.println("Tall funnet: " + hSetAntall);
		System.out.println("Tid brukt: " + hSetTid + "ms");
		System.out.println();
		System.out.println("Tabell:");
		System.out.println("Tall funnet: " + tabAntall);
		System.out.println("Tid brukt: " + tabTid + "ms");
	}}