package vista;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class testGrupoEstudioForm {

	CRM crmEngine = new CRM();
	
	@Before
	public void inicializar() {
		// Configura el sistema
//		crmEngine.loadTestData();
		crmEngine.loadTestDataGrupoEstudio();
		crmEngine.setCompanyName("Instituto Benedictino");
		crmEngine.setIGV(18.00);
		crmEngine.setUser("admin");
		crmEngine.setPassword("Curs0d3p002012");
		crmEngine.setLocalCurrency("Sol");
		//crmEngine.addForeignCurrency("USD", "US$", 2.65);
		crmEngine.setSystemDateFormat("dd/mm/yyyy");
		crmEngine.setSystemDecimalFormat("#,###,##0.00");
	}
	@Test
	public void testAgregarForm() {
		ArrayList<String> input = new ArrayList<String>();
		
		// Simulacion de ingreso de datos
		input.add("1");  // No se va a añadir, pero es necesario para que tenga la cantidad de elementos completa
		input.add("Genexus"); //nombre
		input.add("Genexus Avanzado"); //descripción
		input.add("Academia San Miguel");
		input.add("Genexus Avanzado");
		input.add("2012-08-30");
		input.add("2012-10-30");
		input.add("Abierto");
		input.add("Julio Diaz");
		input.add("syll006");
		input.add("Av.Alfonso Ugarte 123");
		input.add("B72");
		input.add("12°02 00 S");
		input.add("77°01 00 O");
		
		// Editar un nuevo grupo estudio
		crmEngine.setGrupoEstudioInputArray(input);
		crmEngine.nuevoGrupoEstudio();
		crmEngine.listarGrupoEstudio();
	}

	
	@Test
	public void testModificarForm() {
		ArrayList<String> input = new ArrayList<String>();
		
		// Simulacion de ingreso de datos
		input.add(null);  // No se va a añadir, pero es necesario para que tenga la cantidad de elementos completa
		input.add("Genexus");
		input.add("Genexus 10");
		input.add("Academia San Miguelito");
		input.add("Genexus Avanzado II");
		input.add(null);
		input.add(null);
		input.add("Cerrado");
		input.add(null);
		input.add(null);
		input.add(null);
		input.add(null);
		input.add(null);
		input.add(null);
		
		// Modificar un prospecto existente
		crmEngine.setGrupoEstudioInputArray(input);
		crmEngine.modificaGrupoEstudio();
		crmEngine.listarGrupoEstudio();
	}
	
	@Test
	public void testAgregarFormSinNombre() {
		ArrayList<String> input = new ArrayList<String>();
		
		// Simulacion de ingreso de datos
		input.add("1");  // No se va a añadir, pero es necesario para que tenga la cantidad de elementos completa
		input.add(""); //nombre de grupo		
		input.add("Genexus Avanzado"); //descripción
		input.add("Academia San Miguel");//3.academia
		input.add("Genexus Avanzado");
		input.add("2012-08-30");
		input.add("2012-10-30");
		input.add("Abierto");
		input.add("Julio Diaz");
		input.add("syll006");
		input.add("Av.Alfonso Ugarte 123");
		input.add("B72");
		input.add("12°02 00 S");
		input.add("77°01 00 O");
//		asigno GrupoEstudioInputArray
		crmEngine.setGrupoEstudioInputArray(input);
//		Valido en array input en función de la columna
		assertFalse(crmEngine.validaGrupo()); // valida nombre

	}
	
	@Test
	public void testAgregarFormSinFechaInicio() {
		ArrayList<String> input = new ArrayList<String>();
		
		// Simulacion de ingreso de datos
		input.add("1");  // 0.No se va a añadir, pero es necesario para que tenga la cantidad de elementos completa
		input.add("Genexus"); //1.nombre
		input.add("Genexus Avanzado"); //2.descripción
		input.add("Academia San Miguel");//3.academia
		input.add("Genexus Avanzado");//4.curso
		input.add("");//5.fecha inicio
		input.add("2012-10-30");//6.fecha fin
		input.add("Abierto");//7.estado
		input.add("Julio Diaz");//8.instructor
		input.add("syll006");//9.syllabus
		input.add("Av.Alfonso Ugarte 123");//10.local
		input.add("B72");//11.aula
		input.add("12°02 00 S");//12.latitud
		input.add("77°01 00 O");//13.altitud
//		asigno GrupoEstudioInputArray
		crmEngine.setGrupoEstudioInputArray(input);
//		Valido en array input en función de la columna
		assertFalse(crmEngine.validaGrupo()); // valida fecha de inicio

	}

	@Test
	public void testAgregarFormSinFechaFin() {
		ArrayList<String> input = new ArrayList<String>();
		
		// Simulacion de ingreso de datos
		input.add("1");  // 0.No se va a añadir, pero es necesario para que tenga la cantidad de elementos completa
		input.add("Genexus"); //1.nombre
		input.add("Genexus Avanzado"); //2.descripción
		input.add("Academia San Miguel");//3.academia
		input.add("Genexus Avanzado");//4.curso
		input.add("2012-10-30");//5.fecha inicio
		input.add("");//6.fecha fin
		input.add("Abierto");//7.estado
		input.add("Julio Diaz");//8.instructor
		input.add("syll006");//9.syllabus
		input.add("Av.Alfonso Ugarte 123");//10.local
		input.add("B72");//11.aula
		input.add("12°02 00 S");//12.latitud
		input.add("77°01 00 O");//13.altitud
//		asigno GrupoEstudioInputArray
		crmEngine.setGrupoEstudioInputArray(input);
//		Valido en array input en función de la columna
		assertFalse(crmEngine.validaGrupo()); // valida fecha de fin

	}

	@Test
	public void testAgregarFormSinFormatoFechaInicio() {
		ArrayList<String> input = new ArrayList<String>();
		
		// Simulacion de ingreso de datos
		input.add("1");  // 0.No se va a añadir, pero es necesario para que tenga la cantidad de elementos completa
		input.add("Genexus"); //1.nombre
		input.add("Genexus Avanzado"); //2.descripción
		input.add("Academia San Miguel");//3.academia
		input.add("Genexus Avanzado");//4.curso
		input.add("01-15-201");//5.fecha inicio
		input.add("2012-10-30");//6.fecha fin
		input.add("Abierto");//7.estado
		input.add("Julio Diaz");//8.instructor
		input.add("syll006");//9.syllabus
		input.add("Av.Alfonso Ugarte 123");//10.local
		input.add("B72");//11.aula
		input.add("12°02 00 S");//12.latitud
		input.add("77°01 00 O");//13.altitud
//		asigno GrupoEstudioInputArray
		crmEngine.setGrupoEstudioInputArray(input);
//		Valido en array input en función de la columna
		assertFalse(crmEngine.validaGrupo()); // valida fecha de inicio

	}
	@Test
	public void testAgregarFormSinFormatoFechaFin() {
		ArrayList<String> input = new ArrayList<String>();
		
		// Simulacion de ingreso de datos
		input.add("1");  // 0.No se va a añadir, pero es necesario para que tenga la cantidad de elementos completa
		input.add("Genexus"); //1.nombre
		input.add("Genexus Avanzado"); //2.descripción
		input.add("Academia San Miguel");//3.academia
		input.add("Genexus Avanzado");//4.curso
		input.add("2012-08-30");//5.fecha inicio
		input.add("01-15-201");//6.fecha fin
		input.add("Abierto");//7.estado
		input.add("Julio Diaz");//8.instructor
		input.add("syll006");//9.syllabus
		input.add("Av.Alfonso Ugarte 123");//10.local
		input.add("B72");//11.aula
		input.add("12°02 00 S");//12.latitud
		input.add("77°01 00 O");//13.altitud
//		asigno GrupoEstudioInputArray
		crmEngine.setGrupoEstudioInputArray(input);
//		Valido en array input en función de la columna
		assertFalse(crmEngine.validaGrupo()); // valida fecha de inicio

	}

	@Test
	public void testAgregarFormFechaInicioIgualFechaFin() {
		ArrayList<String> input = new ArrayList<String>();
		
		// Simulacion de ingreso de datos
		input.add("1");  // 0.No se va a añadir, pero es necesario para que tenga la cantidad de elementos completa
		input.add("Genexus"); //1.nombre
		input.add("Genexus Avanzado"); //2.descripción
		input.add("Academia San Miguel");//3.academia
		input.add("Genexus Avanzado");//4.curso
		input.add("2012-08-30");//5.fecha inicio
		input.add("2012-08-30");//6.fecha fin
		input.add("Abierto");//7.estado
		input.add("Julio Diaz");//8.instructor
		input.add("syll006");//9.syllabus
		input.add("Av.Alfonso Ugarte 123");//10.local
		input.add("B72");//11.aula
		input.add("12°02 00 S");//12.latitud
		input.add("77°01 00 O");//13.altitud
//		asigno GrupoEstudioInputArray
		crmEngine.setGrupoEstudioInputArray(input);
//		Valido en array input en función de la columna
		assertFalse(crmEngine.validaGrupo()); // valida fecha de inicio

	}

	@Test
	public void testAgregarFormFechaInicioMayorFechaFin() {
		ArrayList<String> input = new ArrayList<String>();
		
		// Simulacion de ingreso de datos
		input.add("1");  // 0.No se va a añadir, pero es necesario para que tenga la cantidad de elementos completa
		input.add("Genexus"); //1.nombre
		input.add("Genexus Avanzado"); //2.descripción
		input.add("Academia San Miguel");//3.academia
		input.add("Genexus Avanzado");//4.curso
		input.add("2012-10-30");//5.fecha inicio
		input.add("2012-08-30");//6.fecha fin
		input.add("Abierto");//7.estado
		input.add("Julio Diaz");//8.instructor
		input.add("syll006");//9.syllabus
		input.add("Av.Alfonso Ugarte 123");//10.local
		input.add("B72");//11.aula
		input.add("12°02 00 S");//12.latitud
		input.add("77°01 00 O");//13.altitud
//		asigno GrupoEstudioInputArray
		crmEngine.setGrupoEstudioInputArray(input);
//		Valido en array input en función de la columna
		assertFalse(crmEngine.validaGrupo()); // valida fecha de inicio

	}

}
