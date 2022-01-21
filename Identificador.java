import java.util.ArrayList;
import java.util.Iterator;

public class Identificador 
{
	//Atributos
	
	private String ident;
	private static int orden = 0;
	
	//Constructores
	
	public Identificador(String abrev)
	{
		this.ident = generarIdent() + "-" + abrev;
		orden++;
	}
	
	//Métodos
	
	public String getIdent()
	{
		return this.ident;
	}
	
	private String generarIdent()
	{
		String ident = "" + orden;
		while (ident.length() < 4)
		{
			ident = "0" + ident;
		}
		return ident;	
	}
	
	public boolean equals(String s)
	{
		return this.ident.equalsIgnoreCase(s);
	}
	
	public static int buscarID(ArrayList<Trabajador> trabajadores)
	{
		int i = -1;
		System.out.println("Escriba el ID del empleado");
		String id2 = Lectura.leerLinea();
		Iterator<Trabajador> it = trabajadores.iterator();
		
		while (it.hasNext() && i == -1)
		{
			Trabajador t = it.next();
			if (t.id.equals(id2))
				i = trabajadores.indexOf(t);
		}
		return i;
	}
	
	public static int buscarCodigo(ArrayList<Producto> productos)
	{
		int i = -1;
		System.out.println("Escriba el codigo del producto");
		String cod2 = Lectura.leerLinea();
		Iterator<Producto> it = productos.iterator();
		
		while (it.hasNext() && i == -1)
		{
			Producto p = it.next();
			if (p.codigo.equals(cod2))
				i = productos.indexOf(p);
		}
		return i;
	}

	@Override
	public String toString()
	{
		return this.ident;
	}	
}
