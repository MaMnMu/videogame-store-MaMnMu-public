import java.util.Scanner;

public class Lectura 
{
	public static double leerDouble()
	{
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			try 
			{
				return sc.nextDouble();
			}
			
			catch (Exception e)
			{
				System.err.println("Error. Escriba un valor de tipo double");
				sc.nextLine();
			}
		}
	}
	
	public static int leerInt()
	{
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			try 
			{
				return sc.nextInt();
			}
			
			catch (Exception e)
			{
				System.err.println("Error. Escriba un valor de tipo int");
				sc.nextLine();
			}
		}
	}
	
	public static String leerLinea()
	{
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static char leerChar()
	{
		String l = leerLinea();
		while (l.length() > 1)
		{
			System.out.println("Valor invalido. Introduzca un solo caracter");
			l = leerLinea();
		}
		return l.charAt(0);
	}
}
