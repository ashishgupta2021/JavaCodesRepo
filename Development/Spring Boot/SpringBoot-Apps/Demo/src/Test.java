
public class Test {

	
	public static void main(String[] args) {
		System.out.println(reverse("A-aBC23D-we"));
		// D-CBaA
	}
	
	static String reverse(String text) {
		StringBuilder sb = new StringBuilder();
		// System.out.println((char)(97+26));
		for(int j = 0; j <text.length() ; j++) {
			char ch = text.charAt(j);
			if(!(ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))	{
				sb.append(ch);
			}
			for(int i=text.length() - 1; i >=0; i--)
			{
				char c = text.charAt(i);
				if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))	{	
					// System.out.println(c);
					sb.append(c);
				}
				else {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
}

