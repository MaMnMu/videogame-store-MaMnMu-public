import java.io.*;
import java.util.ArrayList;

public class Cliente extends Perfil
{	
	//Constructores
	
	public Cliente (String nombreP, String contraseña) 
	{
		super(nombreP, contraseña);
	}

	public Cliente (String nombreP) 
	{
		super(nombreP);
	}
	
	//Métodos
	
	public static void ingresosCompra(String usuario, Producto p)
	{
		String fichero = "ingresos.txt";
		BufferedWriter bw = null;
		try
		{
			bw = new BufferedWriter(new FileWriter(fichero, true));
			bw.write("COMPRA " + usuario + ":  +" + p.getPrecioV() + "€");
			bw.newLine();
		}
		
		catch (IOException e)
		{
			System.err.println("Error escribiendo en el fichero");
		}
		
		finally
		{
			try
			{
				if (bw!= null)
					bw.close();
			}
			catch (IOException e)
			{
				System.err.println("Error cerrando el fichero");
			}
		}
	}
	
	public static void ingresosAlquilar(String usuario, Producto p)
	{
		String fichero = "ingresos.txt";
		BufferedWriter bw = null;
		try
		{
			bw = new BufferedWriter(new FileWriter(fichero, true));
			bw.write("ALQUILER " + usuario + ":  +" + p.precioAlquiler() + "€");
			bw.newLine();
		}
		
		catch (IOException e)
		{
			System.err.println("Error escribiendo en el fichero");
		}
		
		finally
		{
			try
			{
				if (bw!= null)
					bw.close();
			}
			catch (IOException e)
			{
				System.err.println("Error cerrando el fichero");
			}
		}
	}
	
	public static void devolucionCompra(String usuario, Producto p)
	{
		String fichero = "ingresos.txt";
		BufferedWriter bw = null;
		try
		{
			bw = new BufferedWriter(new FileWriter(fichero, true));
			bw.write("DEVOLUCION COMPRA " + usuario + ":  -" + p.getPrecioV() + "€");
			bw.newLine();
		}
		
		catch (IOException e)
		{
			System.err.println("Error escribiendo en el fichero");
		}
		
		finally
		{
			try
			{
				if (bw!= null)
					bw.close();
			}
			catch (IOException e)
			{
				System.err.println("Error cerrando el fichero");
			}
		}
	}
	
	public static boolean comprar(ArrayList<Producto> productos, int i)
	{
		Producto p = productos.get(i);
		if (p.getStock() > 0) 
		{
			p.setStock(p.getStock() - 1);
			return true;
		}
		else
			return false;
	}
	
	public static boolean alquilar(ArrayList<Producto> productos, int i)
	{
		Producto p = productos.get(i);
		if (p.getStock() > 0) 
		{
			p.setStock(p.getStock() - 1);
			return true;
		}
		else
			return false;
	}
	
	public static boolean devolver(ArrayList<Producto> productos, int i)
	{
		Producto p = productos.get(i);
		p.setStock(p.getStock() + 1);
		return true;
	}
	
	public static void presentarCurric(String nombre)
	{
		String fichero = "Curriculum " + nombre + ".txt"; 
		BufferedWriter bw = null;
		try
		{	
			bw = new BufferedWriter(new FileWriter(fichero));
			System.out.println("Escriba el curriculum que quiera presentar");
			String curr = Lectura.leerLinea();
			bw.write(curr);
		}
		
		catch (IOException e)
		{
			System.err.println("Error escribiendo el curriculum en un fichero");
		}
		
		finally
		{
			try
			{
				if (bw != null)
				{
					bw.close();
					System.out.println("El curriculum se ha enviado correctamente. Contactaremos con usted para informarle si ha sido elegido");
				}
			}
			
			catch (IOException e)
			{
				System.err.println("Error cerrando el fichero");
			}
		}
	}
}
