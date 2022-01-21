import java.util.ArrayList;
import java.util.Iterator;

public abstract class Perfil 
{
	//Atributos
	
	protected String nombreP;
	protected String contraseña;
	
	//Constructores
	
	public Perfil (String nombreP, String contraseña)
	{
		this.nombreP = nombreP;
		this.contraseña = contraseña;
	}
	
	public Perfil (String nombreP)
	{
		this.nombreP = nombreP;
		this.contraseña = generarContra();
	}
	
	//Métodos
	
	public String getNombreP() 
	{
		return nombreP;
	}

	public String getContra() 
	{
		return contraseña;
	}
	
	public void setContra(String contraseña) 
	{
		this.contraseña = contraseña;
	}

	public String generarContra()
	{
		StringBuilder str = new StringBuilder("");
		String [] valido = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
										"a", "b", "c", "d", "A", "B", "C", "D", 
										"!", "?", "-", "."};
		for (int i = 0; i <= 10; i++)
			str.append(valido[(int)Math.floor(Math.random()*(valido.length))]);
		return str.toString();
	}

	public static void listarProd(ArrayList<Producto> productos)
	{
		Iterator<Producto> it = productos.iterator();
		while (it.hasNext())
		{
			Producto p = it.next();
			System.out.println(p + "\n\n");
		}
	}
	
	@Override
	public String toString()
	{
		return "Nombre: " + nombreP +
				"\nContraseña: " + contraseña;
	}
}
