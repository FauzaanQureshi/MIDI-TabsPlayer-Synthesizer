package JavaProg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

//import java.util.Scanner;

import JavaProg.SimpleSynth;

public class TestSound{

	static {
		System.loadLibrary("NoteInput");
	}
	static boolean susFlag;
	private native char getKey();

	public static void main(String[] args) {
		//TestSound ts = new TestSound();
	
		SimpleSynth synth = new SimpleSynth();
		//Scanner charScan = new Scanner(System.in);
		char c = 'w';
		int oct = 0;
		
		int instrument = 0;
		c = new TestSound().getKey();
		String[] inames = {"0 Acoustic Grand Piano",
			"\n1 Bright Acoustic Piano",
			"\n2 Electric Grand Piano",
			"\n3 Honky-tonk Piano",
			"\n4 Electric Piano 1",
			"\n5 Electric Piano 2",
			"\n6 Harpsichord",
			"\n7 Clavi",
			"\n8 Celesta",
			"\n9 Glockenspiel",
			"\n10 Music Box",
			"\n11 Vibraphone",
			"\n12 Marimba",
			"\n13 Xylophone",
			"\n14 Tubular Bells",
			"\n15 Dulcimer",
			"\n16 Drawbar Organ",
			"\n17 Percussive Organ",
			"\n18 Rock Organ",
			"\n19 Church Organ",
			"\n20 Reed Organ",
			"\n21 Accordion",
			"\n22 Harmonica",
			"\n23 Tango Accordion",
			"\n24 Acoustic Guitar (nylon)",
			"\n25 Acoustic Guitar (steel)",
			"\n26 Electric Guitar (jazz)",
			"\n27 Electric Guitar (clean)",
			"\n28 Electric Guitar (muted)",
			"\n29 Overdriven Guitar",
			"\n30 Distortion Guitar",
			"\n31 Guitar harmonics",
			"\n32 Acoustic Bass",
			"\n33 Electric Bass (finger)",
			"\n34 Electric Bass (pick)",
			"\n35 Fretless Bass",
			"\n36 Slap Bass 1",
			"\n37 Slap Bass 2",	
			"\n38 Synth Bass 1",
			"\n39 Synth Bass 2 10",
			"\n40 Violin",
			"\n41 Viola",
			"\n42 Cello",
			"\n43 Contrabass",
			"\n44 Tremolo Strings",
			"\n45 Pizzicato Strings",
			"\n46 Orchestral Harp",
			"\n47 Timpani",
			"\n48 String Ensemble 1",
			"\n49 String Ensemble 2",
			"\n50 SynthStrings 1",
			"\n51 SynthStrings 2",
			"\n52 Choir Aahs",
			"\n53 Voice Oohs",
			"\n54 Synth Voice",
			"\n55 Orchestra Hit",
			"\n56 Trumpet",
			"\n57 Trombone",
			"\n58 Tuba",
			"\n59 Muted Trumpet",
			"\n60 French Horn",
			"\n61 Brass Section",
			"\n62 SynthBrass 1",
			"\n63 SynthBrass 2",
			"\n64 Soprano Sax",
			"\n65 Alto Sax",
			"\n66 Tenor Sax",
			"\n67 Baritone Sax",
			"\n68 Oboe",
			"\n69 English Horn",
			"\n70 Bassoon",
			"\n71 Clarinet",
			"\n72 Piccolo",
			"\n73 Flute",
			"\n74 Recorder",
			"\n75 Pan Flute",
			"\n76 Blown Bottle",
			"\n77 Shakuhachi",
			"\n78 Whistle",
			"\n79 Ocarina",
			"\n80 Lead 1 (square)",
			"\n81 Lead 2 (sawtooth)",
			"\n82 Lead 3 (calliope)",
			"\n83 Lead 4 (chiff)",
			"\n84 Lead 5 (charang)",
			"\n85 Lead 6 (voice)",
			"\n86 Lead 7 (fifths)",
			"\n87 Lead 8 (bass + lead)",
			"\n88 Pad 1 (new age)",
			"\n89 Pad 2 (warm)",
			"\n90 Pad 3 (polysynth)",
			"\n91 Pad 4 (choir)",
			"\n92 Pad 5 (bowed)",
			"\n93 Pad 6 (metallic)",
			"\n94 Pad 7 (halo)",
			"\n95 Pad 8 (sweep)",
			"\n96 FX 1 (rain)",
			"\n97 FX 2 (soundtrack)",
			"\n98 FX 3 (crystal)",
			"\n99 FX 4 (atmosphere)",
			"\n100 FX 5 (brightness)",
			"\n101 FX 6 (goblins)",
			"\n102 FX 7 (echoes)",
			"\n103 FX 8 (sci-fi)",
			"\n104 Sitar",
			"\n105 Banjo",
			"\n106 Shamisen",
			"\n107 Koto",
			"\n108 Kalimba",
			"\n109 Bag pipe",
			"\n110 Fiddle",
			"\n111 Shanai",
			"\n112 Tinkle Bell",
			"\n113 Agogo",
			"\n114 Steel Drums",
			"\n115 Woodblock",
			"\n116 Taiko Drum",
			"\n117 Melodic Tom",
			"\n118 Synth Drum",
			"\n119 Reverse Cymbal",
			"\n120 Guitar Fret Noise",
			"\n121 Breath Noise",
			"\n122 Seashore",
			"\n123 Bird Tweet",
			"\n124 Telephone Ring",
			"\n125 Helicopter",
			"\n126 Applause",
			"\n127 Gunshot"};
		Map<Character, Integer> kMap = new HashMap<Character,Integer>();
		kMap.put('w', 37);
		kMap.put('e', 39);
		kMap.put('r', 33);
		kMap.put('t', 42);
		kMap.put('y', 44);
		kMap.put('u', 46);
		kMap.put('i', 37);
		kMap.put('o', 49);
		kMap.put('p', 51);
		kMap.put('[', 40);
		kMap.put(']', 54);
		kMap.put('\\', 56);
		kMap.put('7', 58);
		kMap.put('8', 44);
		kMap.put('9', 61);
		kMap.put('+', 46);
		kMap.put('a', 36);
		kMap.put('s', 38);
		kMap.put('d', 40);
		kMap.put('f', 41);
		kMap.put('g', 43);
		kMap.put('h', 45);
		kMap.put('j', 47);
		kMap.put('k', 48);
		kMap.put('l', 50);
		kMap.put(';', 52);
		kMap.put('\'', 53);
		kMap.put('\r', 55);
		kMap.put('4', 57);
		kMap.put('5', 59);
		kMap.put('6', 60);
		kMap.put('z', 62);
		kMap.put('x', 63);
		kMap.put('c', 64);
		kMap.put('v', 65);
		kMap.put('b', 66);
		kMap.put('n', 67);
		kMap.put('m', 68);
		kMap.put(',', 69);
		kMap.put('.', 70);
		kMap.put('/', 71);
		kMap.put('1', 72);
		kMap.put('2', 73);
		kMap.put('3', 74);
		/*
		int note[] = {45,49,45,49,44,50,44,49,45};
		int i = 0;
		*/
		
		System.out.println("________________________________________");
		System.out.println("|                                      |");
		System.out.println("|              SYNTHESIZER             |");
		System.out.println("|                                      |");
		System.out.println("|        0       -> Change Instrument  |");
		System.out.println("|        1       -> Select Octave #1   |");
		System.out.println("|        2       -> Select Octave #2   |");
		System.out.println("|        3       -> Select Octave #3   |");
		System.out.println("|        q       -> QUIT               |");
		System.out.println("|     <space>    -> Overlap Off        |");
		System.out.println("| <space><space> -> Overlap On         |");
		System.out.println("|                                      |");
		System.out.println("|                                      |");
		System.out.println("+--------------------------------------+");
		
		while (c != 'q') {
			if (c>='1' && c<='3'){
				oct = 12 * (Integer.valueOf(c).intValue()-49);
				System.out.println(oct);
				c = new TestSound().getKey();
			}
			else if (c=='0'){
			synth.allNotesOff();
			System.out.println(Arrays.toString(inames) + '\n');
				instrument = new Scanner(System.in).nextInt();
				synth.setInstrument(instrument);
				c = new TestSound().getKey();
			}
			else if (c==' '){
				synth.allNotesOff();
				//System.out.println("Space pressed once");
				c = new TestSound().getKey();
				if (c == ' '){
					susFlag = false;
					//System.out.println("Space pressed twice");
					c = new TestSound().getKey();
				}
				else{
					susFlag = true;
					//System.out.println("Space pressed once");
				}
				continue;
			}
			if (susFlag)
				synth.allNotesOff();
			synth.noteOn((kMap.get(c)+oct));
			System.out.println((kMap.get(c)+oct) + "\t\t" + nName(kMap.get(c)+oct) + "\t\t" + susFlag);
			
			c = new TestSound().getKey();
		}
	}
	
	public static String nName(int n){
		int k = n%12;
		int o = (n/12)-1+48;
		char[] s = new char[3];
		
		switch(k){
			case 0: s[0] = 'C'; s[1] = ' '; break;
			case 1: s[0] = 'C'; s[1] = '#'; break;
			case 2: s[0] = 'D'; s[1] = ' '; break;
			case 3: s[0] = 'D'; s[1] = '#'; break;
			case 4: s[0] = 'E'; s[1] = ' '; break;
			case 5: s[0] = 'F'; s[1] = ' '; break;
			case 6: s[0] = 'F'; s[1] = '#'; break;
			case 7: s[0] = 'G'; s[1] = ' '; break;
			case 8: s[0] = 'G'; s[1] = '#'; break;
			case 9: s[0] = 'A'; s[1] = ' '; break;
			case 10: s[0] = 'A'; s[1] = '#'; break;
			case 11: s[0] = 'B'; s[1] = ' '; break;
			default: s[0] = '-'; s[1] = ' '; break;
		}
		s[2] = (char)o;
		String name = new String(s);
		return name;
	}
}
	