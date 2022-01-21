import java.util.ArrayList;

public class Trabajador extends Perfil
{
	//Atributos
	
	protected Identificador id;
	protected String puesto;
	protected double salario;
	
	//Constructores
	
	public Trabajador(String nombreP, String contraseña, String iniciales, String puesto, double salario) 
	{
		super(nombreP, contraseña);
		this.id = new Identificador(iniciales);
		this.puesto = puesto;
		this.salario = salario;
		
	}
	
	public Trabajador(String nombreP, String iniciales, String puesto, double salario) 
	{
		super(nombreP);
		this.id = new Identificador(iniciales);
		this.puesto = puesto;
		this.salario = salario;
	}
	
	//Métodos
	
	public void setPuesto(String puesto) 
	{
		this.puesto = puesto;
	}

	public void setSalario(double salario) 
	{
		this.salario = salario;
	}
	
	public static void reponer(ArrayList<Producto> productos, int i, int cant)
	{
		Producto p = productos.get(i);
		p.setStock(p.getStock() + cant);
	}
	
	public static void añadirNuevoPr(ArrayList<Producto> productos)
	{
		System.out.println("Introduzca el nombre del nuevo producto");
		String n = Lectura.leerLinea();
		System.out.println("Introduzca una abreviacion");
		String ab = Lectura.leerLinea();
		System.out.println("Introduzca el stock inicial disponible");
		int s = Lectura.leerInt();
		System.out.println("Introduzca el precio de venta");
		double pv = Lectura.leerDouble();
		Producto nProd = new Producto(n, ab, s, pv);
		productos.add(nProd);
		System.out.println("El nuevo producto ha sido añadido correctamente");
	}
	
	public static void modifProd(ArrayList<Producto> productos, int i)
	{
		Producto p = productos.get(i);
		System.out.println("Introduzca el nuevo precio del producto " + p.codigo);
		double np = Lectura.leerDouble();
		p.setPrecioV(np);
	}
	
	@Override
	public String toString()
	{
		return "EMPLEADO " + id + "\n" +
				super.toString() + 
				"\nPuesto: " + puesto +
				"\nSalario: " + salario;
	}
}
