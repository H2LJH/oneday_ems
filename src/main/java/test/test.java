package test;

public class test {
public static void main(String[] args) {
	
	String[][] a = new String[2][2];
	a[0][0] = "a";
	a[0][1] = "b";
	a[1][0] = "c";
	a[1][1] = "d";
	for(String[] one : a)
	{
		System.out.println(one[0]);
		System.out.println(one[1]);
	}
}
}
