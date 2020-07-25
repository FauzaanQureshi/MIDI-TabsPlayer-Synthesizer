package JavaProg;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Arrays;

//import java.util.Scanner;

import JavaProg.SimpleSynth;

public class MusicSheetReader{
	//static int counter = 0;
	//static int nano = 0;
	public static void main(String[] args) throws InterruptedException{
		SimpleSynth synth = new SimpleSynth();
		
		/* Set of functional keys */
		HashSet<Character> keys = new HashSet<>();
		keys.add('-');
		keys.add('_');
		keys.add('.');
		keys.add('A');
		keys.add('B');
		keys.add('C');
		keys.add('D');
		keys.add('E');
		keys.add('F');
		keys.add('G');
		keys.add('b');
		keys.add('s');
		keys.add('i');
		keys.add('m');
		keys.add('q');
		
		char key,octave;
		key = octave = 0;
		int i = 0;
		
		FileReader sheet = null;
		String f_arr[] = new File("C:\\Users\\Fauzaan\\Desktop\\MusicSheets\\").list((d, s) -> {return s.toLowerCase().endsWith(".sheet");});
		for(String f : f_arr){System.out.println(String.format("%d %s",i++,f));}
		System.out.println("\n\nEnter File Index: ");
		//System.exit(0);
		try {
			String f = f_arr[new Scanner(System.in).nextInt()];
			System.out.println("C:\\Users\\Fauzaan\\Desktop\\MusicSheets\\"+f);
			sheet = new FileReader("C:\\Users\\Fauzaan\\Desktop\\MusicSheets\\"+f);
		} catch (FileNotFoundException e2) {e2.printStackTrace();}
		
		int instrument = 0;
		char note[] = {0,0,0};
		char ins[]={' ',' ',' '}; 
		boolean flag = false;
		
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
		kMap.put("C#4", 61);
		kMap.put("D4 ", 62);
		kMap.put("D#4", 63);
		kMap.put("E4 ", 64);
		kMap.put("F4 ", 65);
		kMap.put("F#4", 66);
		kMap.put("G4 ", 67);
		kMap.put("G#4", 68);
		kMap.put("A4 ", 69);
		kMap.put("A#4", 70);
		kMap.put("B4 ", 71);
		kMap.put("C5 ", 72);
		kMap.put("C#5", 73);
		kMap.put("D5 ", 74);
		kMap.put("D#5", 75);
		kMap.put("E5 ", 76);
		kMap.put("F5 ", 77);
		kMap.put("F#5", 78);
		kMap.put("G5 ", 79);
		kMap.put("G#5", 80);
		kMap.put("A5 ", 81);
		kMap.put("A#5", 82);
		kMap.put("B5 ", 83);
		kMap.put("C6 ", 84);
		kMap.put("C#6", 85);
		kMap.put("D6 ", 86);
		kMap.put("D#6", 87);
		kMap.put("E6 ", 88);
		kMap.put("F6 ", 89);
		kMap.put("F#6", 90);
		kMap.put("G6 ", 91);
		kMap.put("G#6", 92);
		kMap.put("A6 ", 93);
		kMap.put("A#6", 94);
		kMap.put("B6 ", 95);
		kMap.put("C7 ", 96);
		kMap.put("C#7", 97);
		kMap.put("D7 ", 98);
		kMap.put("D#7", 99);
		kMap.put("E7 ",100);
		kMap.put("F7 ",101);
		kMap.put("F#7", 102);
		kMap.put("G7 ",103);
		kMap.put("G#7", 104);
		kMap.put("A7 ",105);
		kMap.put("B7 ",107);
		
		while (key != 'q') {
			try {

				key = (char) sheet.read();
				if (key=='<'){  /*Comments in File*/
					key = (char) sheet.read();
					while (key!='>'){
						System.out.print(key);
						key = (char) sheet.read();
					}
					System.out.println(' ');
				}
				
				if (!keys.contains(key)){ /*If not func key, read next*/
					key=0;
				}
				
				if (key=='i'){ /*Change Instrument for single note*/
					flag = true;
					sheet.read();
					key = (char) sheet.read();
					Arrays.fill(ins, ' ');
					i = 2;
					
					while (key!='>'){
						ins[i--] = key;
						key = (char) sheet.read();
					}
					key = ins[2];
					ins[2] = ins[0];
					ins[0] = key;
					
					instrument = Integer.parseInt(String.valueOf(ins).trim());
					//System.out.println("\n\n");
					//System.out.println(instrument);
					//System.exit(0);
					synth.setInstrument(instrument);
					key = 0;
				}
				
			} catch (IOException e1) {e1.printStackTrace();}
			
			switch (key) {
			case '-':  /* (1/4)s  */
				Thread.sleep(250);
				break;
			case '.':  /* (1/16)s */
				Thread.sleep(62,500000);
				break;
			case '_':  /* (1/8)s  */
				Thread.sleep(125);
				break;
			case 'm':  /* Stop All Note */
				synth.allNotesOff();
				break;
			case 'q':  /* EXIT */
				System.exit(0);
				break;
			case 0:    /* Non Functional keys */
				break;
			default:   /* Playable Keys */
				
				if (key == 'b')
					try {
						key = (char) sheet.read();
						synth.setVolume(127);
					} catch (IOException e1) {e1.printStackTrace();}
				else if (key == 's')
					try {
						key = (char) sheet.read();
						synth.setVolume(90);
					} catch (IOException e1) {e1.printStackTrace();}
				else
					synth.setVolume(109);
					
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
				
				System.out.println(note);
				
				if (flag){
					flag = false;
					instrument = 0;
					synth.setInstrument(instrument);
				}
				
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
