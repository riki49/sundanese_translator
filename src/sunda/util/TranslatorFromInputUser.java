package sunda.util;

public class TranslatorFromInputUser {

	public String singgleChar(String text) {
		switch (text) {
			case " ":
				return " ";
			case "a":
				return "\u1b83";
			case "b":
				return "\u1b98 \u1baa";
			case "c":
				return "\u1b8e \u1baa";
			case "d":
				return "\u1b93 \u1baa";
			case "e":
				return "\u1b88";
			case "f":
				return "\u1b96 \u1baa";
			case "g":
				return "\u1b8c \u1baa";
			case "h":
				return "\u1ba0 \u1baa";
			case "i":
				return "\u1b84";
			case "j":
				return "\u1b8f \u1baa";
			case "k":
				return "\u1b8a \u1baa";
			case "l":
				return "\u1b9c \u1baa";
			case "m":
				return "\u1b99 \u1baa";
			case "n":
				return "\u1b94 \u1baa";
			case "o":
				return "\u1b87";
			case "p":
				return "\u1b95 \u1baa";
			case "q":
				return "\u1b8b \u1baa";
			case "r":
				return "\u1b9b \u1baa";
			case "s":
				return "\u1b9e \u1baa";
			case "t":
				return "\u1b92 \u1baa";
			case "u":
				return "\u1b85";
			case "v":
				return "\u1b97 \u1baa";
			case "w":
				return "\u1b9d \u1baa";
			case "x":
				return "\u1b9f \u1baa";
			case "y":
				return "\u1b9a \u1baa";
			case "z":
				return "\u1b90 \u1baa";

		}
		return text;
	}


	public String doubleCharacter (String inputFromUser) {
		switch (inputFromUser) {
			case "eu":
				return "\u1b89";
			case "e`":
				return "\u1b86";
		/*
		 * a
		 */
			case "ka":
				return "\u1b8a";
			case "qa":
				return "\u1b8b";
			case "ga":
				return "\u1b8c";
			case "ca":
				return "\u1b8e";
			case "ja":
				return "\u1b8f";
			case "za":
				return "\u1b90";
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
			/*
			 * i
			 */
			case "ki":
				return "\u1b8a" + "\u1ba4";
			case "qi":
				return "\u1b8b" + "\u1ba4";
			case "gi":
				return "\u1b8c" + "\u1ba4";
			case "ci":
				return "\u1b8e" + "\u1ba4";
			case "ji":
				return "\u1b8f" + "\u1ba4";
			case "zi":
				return "\u1b90" + "\u1ba4";
			case "ti":
				return "\u1b92" + "\u1ba4";
			case "di":
				return "\u1b93" + "\u1ba4";
			case "ni":
				return "\u1b94" + "\u1ba4";
			case "pi":
				return "\u1b95" + "\u1ba4";
			case "fi":
				return "\u1b96" + "\u1ba4";
			case "vi":
				return "\u1b97" + "\u1ba4";
			case "bi":
				return "\u1b98" + "\u1ba4";
			case "mi":
				return "\u1b99" + "\u1ba4";
			case "yi":
				return "\u1b9a" + "\u1ba4";
			case "ri":
				return "\u1b9b" + "\u1ba4";
			case "li":
				return "\u1b9c" + "\u1ba4";
			case "wi":
				return "\u1b9d" + "\u1ba4";
			case "si":
				return "\u1b9e" + "\u1ba4";
			case "xi":
				return "\u1b9f" + "\u1ba4";
			case "hi":
				return "\u1ba0" + "\u1ba4";
			/*
			 * o
			 */
			case "wo":
				return "\u1b9d" + "\u1ba7";
			case "so":
				return "\u1b9e" + "\u1ba7";
			case "xo":
				return "\u1b9f" + "\u1ba7";
			case "ho":
				return "\u1ba0" + "\u1ba7";
			case "lo":
				return "\u1b9c" + "\u1ba7";
			case "ro":
				return "\u1b9b" + "\u1ba7";
			case "ko":
				return "\u1b8a" + "\u1ba7";
			case "qo":
				return "\u1b8b" + "\u1ba7";
			case "go":
				return "\u1b8c" + "\u1ba7";
			case "co" :
				return "\u1b8e" + "\u1ba7";
			case "jo":
				return "\u1b8f" + "\u1ba7";
			case "zo":
				return "\u1b90" + "\u1ba7";
			case "to":
				return "\u1b92" + "\u1ba7";
			case "do":
				return "\u1b93" + "\u1ba7";
			case "no":
				return "\u1b94" + "\u1ba7";
			case "po":
				return "\u1b95" + "\u1ba7";
			case "fo":
				return "\u1b96" + "\u1ba7";
			case "vo":
				return "\u1b97" + "\u1ba7";
			case "bo":
				return "\u1b98" + "\u1ba7";
			case "mo":
				return "\u1b99" + "\u1ba7";
			case "yo":
				return "\u1b9a" + "\u1ba7";
			/*
			 * u
			 */
			case "ku":
				return "\u1b8a" + "\u1ba5";
			case "qu":
				return "\u1b8b" + "\u1ba5";
			case "gu":
				return "\u1b8c" + "\u1ba5";
			case "cu":
				return "\u1b8e" + "\u1ba5";
			case "ju":
				return "\u1b8f" + "\u1ba5";
			case "zu":
				return "\u1b90" + "\u1ba5";
			case "tu":
				return "\u1b92" + "\u1ba5";
			case "du":
				return "\u1b93" + "\u1ba5";
			case "nu":
				return "\u1b94" + "\u1ba5";
			case "pu":
				return "\u1b95" + "\u1ba5";
			case "fu":
				return "\u1b96" + "\u1ba5";
			case "vu":
				return "\u1b97" + "\u1ba5";
			case "bu":
				return "\u1b98" + "\u1ba5";
			case "mu":
				return "\u1b99" + "\u1ba5";
			case "yu":
				return "\u1b9a" + "\u1ba5";
			case "ru":
				return "\u1b9b" + "\u1ba5";
			case "lu":
				return "\u1b9c" + "\u1ba5";
			case "wu":
				return "\u1b9d" + "\u1ba5";
			case "su":
				return "\u1b9e" + "\u1ba5";
			case "xu":
				return "\u1b9f" + "\u1ba5";
			case "hu":
				return "\u1ba0" + "\u1ba5";
			
			/*
			 * e
			 */
			case "ke":
				return "\u1b8a" + "\u1ba8";
			case "qe":
				return "\u1b8b" + "\u1ba8";
			case "ce":
				return "\u1b8e" + "\u1ba8";
			case "je":
				return "\u1b8f" + "\u1ba8";
			case "ze":
				return "\u1b90" + "\u1ba8";
			case "te":
				return "\u1b92" + "\u1ba8";
			case "de":
				return "\u1b93" + "\u1ba8";
			case "ne":
				return "\u1b94" + "\u1ba8";
			case "pe":
				return "\u1b95" + "\u1ba8";
			case "fe":
				return "\u1b96" + "\u1ba8";
			case "ve":
				return "\u1b97" + "\u1ba8";
			case "be":
				return "\u1b98" + "\u1ba8";
			case "me":
				return "\u1b99" + "\u1ba8";
			case "ye":
				return "\u1b9a" + "\u1ba8";
			case "re":
				return "\u1b9b" + "\u1ba8";
			case "le":
				return "\u1b9c" + "\u1ba8";
			case "we":
				return "\u1b9d" + "\u1ba8";
			case "se":
				return "\u1b9e" + "\u1ba8";
			case "xe":
				return "\u1b9f" + "\u1ba8";
			case "he":
				return "\u1ba0" + "\u1ba8";

		}
		return inputFromUser;
	}


	public String tripleChar(String tripleChar) {
		switch (tripleChar) {
		/*
		 * eu
		 */
			case "keu":
				return "\u1b8a" + "\u1ba9";
			case "qeu":
				return "\u1b8b" + "\u1ba9";
			case "geu":
				return "\u1b8c" + "\u1ba9";
			case "ceu":
				return "\u1b8e" + "\u1ba9";
			case "jeu":
				return "\u1b8f" + "\u1ba9";
			case "zeu":
				return "\u1b90" + "\u1ba9";
			case "teu":
				return "\u1b92" + "\u1ba9";
			case "deu":
				return "\u1b93" + "\u1ba9";
			case "neu":
				return "\u1b94" + "\u1ba9";
			case "peu":
				return "\u1b95" + "\u1ba9";
			case "feu":
				return "\u1b96" + "\u1ba9";
			case "veu":
				return "\u1b97" + "\u1ba9";
			case "beu":
				return "\u1b98" + "\u1ba9";
			case "meu":
				return "\u1b99" + "\u1ba9";
			case "yeu":
				return "\u1b9a" + "\u1ba9";
			case "reu":
				return "\u1b9b" + "\u1ba9";
			case "leu":
				return "\u1b9c" + "\u1ba9";
			case "weu":
				return "\u1b9d" + "\u1ba9";
			case "seu":
				return "\u1b9e" + "\u1ba9";
			case "xeu":
				return "\u1b9f" + "\u1ba9";
			case "heu":
				return "\u1ba0" + "\u1ba9";
		/*
		 * e`
		 */
			case "ke`":
				return "\u1ba6" + "\u1b8a";
			case "qe`":
				return "\u1ba6" +  "\u1b8b";
			case "ge`":
				return "\u1ba6" +  "\u1b8c";
			case "ce`":
				return "\u1ba6" +  "\u1b8e";
			case "je`":
				return "\u1ba6" +  "\u1b8f";
			case "ze`":
				return "\u1ba6" + "\u1b90";
			case "te`":
				return "\u1ba6" + "\u1b92";
			case "de`":
				return "\u1ba6" + "\u1b93";
			case "ne`":
				return "\u1ba6" + "\u1b94";
			case "pe`":
				return "\u1ba6" + "\u1b95";
			case "fe`":
				return "\u1ba6" + "\u1b96";
			case "ve`":
				return "\u1ba6" + "\u1b97";
			case "be`":
				return "\u1ba6" + "\u1b98";
			case "me`":
				return "\u1ba6" + "\u1b99";
			case "ye`":
				return "\u1ba6" + "\u1b9a";
			case "re`":
				return "\u1ba6" + "\u1b9b";
			case "le`":
				return "\u1ba6" + "\u1b9c";
			case "we`":
				return "\u1ba6" + "\u1b9d";
			case "se`":
				return "\u1ba6" + "\u1b9e";
			case "xe`":
				return "\u1ba6" + "\u1b9f";
			case "he`":
				return "\u1ba6" + "\u1ba0";
			case "nya":
				return "\u1b91";
			case "nyi":
				return "\u1b91" + "\u1ba4";
			case "nye":
				return "\u1b91" + "\u1ba8";
			case "nyu":
				return "\u1b91" + "\u1ba5";
			case "nyo":
				return "\u1b91" + "\u1ba7";
					/*
		 * a
		 */
			case "kla":
				return "\u1b8a\u1ba3";
			case "qla":
				return "\u1b8b\u1ba3";
			case "gla":
				return "\u1b8c\u1ba3";
			case "cla":
				return "\u1b8eᮣ";
			case "jla":
				return "\u1b8fᮣ";
			case "zla":
				return "\u1b90ᮣ";
			case "tla":
				return "\u1b92ᮣ";
			case "dla":
				return "\u1b93ᮣ";
			case "nla":
				return "\u1b94ᮣ";
			case "pla":
				return "\u1b95ᮣ";
			case "fla":
				return "\u1b96ᮣ";
			case "vla":
				return "\u1b97ᮣ";
			case "bla":
				return "\u1b98ᮣ";
			case "mla":
				return "\u1b99ᮣ";
			case "yla":
				return "\u1b9aᮣ";
			case "rla":
				return "\u1b9bᮣ";
			case "lla":
				return "\u1b9cᮣ";
			case "wla":
				return "\u1b9dᮣ";
			case "sla":
				return "\u1b9eᮣ";
			case "xla":
				return "\u1b9fᮣ";
			case "hla":
				return "\u1ba0ᮣ";
			/*
			 * i
			 */
			case "kli":
				return "\u1b8aᮣ" + "\u1ba4";
			case "qli":
				return "\u1b8bᮣ" + "\u1ba4";
			case "gli":
				return "\u1b8cᮣ" + "\u1ba4";
			case "cli":
				return "\u1b8eᮣ" + "\u1ba4";
			case "jli":
				return "\u1b8fᮣ" + "\u1ba4";
			case "zli":
				return "\u1b90ᮣ" + "\u1ba4";
			case "tli":
				return "\u1b92ᮣ" + "\u1ba4";
			case "dli":
				return "\u1b93ᮣ" + "\u1ba4";
			case "nli":
				return "\u1b94ᮣ" + "\u1ba4";
			case "pli":
				return "\u1b95ᮣ" + "\u1ba4";
			case "fli":
				return "\u1b96ᮣ" + "\u1ba4";
			case "vli":
				return "\u1b97ᮣ" + "\u1ba4";
			case "bli":
				return "\u1b98ᮣ" + "\u1ba4";
			case "mli":
				return "\u1b99ᮣ" + "\u1ba4";
			case "yli":
				return "\u1b9aᮣ" + "\u1ba4";
			case "rli":
				return "\u1b9bᮣ" + "\u1ba4";
			case "lli":
				return "\u1b9cᮣ" + "\u1ba4";
			case "wli":
				return "\u1b9dᮣ" + "\u1ba4";
			case "sli":
				return "\u1b9eᮣ" + "\u1ba4";
			case "xli":
				return "\u1b9fᮣ" + "\u1ba4";
			case "hli":
				return "\u1ba0ᮣ" + "\u1ba4";
			/*
			 * o
			 */
			case "wlo":
				return "\u1b9dᮣ" + "\u1ba7";
			case "slo":
				return "\u1b9eᮣ" + "\u1ba7";
			case "xlo":
				return "\u1b9fᮣ" + "\u1ba7";
			case "hlo":
				return "\u1ba0ᮣ" + "\u1ba7";
			case "llo":
				return "\u1b9cᮣ" + "\u1ba7";
			case "rlo":
				return "\u1b9bᮣ" + "\u1ba7";
			case "klo":
				return "\u1b8aᮣ" + "\u1ba7";
			case "qlo":
				return "\u1b8bᮣ" + "\u1ba7";
			case "glo":
				return "\u1b8cᮣ" + "\u1ba7";
			case "clo" :
				return "\u1b8eᮣ" + "\u1ba7";
			case "jlo":
				return "\u1b8fᮣ" + "\u1ba7";
			case "zlo":
				return "\u1b90ᮣ" + "\u1ba7";
			case "tlo":
				return "\u1b92ᮣ" + "\u1ba7";
			case "dlo":
				return "\u1b93ᮣ" + "\u1ba7";
			case "nlo":
				return "\u1b94ᮣ" + "\u1ba7";
			case "plo":
				return "\u1b95ᮣ" + "\u1ba7";
			case "flo":
				return "\u1b96ᮣ" + "\u1ba7";
			case "vlo":
				return "\u1b97ᮣ" + "\u1ba7";
			case "blo":
				return "\u1b98ᮣ" + "\u1ba7";
			case "mlo":
				return "\u1b99ᮣ" + "\u1ba7";
			case "ylo":
				return "\u1b9aᮣ" + "\u1ba7";
			/*
			 * u
			 */
			case "klu":
				return "\u1b8aᮣ" + "\u1ba5";
			case "qlu":
				return "\u1b8bᮣ" + "\u1ba5";
			case "glu":
				return "\u1b8cᮣ" + "\u1ba5";
			case "clu":
				return "\u1b8eᮣ" + "\u1ba5";
			case "jlu":
				return "\u1b8fᮣ" + "\u1ba5";
			case "zlu":
				return "\u1b90ᮣ" + "\u1ba5";
			case "tlu":
				return "\u1b92ᮣ" + "\u1ba5";
			case "dlu":
				return "\u1b93ᮣ" + "\u1ba5";
			case "nlu":
				return "\u1b94ᮣ" + "\u1ba5";
			case "plu":
				return "\u1b95ᮣ" + "\u1ba5";
			case "flu":
				return "\u1b96ᮣ" + "\u1ba5";
			case "vlu":
				return "\u1b97ᮣ" + "\u1ba5";
			case "blu":
				return "\u1b98ᮣ" + "\u1ba5";
			case "mlu":
				return "\u1b99ᮣ" + "\u1ba5";
			case "ylu":
				return "\u1b9aᮣ" + "\u1ba5";
			case "rlu":
				return "\u1b9bᮣ" + "\u1ba5";
			case "llu":
				return "\u1b9cᮣ" + "\u1ba5";
			case "wlu":
				return "\u1b9dᮣ" + "\u1ba5";
			case "slu":
				return "\u1b9eᮣ" + "\u1ba5";
			case "xlu":
				return "\u1b9fᮣ" + "\u1ba5";
			case "hlu":
				return "\u1ba0ᮣ" + "\u1ba5";

			/*
			 * e
			 */
			case "kle":
				return "\u1b8aᮣ" + "\u1ba8";
			case "qle":
				return "\u1b8bᮣ" + "\u1ba8";
			case "cle":
				return "\u1b8eᮣ" + "\u1ba8";
			case "jle":
				return "\u1b8fᮣ" + "\u1ba8";
			case "zle":
				return "\u1b90ᮣ" + "\u1ba8";
			case "tle":
				return "\u1b92ᮣ" + "\u1ba8";
			case "dle":
				return "\u1b93ᮣ" + "\u1ba8";
			case "nle":
				return "\u1b94ᮣ" + "\u1ba8";
			case "ple":
				return "\u1b95ᮣ" + "\u1ba8";
			case "fle":
				return "\u1b96ᮣ" + "\u1ba8";
			case "vle":
				return "\u1b97ᮣ" + "\u1ba8";
			case "ble":
				return "\u1b98ᮣ" + "\u1ba8";
			case "mle":
				return "\u1b99ᮣ" + "\u1ba8";
			case "yle":
				return "\u1b9aᮣ" + "\u1ba8";
			case "rle":
				return "\u1b9bᮣ" + "\u1ba8";
			case "lle":
				return "\u1b9cᮣ" + "\u1ba8";
			case "wle":
				return "\u1b9dᮣ" + "\u1ba8";
			case "sle":
				return "\u1b9eᮣ" + "\u1ba8";
			case "xle":
				return "\u1b9fᮣ" + "\u1ba8";
			case "hle":
				return "\u1ba0ᮣ" + "\u1ba8";

		}
		return tripleChar;
	}


	public String fourCharacter(String chekInFourChar) {
		switch (chekInFourChar) {
			case "ngeu":
				return "\u1b8d" + "\u1ba9";
			case "nge`":
				return "\u1ba6" + "\u1b8d";
			case "nyeu":
				return "\u1b91" + "\u1ba9";
			case "nye`":
				return "\u1ba6" + "\u1b91";
		}
		return null;
	}

}
