package dam.model;

public class Restaurante {

	private int id;
	private String nombre;
	private String region;
	private String ciudad;
	private String distincion;
	private int distint;
	private String direccion;
	private double precio_min;
	private double precio_max;
	private String precio;
	private String telefono;
	private String cocina;
	private String web;

	public Restaurante(int id, String nombre, String region, String ciudad, int distint, String direccion,
			double precio_min, double precio_max, String telefono, String cocina, String web) {

		// this.id = id;
		this.nombre = nombre;
		this.region = region;
		this.ciudad = ciudad;
		this.distint = distint;
		this.direccion = direccion;
		this.precio_min = precio_min;
		this.precio_max = precio_max;
		this.telefono = telefono;

		this.cocina = cocina;
		this.web = web;
	}

	public Restaurante(String nombre, String region, String ciudad, int distint, String direccion, double precio_min,
			double precio_max, String telefono, String cocina, String web) {

		this.nombre = nombre;
		this.region = region;
		this.ciudad = ciudad;
		this.distint = distint;
		this.direccion = direccion;
		this.precio_min = precio_min;
		this.precio_max = precio_max;
		this.telefono = telefono;
		this.cocina = cocina;
		this.web = web;
	}

	public Restaurante(String nombre, String ciudad, String distincion, String cocina, String precio) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.distincion = distincion;
		this.cocina = cocina;
		this.precio = precio;

	}

	public Restaurante(String region) {
		this.region = region;

	}

	public Restaurante(int distincion) {

		this.distint = distincion;
	}

	public Restaurante(String nomRest, String ciudad, String direccion, int distincion, String region, String cocina,
			double precio_max, double precio_min, String telefono, String web) {
		this.nombre = nomRest;
		this.region = region;
		this.ciudad = ciudad;
		this.distint = distincion;
		this.direccion = direccion;
		this.precio_min = precio_min;
		this.precio_max = precio_max;
		this.telefono = telefono;
		this.cocina = cocina;
		this.web = web;

	}

	public String getPrecio() {

		return precio;
	}

	public String getCocina() {

		return cocina;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRegion() {
		return region;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getDistincion() {
		return distincion;
	}

	public int getDistint() {
		return distint;
	}

	public String getDireccion() {
		return direccion;
	}

	public double getPrecio_min() {
		return precio_min;
	}

	public double getPrecio_max() {
		return precio_max;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getWeb() {
		return web;
	}

}
