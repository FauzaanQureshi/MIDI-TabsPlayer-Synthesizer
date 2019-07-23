package JavaProg;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//import java.util.Scanner;

import JavaProg.SimpleSynth;

public class MusicSheetReader{
	static int counter = 0;
	static int nano = 0;
	public static void main(String[] args) throws InterruptedException{
		SimpleSynth synth = new SimpleSynth();
		
		char key,octave;
		key = octave = 0;
		
		//int counter = 0;
		
		FileReader sheet = null;
		try {
			sheet = new FileReader("Sheet_1.txt");
		} catch (FileNotFoundException e2) {e2.printStackTrace();}
		char note[] = {0,0,0}; 
		Map<String, Integer> kMap = new HashMap<String,Integer>();
		
		kMap.put("C0 ", 12);
		kMap.put("D0 ", 14);
		kMap.put("E0 ", 16);
		kMap.put("F0 ", 17);
		kMap.put("G0 ", 19);
		kMap.put("A0 ", 21);
		kMap.put("B0 ", 23);
		kMap.put("C1 ", 24);
		kMap.put("D1 ", 26);
		kMap.put("E1 ", 28);
		kMap.put("F1 ", 29);
		kMap.put("G1 ", 31);
		kMap.put("A1 ", 33);
		kMap.put("B1 ", 35);
		kMap.put("C2 ", 36);
		kMap.put("C#2", 37);
		kMap.put("D2 ", 38);
		kMap.put("D#2", 39);
		kMap.put("E2 ", 40);
		kMap.put("F2 ", 41);
		kMap.put("F#2", 42);
		kMap.put("G2 ", 43);
		kMap.put("G#2", 44);
		kMap.put("A2 ", 45);
		kMap.put("A#2", 46);
		kMap.put("B2 ", 47);
		kMap.put("C3 ", 48);
		kMap.put("C#3", 49);
		kMap.put("D3 ", 50);
		kMap.put("D#3", 51);
		kMap.put("E3 ", 52);
		kMap.put("F3 ", 53);
		kMap.put("F#3", 54);
		kMap.put("G3 ", 55);
		kMap.put("G#3", 56);
		kMap.put("A3 ", 57);
		kMap.put("A#3", 58);
		kMap.put("B3 ", 59);
		kMap.put("C4 ", 60);
		kMap.put("D4 ", 62);
		kMap.put("E4 ", 64);
		kMap.put("F4 ", 65);
		kMap.put("G4 ", 67);
		kMap.put("A4 ", 69);
		kMap.put("B4 ", 71);
		kMap.put("C5 ", 72);
		kMap.put("D5 ", 74);
		kMap.put("E5 ", 76);
		kMap.put("F5 ", 77);
		kMap.put("G5 ", 79);
		kMap.put("A5 ", 81);
		kMap.put("B5 ", 83);
		kMap.put("C6 ", 84);
		kMap.put("D6 ", 86);
		kMap.put("E6 ", 88);
		kMap.put("F6 ", 89);
		kMap.put("G6 ", 91);
		kMap.put("A6 ", 93);
		kMap.put("B6 ", 95);
		kMap.put("C7 ", 96);
		kMap.put("D7 ", 98);
		kMap.put("E7 ",100);
		kMap.put("F7 ",101);
		kMap.put("G7 ",103);
		kMap.put("A7 ",105);
		kMap.put("B7 ",107);
		
		while (key != 'q') {
			try {

				key = (char) sheet.read();
				if (key !='-' && key !='.' && key !='q' && key !='A'&& key !='B'&& key !='b'&& key !='C'&& key !='D'&& key !='E'&& key !='F'&& key !='G')
					key=0;
			} catch (IOException e1) {e1.printStackTrace();}
			switch (key) {
			case '-':
				counter++;
				break;
			case '.':
				nano++;
				break;
			case 'q':
				System.exit(0);
				break;
			case 0:
				break;
			default:
				
				if (key == 'b')
					try {
						key = (char) sheet.read();
						synth.setVolume(110);
					} catch (IOException e1) {e1.printStackTrace();}
				else
					synth.setVolume(80);
					
				try {
					octave = (char) sheet.read();
				} catch (IOException e) {e.printStackTrace();}
				if (octave == '#'){
					note[0] = key;
					note[1] = octave;
					try{note[2] = (char) sheet.read();}catch(IOException e3){e3.printStackTrace();}
				}
				else{
					note[0] = key;
					note[1] = octave;
					note[2] = ' ';
				}	
				synth.noteOn(kMap.get(new String(note)));
				Thread.sleep(250*counter,62500*nano);
				System.out.println(counter);
				
				System.out.println(note);
				counter = 0;
				nano = 0;
				break;
			}/*
			if (key == 'A' || key == 'B' || key == 'C' || key == 'D' || key == 'E' || key == 'F' || key == 'G') {
				counter = 0;
				try {
					octave = (char) sheet.read();
				} catch (IOException e) {e.printStackTrace();}
				note[0] = key;
				note[1] = octave;
				System.out.println(note);
				
				synth.noteOn(kMap.get(new String(note)));
			}
			
			else if (key == ' '){
				counter++;
			}
			*/
			/*try {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							Thread.sleep(500*beats());
						} catch (InterruptedException e) {e.printStackTrace();}
						
					}
				}).join();
			} catch (InterruptedException e) {e.printStackTrace();}*/
		}
	}
}