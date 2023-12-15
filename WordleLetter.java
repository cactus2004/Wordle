public class WordleLetter {

	// TODO - implement according to spec
	private char letter;
	private String color;

	//Constructor
	public WordleLetter (char letter){
		this.letter = letter;
	}

	public void setColor(String color){
		this.color = color;
	}

	public boolean isColorSet(){
		if (color != null) {
			return true;
		}
		return false;
	}

	public boolean isGreen(){
		if(color == null){
			return false;
		}
		if(color.equals("green")){
			return true;
		}
		return false;
	}

	public char getLetter(){
		return this.letter;
	}


	
	public String toString() {

	String colorCode;
		if(color.equals("green")) {
	 		colorCode = "\u001B[32m";
	 	} else if(color.equals("yellow")) {
	 		colorCode = "\u001B[33m";
	 	} else if(color == null){
	 		colorCode = "\u001B[31m";
	 	}else{
	 		colorCode = "\u001B[31m";
		}
	
		// These are the special character to add
		// to the end of the String
		// to signify the end of the color change.
	 	String resetCode = "\u001B[0m";
	
		// Surround the letter with
		// space characters and with
		// the above color changing special characters.
		
	 	return String.format(
	 		"%s %s %s",
	 		colorCode, letter, resetCode);
	 }

}
