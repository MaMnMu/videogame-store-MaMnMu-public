import java.util.ArrayList;
import java.util.Iterator;

public class Jefe extends Trabajador 
{	
	//Constructores
	
	public Jefe(String nombreP, String iniciales, String puesto, double salario) 
	{
		super(nombreP, iniciales, puesto, salario);
	}

	public Jefe(String nombreP, String contraseña, String iniciales, String puesto, double salario) 
	{
		super(nombreP, contraseña, iniciales, puesto, salario);
	}
		
	//Métodos
	
	public static void contratar(ArrayList<Trabajador> trabajadores)
	{
		System.out.println("Introduzca el nombre del nuevo empleado");
		String n = Lectura.leerLinea();
		System.out.println("Introduzca las iniciales del empleado");
		String ini = Lectura.leerLinea();
		System.out.println("Introduzca su puesto a ocupar");
		String p = Lectura.leerLinea();
		System.out.println("Introduzca su salario");
		double s = Lectura.leerDouble();
		System.out.println("¿Desea agregarle una contraseña especifica o seleccionada aleatoriamente? (Especifica: E/e. Aleatoria; A/a)");
		char c = Lectura.leerChar();
		if (c == 'E' || c == 'e')
		{
			System.out.println("Introduzca su contraseña");
			String cont = Lectura.leerLinea();
			Trabajador nTrabaj = new Trabajador(n, cont, ini, p, s);
			trabajadores.add(nTrabaj);
		}
		else if (c == 'A' || c == 'a')
		{
			Trabajador nTrabaj = new Trabajador(n, ini, p, s);
			trabajadores.add(nTrabaj);
		}	
		System.out.println("Nuevo empleado contratado exitosamente");
	}
	
	public static void modifTrabaj(ArrayList<Trabajador> trabajadores, int i)
	{
		Trabajador t = trabajadores.get(i);
		System.out.println("Introduzca la nueva contraseña del empleado " + t.id);
		String cn = Lectura.leerLinea();
		System.out.println("Introduzca el nuevo puesto del empleado " + t.id);
		String np = Lectura.leerLinea();
		System.out.println("Introduzca el nuevo salario del empleado " + t.id);
		double ns = Lectura.leerDouble();
		t.setContra(cn);
		t.setPuesto(np);
		t.setSalario(ns);
	}
	
	public static void listarTrabaj(ArrayList<Trabajador> trabajadores)
	{
		Iterator<Trabajador> it = trabajadores.iterator();
		while (it.hasNext())
		{
			Trabajador t = it.next();
			System.out.println(t + "\n\n");
		}
	}
}
