
public class Menu 
{	
	public static int menu (String [] opciones)
	{
		int opc = 0;
		while (opc < 1 || opc > opciones.length)
		{
			for (int i = 0; i < opciones.length; i++)
				System.out.println(i+1 + ". " + opciones[i]);
			opc = Lectura.leerInt();
		}
		return opc;
	}
}

