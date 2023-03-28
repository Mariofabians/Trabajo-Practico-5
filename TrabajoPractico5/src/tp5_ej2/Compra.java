package tp5_ej2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Compra {

	public static void main(String[] args) {
		
		Producto listaProductos []=new Producto[3];
		
		File f=new File("C:\\Users\\mario\\Desktop\\Productos.txt");
		String linea;
		Scanner sn=null;
		
		try
		{
			sn=new Scanner(f);
			
			while(sn.hasNextLine())
			{
				for (int i=0;i<listaProductos.length;i++)
				{
					linea=sn.nextLine();
					int ind=i;
					cargarProductos(linea,listaProductos,ind);
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.print(e.getMessage());
		}
		finally
		{
			sn.close();
		}
		
		Persona pers1=new Persona ("Mario","Schujovitzky",36145563);
		Carrito carr=new Carrito (18,pers1);
		
		ItemCarrito item[]=new ItemCarrito [3];
		
		item [0]=new ItemCarrito(carr,listaProductos,4,0);
		item [1]=new ItemCarrito(carr,listaProductos,2,1);
		item [2]=new ItemCarrito(carr,listaProductos,6,2);
		
		mostrarCompra(item,pers1,carr);
	}

	private static void cargarProductos(String frase, Producto[] list, int indice) 
	{
		String items[]=frase.split("	");
		
		int codigo=Integer.parseInt(items[0]);
		String nombre=items[1];
		String descripcion=items[2];
		double precio=Double.parseDouble(items[3]);
		int stock=Integer.parseInt(items[4]);
		
		list[indice]=new Producto(codigo,nombre,descripcion,precio,stock);
	}

	public static void mostrarCompra(ItemCarrito it[],Persona per,Carrito car)
	{
		double suma=0.0;
		System.out.println("Carrito número "+car.getNumCarrito()+" del cliente "+per.dar_nombre());
		System.out.print("\n");
		it[0].mostrarTitulo();
		for(ItemCarrito a:it)
		{
			a.mostrarItem();
			suma+=a.getMontoItem();
		}
		System.out.println("\nSuma:$"+suma);		
	}
}
