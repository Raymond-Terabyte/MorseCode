
import java.util.*;

public class MorseCode {

	static String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "0"};

	static String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
			"....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
			"--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
			"-.--", "--..", ".----", "..---", "...--", "....-", ".....",
			"-....", "--...", "---..", "----.", "-----"};

	//hashmap
	public static void translator(HashMap<String, String> map, String morseCode, String decoded, ArrayList<String> options) { //substring for loop
		if(morseCode.length() == 0) {
			return;
		}
		for(int i = 0; i < morseCode.length(); i++) {
			String str = morseCode.substring(0,i+1);
			if(map.containsKey(str)) {
				String next = decoded + map.get(str);
				String rem = morseCode.substring(i+1);
				if(rem.length() == 0) {
					options.add(next);
				} else {
					translator(map, rem, next, options);
				}
			}
		}
	}

	public static void main(String[] args){
		HashMap<String, String> morseConverter = new HashMap<>();
		for(int i=0; i < morse.length; i++){
			morseConverter.put(morse[i], alphabet[i]); 
		}
		ArrayList<String> options = new ArrayList<String>();
		translator(morseConverter, "-.-.-", "", options); //input morsecode here
		System.out.println(options);
	}
}