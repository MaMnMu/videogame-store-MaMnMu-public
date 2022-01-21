
public class Producto
{
	//Atributos
	
	private String nombreProd;
	public Identificador codigo;
	private int stock;
	private double precioVenta;
	
	//Constructores
	
	public Producto (String nombreProd, String abrev, int stock, double precioVenta)
	{
		this.nombreProd = nombreProd;
		this.codigo = new Identificador(abrev);
		this.setStock(stock);
		this.precioVenta = precioVenta;
	}
	
	//Métodos
	
	public double getPrecioV() 
	{
		return precioVenta;
	}
	
	public void setPrecioV(double precioVenta) 
	{
		this.precioVenta = precioVenta;
	}
	
	public int getStock() 
	{
		return stock;
	}

	public void setStock(int stock) 
	{
		this.stock = stock;
	}	

	public double precioAlquiler()
	{
		return precioVenta * 0.2;
	}
	
	@Override
	public String toString()
	{
		return "PRODUCTO " + codigo +
				"\nNombre: " + nombreProd +
				"\nStock: " + getStock() +
				"\nPrecio de venta " + precioVenta +
				"\nPrecio de alquiler " + precioAlquiler();
	}
}
