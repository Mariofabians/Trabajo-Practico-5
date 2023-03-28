package tp5_ej1;

public class Compra {

	public static void main(String[] args) {
		
		Producto listaProductos []=new Producto[3];
		
		listaProductos[0]=new Producto(2395,"Leche","larga Vida 1l",234.75,100);
		listaProductos[1]=new Producto(1214,"Café","torrado 170g",987.99,50);
		listaProductos[2]=new Producto(112,"Azucar","blanca 1kg",341.2,60);
		
		Persona pers1=new Persona ("Mario","Schujovitzky",36145563);
		Carrito carr=new Carrito (18,pers1);
		
		ItemCarrito item[]=new ItemCarrito [3];
		
		item [0]=new ItemCarrito(carr,listaProductos,4,0);
		item [1]=new ItemCarrito(carr,listaProductos,2,1);
		item [2]=new ItemCarrito(carr,listaProductos,6,2);
		
		mostrarCompra(item,pers1,carr);
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
