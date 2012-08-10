package vista;

import java.util.ArrayList;

import model.Currency;
import model.Database;
import model.Modulo;
import model.Opcion;
import model.Permiso;
import model.Usuario;

public class CRM {
	private Database db;
	private String companyName;
	private double IGV;
	private String userName;
	private String userPassword;
	private Currency localCurrency;
//	private ArrayList<Currency> foreignCurrencyList;
	private String systemDateFormat;
	private String systemDecimalFormat;
	
	public CRM() {
		db = new Database();
	}
	
	public void setUser(String p_userName) {
		this.userName = p_userName;
	}

	public void setPassword(String p_password) {
		this.userPassword = p_password;
	}

	public void setLocalCurrency(String p_currencyName) {
		this.localCurrency = db.getCurrency("currencyName", p_currencyName);
	}

	public boolean login() {
		// Recibir el codigo de usuario, ubicarlo en los datos
		// y comparar el resultado de la clave
		boolean ret = false;
		Usuario u = db.getUsuario("cuenta", this.userName);
		if (u != null) {
			ret = u.getClave().equals(this.userPassword);
		}
		return ret;
	}

	public ArrayList menu() {
		// Construye menu seg�n permisos de usuario
		int opcion = 1;
		ArrayList<String> menuList = new ArrayList<String>();
		ArrayList<Permiso> permisoList = null;
		String buffer = null;
		
		// Recuperar permisos de usuario para el modulo
		permisoList = db.getPermisos(this.userName);
		for (Modulo m : db.getModulos()) {
			buffer = opcion+". ";
			// Recorrer los permisos
			for (Permiso p : permisoList) {
				// Para cada m�dulo existente en el sistema
				if (m.getNombre().equals(p.getNombreModulo())) {
					// Determinar si se tiene acceso para mostrar
					if (p.isAcceso()) {
						buffer = buffer.concat(m.getDescripcion());
					}
					else
						buffer = buffer.concat("................");
					break;
				}
			}
			// Cargar el arreglo con el listado del men�
			menuList.add(buffer);
			opcion++;
		}
		menuList.add("0. Salir");
		return menuList;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String p_companyName) {
		this.companyName = companyName;
	}

	public double getIGV() {
		return IGV;
	}

	public void setIGV(double p_IGV) {
		IGV = p_IGV;
	}

	public void loadTestData() {
		db.loadTestData();
	}

	public String getSystemDateFormat() {
		return systemDateFormat;
	}

	public void setSystemDateFormat(String p_systemDateFormat) {
		this.systemDateFormat = p_systemDateFormat;
	}

	public String getSystemDecimalFormat() {
		return systemDecimalFormat;
	}

	public void setSystemDecimalFormat(String p_systemDecimalFormat) {
		this.systemDecimalFormat = p_systemDecimalFormat;
	}

	public ArrayList opcion(String p_modulo) {
		// Construye menu seg�n permisos de usuario
		int opcion = 1;
		ArrayList<String> formList = new ArrayList<String>();
		ArrayList<Permiso> permisoList = null;
		String buffer = null;
		
		// Recorrer los permisos
		for (Permiso p : db.getPermisos(this.userName)) {
			// Obtener los permisos que corresponden al m�dulo
			if (p.getNombreModulo().equals(p_modulo)) {
				// Leer opciones de un formulario est�ndar
				for (Opcion o : db.getOpciones()) {
					buffer = opcion+". ";
					switch(opcion) {
					case 1:
						if (p.isAdicionar()) {
							buffer = buffer.concat(o.getDescripcion());
						}
						else
							buffer = buffer.concat("................");
						break;
					case 2:
						if (p.isModificar()) {
							buffer = buffer.concat(o.getDescripcion());
						}
						else
							buffer = buffer.concat("................");
						break;
					case 3:
						if (p.isEliminar()) {
							buffer = buffer.concat(o.getDescripcion());
						}
						else
							buffer = buffer.concat("................");
						break;
					case 4:
						if (p.isConsultar()) {
							buffer = buffer.concat(o.getDescripcion());
						}
						else
							buffer = buffer.concat("................");
						break;
					case 5:
						if (p.isConsultar()) {
							buffer = buffer.concat(o.getDescripcion());
						}
						else
							buffer = buffer.concat("................");
						break;
					default:
						break;
					}
					formList.add(buffer);
					opcion++;
				}
				break;
			}
		}
		formList.add("0. Salir");
		return formList;
	}

}
