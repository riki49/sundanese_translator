package sunda.util;

public class SundaneseFontTranslator {

	private String sundaneseCharacter;

	public SundaneseFontTranslator(String sundaneseCharacter) {
		this.sundaneseCharacter = sundaneseCharacter;
	}

	public String translate() {
		switch (this.sundaneseCharacter) {
		case "panyck":
			return "\u1b80";
		case "pnglyr":
			return "\u1b81";
		case "pngwsd":
			return "\u1b82";
		case "a":
			return "\u1b83";
		case "i":
			return "\u1b84";
		case "u":
			return "\u1b85";
		case "e'":
			return "\u1b86";
		case "o":
			return "\u1b87";
		case "e":
			return "\u1b88";
		case "eu":
			return "\u1b889";
		case "ka":
			return "\u1b8a";
		case "qa":
			return "\u1b8b";
		case "ga":
			return "\u1b8c";
		case "nga":
			return "\u1b8d";
		case "ca":
			return "\u1b8e";
		case "ja":
			return "\u1b8f";
		case "za":
			return "\u1b90";
		case "nya":
			return "\u1b91";
		case "ta":
			return "\u1b92";
		case "da":
			return "\u1b93";
		case "na":
			return "\u1b94";
		case "pa":
			return "\u1b95";
		case "fa":
			return "\u1b96";
		case "va":
			return "\u1b97";
		case "ba":
			return "\u1b98";
		case "ma":
			return "\u1b99";
		case "ya":
			return "\u1b9a";
		case "ra":
			return "\u1b9b";
		case "la":
			return "\u1b9c";
		case "wa":
			return "\u1b9d";
		case "sa":
			return "\u1b9e";
		case "xa":
			return "\u1b9f";
		case "ha":
			return "\u1ba0";
		case "kha":
			return "\u1bae";
		case "sya":
			return "\u1baf";
		case "0":
			return "\u1bb0";
		case "1":
			return "\u1bb1";
		case "2":
			return "\u1bb2";
		case "3":
			return "\u1bb3";
		case "4":
			return "\u1bb4";
		case "5":
			return "\u1bb5";
		case "6":
			return "\u1bb6";
		case "7":
			return "\u1bb7";
		case "8":
			return "\u1bb8";
		case "9":
			return "\u1bb9";
		case "pmngkl":
			return "\u1ba1";
		case "pnykra":
			return "\u1ba2";
		case "panyiku":
			return "\u1ba3";
		case "pnghlu":
			return "\u1ba4";
		case "pnyuku":
			return "\u1ba5";
		case "pnle'ng":
			return "\u1ba6";
		case "pnlong":
			return "\u1ba7";
		case "pmepet":
			return "\u1ba8";
		case "pnleung":
			return "\u1ba9";
		case "pamaeh":
			return "\u1baa";
		case "_ma":
			return "\u1bac";
		case "_wa":
			return "\u1bad";
		case "":
			return " ";
		case "reu":
			return "\u1bbb";
		case "leu":
			return "\u1bbc";
		case "bha":
			return "\u1bbd";
		case "k":
			return "\u1bbe";
		case "m":
			return "\u1bbf";
		}
		return this.sundaneseCharacter;
	}

	public boolean isHanacaraka() {
		return this.sundaneseCharacter.equals("ha")
				|| sundaneseCharacter.equals("na")
				|| sundaneseCharacter.equals("ca")
				|| sundaneseCharacter.equals("ra")
				|| sundaneseCharacter.equals("ka")
				|| sundaneseCharacter.equals("da")
				|| sundaneseCharacter.equals("ta")
				|| sundaneseCharacter.equals("sa")
				|| sundaneseCharacter.equals("wa")
				|| sundaneseCharacter.equals("la")
				|| sundaneseCharacter.equals("nga")
				|| sundaneseCharacter.equals("ba")
				|| sundaneseCharacter.equals("nya")
				|| sundaneseCharacter.equals("ta")
				|| sundaneseCharacter.equals("qa")
				|| sundaneseCharacter.equals("ga")
				|| sundaneseCharacter.equals("ja")
				|| sundaneseCharacter.equals("za")
				|| sundaneseCharacter.equals("pa")
				|| sundaneseCharacter.equals("fa")
				|| sundaneseCharacter.equals("va")
				|| sundaneseCharacter.equals("ma")
				|| sundaneseCharacter.equals("ya")
				|| sundaneseCharacter.equals("xa");
	}
}
