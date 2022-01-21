import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TiendaVideojuegos 
{	
	static ArrayList<Producto> productos = new ArrayList<Producto>();
	static ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
	
	static Jefe j = new Jefe("Manuel Molina Terron", "Jefemmt123", "MMT", "Jefe de tienda", 3400.45);
	
	public static void añadirArrayList()
	{
		Trabajador t1 = new Trabajador("Sofia Dominguez Perez", "SDP", "Dependiente", 1340.56);
		Trabajador t2 = new Trabajador("Luis Gonzalez Gomez", "1234a?", "LGM", "Guardia de seguridad", 1679.13);
		Trabajador t3 = new Trabajador("Rodrigo Diaz Jimenez", "AB675!", "RDJ", "Informatico", 1578.29);
		
		Producto p1 = new Producto("FIFA 21", "F21", 67, 59.99);
		Producto p2 = new Producto("Grand Theft Auto V", "GTAV", 122, 27.99);
		Producto p3 = new Producto("Battlefield V", "BFV", 24, 19.99);
		Producto p4 = new Producto("Playstation 5", "PS5", 0, 499.99);
		Producto p5 = new Producto("PC Gaming", "PCG", 14, 999.99);
		
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		productos.add(p5);
		trabajadores.add(t1);
		trabajadores.add(t2);
		trabajadores.add(t3);
	}
	
	public static void contratar()
	{
		Jefe.contratar(trabajadores);
	}
	
	public static void modifTrabaj()
	{
		int i = Identificador.buscarID(trabajadores);
		if (i != -1)
		{
			System.out.println("Trabajador encontrado. \n¿Desea despedir al trabajador o modificar su datos (Despedir: D/d. Modificar: M/m)?");
			char c = Lectura.leerChar();
			while (c != 'D' && c != 'd' && c != 'M' && c != 'm')
			{
				System.out.println("Valor invalido. Despedir: D/d. Modificar: M/m");
				c = Lectura.leerChar();
			}
			
			if (c == 'D' || c == 'd')
			{
				trabajadores.remove(i);
				System.out.println("El empleado ha sido despedido");
			}
			
			else if (c == 'M' || c == 'm')
			{
				Jefe.modifTrabaj(trabajadores, i);
				System.out.println("Los datos del empleado se han modificado correctamente");
			}
		}
		
		else
			System.out.println("No se ha encontrado el ID del empleado.");
	}
	
	public static void modifProd()
	{
		int i = Identificador.buscarCodigo(productos);
		if (i != -1)
		{
			System.out.println("Producto encontrado. \n¿Desea descatalogar el producto o modificar su precio (Descatalogar: D/d. Modificar: M/m)?");
			char c = Lectura.leerChar();
			while (c != 'D' && c != 'd' && c != 'M' && c != 'm')
			{
				System.out.println("Valor invalido. Descatalogar: D/d. Modificar: M/m");
				c = Lectura.leerChar();
			}
			
			if (c == 'D' || c == 'd') 
			{
				productos.remove(i);
				System.out.println("El producto ha sido descatalogado correctamente");
			}
			
			else if (c == 'M' || c == 'm')
			{
				Trabajador.modifProd(productos, i);
				System.out.println("El precio del producto se ha cambiado correctamente");
			}
		}
		
		else
			System.out.println("No se ha encontrado el codigo del producto.");
	}
	
	public static void listarTrabaj()
	{
		Jefe.listarTrabaj(trabajadores);
	}
	
	public static void listarProd()
	{
		Perfil.listarProd(productos);
	}
	
	public static void reponer()
	{
		int i = Identificador.buscarCodigo(productos);
		if (i != -1)
		{
			System.out.println("Producto encontrado. \n¿Cuantas unidades desea reponer?");
			int cant = Lectura.leerInt();
			Trabajador.reponer(productos, i, cant);
			System.out.println("Se han repuesto " + cant + " unidades del producto");
		}
		
		else
			System.out.println("No se ha encontrado el codigo del producto.");
	}
	
	public static void añadirNuevoPr()
	{
		Trabajador.añadirNuevoPr(productos);
	}
	
	public static void deseaTicket(String usuario, Producto p)
	{
		System.out.println("Gracias por su compra. \n¿Desea imprimir su ticket de compra? (Si / No)");
		String s = Lectura.leerLinea();
		while (!s.equalsIgnoreCase("Si") && !s.equalsIgnoreCase("No"))
		{
			System.out.println("Valor invalido. Introduzca Si o No");
			s = Lectura.leerLinea();
		}
		if (s.equalsIgnoreCase("Si"))
			imprimirTicket(usuario, p);
		else if (s.equalsIgnoreCase("No"))
			System.out.println("Gracias por su atencion. Vuelva pronto :)");
	}
	
	public static void imprimirTicket(String usuario, Producto p)
	{
		String fichero = "Ticket " + usuario +".txt";
		System.out.println("Imprimiendo su ticket de compra");
		BufferedWriter bw = null;
		try
		{
			bw = new BufferedWriter(new FileWriter(fichero));
			bw.write("\nCOMPRA REALIZADA POR: \n" + usuario + "\n\nPRODUCTO ADQUIRIDO: \n" + p);
		}
			
		catch (IOException e)
		{
			System.err.println("Error imprimiendo el ticket");
		}
			
		finally
		{
			try
			{
				if (bw!= null)
				{
					bw.close();
					System.out.println("Ticket impreso con exito");
				}
			}
				
			catch (IOException e)
			{
				System.err.println("Error imprimiendo el ticket");
			}
		}	
	}
	
	public static void noStock()
	{
		System.out.println("Se ha encontrado el producto correspondiente pero no queda stock. "
				+ "\n¿Desea recibir un email cuando vuelva a haber stock (Si / No)?");
		String s = Lectura.leerLinea();
		while (!s.equalsIgnoreCase("Si") && !s.equalsIgnoreCase("No"))
		{
			System.out.println("Valor invalido. Introduzca Si o No");
			s = Lectura.leerLinea();
		}
		
		if (s.equalsIgnoreCase("Si"))
		{
			System.out.println("Introduzca el email al que desea que le enviemos la notificacion");
			Lectura.leerLinea();
			System.out.println("Gracias por su atencion. Vuelva pronto :)");
		}
		
		else if (s.equalsIgnoreCase("No"))
			System.out.println("Gracias por su atencion. Vuelva pronto :)");
	}
	
	public static void comprar(String usuario)
	{
		int i = Identificador.buscarCodigo(productos);
		if (i != -1) 
		{
			if (Cliente.comprar(productos, i) == true)
			{
				Cliente.ingresosCompra(usuario, productos.get(i));
				deseaTicket(usuario, productos.get(i));
			}
			else
				noStock();
		}
				
		else 
			System.out.println("No se ha encontrado el codigo del producto.");
	}
	
	public static void alquilar(String usuario)
	{
		int i = Identificador.buscarCodigo(productos);
		if (i != -1) 
			if (Cliente.alquilar(productos, i) == true)
			{
				Cliente.ingresosAlquilar(usuario, productos.get(i));
				deseaTicket(usuario, productos.get(i));
			}
			else
				noStock();
				
		else 
			System.out.println("No se ha encontrado el codigo del producto.");
	}
	
	public static void devolver(String usuario)
	{
		int i = Identificador.buscarCodigo(productos);
		if (i != -1)
			if (Cliente.devolver(productos, i) == true)
			{
				Cliente.devolucionCompra(usuario, productos.get(i));
				System.out.println("Producto devuelto con exito. Vuelva pronto :)");	
			}
		
		else 
			System.out.println("No se ha encontrado el codigo del producto.");
	}
	
	public static void presentarCurric(String usuario)
	{
		Cliente.presentarCurric(usuario);
	}
	
	public static void main(String[] args)
	{
		añadirArrayList();
		boolean bucle = false;
		
		while (!bucle)
		{
			Iterator<Trabajador> it = trabajadores.iterator();
			System.out.println("Introduzca su nombre de usuario");
			String usuario = Lectura.leerLinea();
			System.out.println("Introduzca su contraseña");
			String contra = Lectura.leerLinea();
			boolean registrado = false;
			
			while (!registrado)
			{
				if (usuario.equals(j.getNombreP()))
				{
					if (contra.equals(j.getContra()))
					{
						registrado = true;
						System.out.println("\n\n Ha iniciado sesion como JEFE \n");
						String [] ops = {"Contratar nuevo empleado", "Modificar empleado", "Mostrar empleados en nomina",
										"Mostrar productos a la venta", "Reponer producto", "Añadir nuevo producto", 
										"Modificar producto", "Cerrar sesion"};
						int op = Menu.menu(ops);
						while (op!= 8)
						{
							switch (op)
							{
							case 1: contratar(); break;
							case 2: modifTrabaj(); break;
							case 3: listarTrabaj(); break;
							case 4: listarProd(); break;
							case 5: reponer(); break;
							case 6: añadirNuevoPr(); break;
							case 7: modifProd(); break;
							}
							System.out.println("\n");
							op = Menu.menu(ops);
						}
					 }
					
					 else
					 {
						System.out.println("El nombre de usuario existe, pero la contraseña es incorrecta");
						System.out.println("Escriba su contraseña correctamente");
						contra = Lectura.leerLinea();
					 }
				 }
				
				else
				{
					boolean encontrado = false;
					while (it.hasNext() && !encontrado)
					{
						Trabajador t = it.next();
						if (usuario.equals(t.getNombreP()))
						{
							if (contra.equals(t.getContra()))
							{
								registrado = true;
								encontrado = true;
								System.out.println("\n\n Ha iniciado sesion como EMPLEADO \n");
								String [] ops = {"Mostrar productos a la venta", "Reponer producto", "Añadir nuevo producto", 
												"Modificar producto", "Cerrar sesion"};
								int op = Menu.menu(ops);
								while (op!= 5)
								{
									switch (op)
									{
									case 1: listarProd(); break;
									case 2: reponer(); break;
									case 3: añadirNuevoPr(); break;
									case 4: modifProd(); break; 
									}
									System.out.println("\n");
									op = Menu.menu(ops);
								}
							 }
							
							 else
							 {
								System.out.println("El nombre de usuario existe, pero la contraseña es incorrecta");
								it = trabajadores.iterator();
								System.out.println("Escriba su contraseña correctamente");
								contra = Lectura.leerLinea();
							 }
						}
					}
					 
					registrado = true;
					System.out.println("\n\n Ha iniciado sesion como CLIENTE \n");
					String [] ops = {"Mostrar productos a la venta", "Comprar producto", "Alquilar producto",  
									"Devolver producto", "Presentar curriculum", "Cerrar sesion"};
					int op = Menu.menu(ops);
					while (op!= 6)
					{
						switch (op)
						{
						case 1: listarProd(); break;
						case 2: comprar(usuario); break;
						case 3: alquilar(usuario); break;
						case 4: devolver(usuario); break;
						case 5: presentarCurric(usuario); break;
						}
						System.out.println("\n");
						op = Menu.menu(ops);
					}
				}
			}
			
			System.out.println("¿Desea salir de la aplicacion o iniciar sesion con otra cuenta? (Salir: S/s. Otra cuenta: C/c)");
			char c = Lectura.leerChar();
			while (c != 'S' && c != 's' && c != 'C' && c != 'c')
			{
				System.out.println("Valor invalido. Salir: S/s. Otra cuenta: C/c");
				c = Lectura.leerChar();
			}
			if (c == 'S' || c == 's') 
				bucle = true;
			else if (c == 'C' || c == 'c')
				bucle = false;
		}
	}
}


			
			
					

