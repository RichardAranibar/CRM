package controlador;

import java.util.ArrayList;
import java.util.Comparator;

import model.Secuencia;
import model.Database;
import model.GrupoEstudio;

public class FormGrupoEstudio extends Formulario{
	Database db = null;
	public FormGrupoEstudio() {
		// Definir las columnas del formulario
		this.agregarColumna("Código", "codigo", "String", "", false);
		this.agregarColumna("Nombre", "nombre", "String", "", true);
		this.agregarColumna("Descripcion", "descripcion", "String", "", true);
		this.agregarColumna("Academia", "academia", "String", "", true);
		this.agregarColumna("Curso", "curso", "String", "", true);
		this.agregarColumna("Fecha de Inicio", "fechainicio", "String", "", true);
		this.agregarColumna("Fecha de Fin", "fechafin", "String", "", true);
		this.agregarColumna("Estado", "estado", "String", "", true);
		this.agregarColumna("Instructor", "instructor", "String", "", true);
		this.agregarColumna("Syllabus", "syllabus", "String", "", true);
		this.agregarColumna("Local", "local", "String", "", true);
		this.agregarColumna("Aula", "aula", "String", "", true);
		this.agregarColumna("Coord.latitud", "coordlatitud", "String", "", true);
		this.agregarColumna("Coord.altitud", "coordaltitud", "String", "", true);
	}
	public void setDatabase(Database p_database) {
		this.db = p_database;
	}

	@Override
	// Asignar todos los valores y colocarlos en la base de datos
	public void grabar() {
		ArrayList<String> columnasValor = new ArrayList<String>();
		GrupoEstudio p = null;
		// Si no es agregar, recuperar el registro a modificar
		if (this.getModo() == this.AGREGAR)
			p = new GrupoEstudio();
		else
			p = this.db.getGrupoEstudio().get(0);
		super.grabar();
		
		columnasValor = this.obtenerColumnasValor();
		p.setNombre(columnasValor.get(1));
		p.setDescripcion(columnasValor.get(2));
		p.setAcademia(columnasValor.get(3));
		p.setCurso(columnasValor.get(4));
		p.setFechainicio(columnasValor.get(5));
		p.setFechafin(columnasValor.get(6));
		p.setEstado(columnasValor.get(7));
		p.setInstructor(columnasValor.get(8));
		p.setSyllabus(columnasValor.get(9));
		p.setLocal(columnasValor.get(10));
		p.setAula(columnasValor.get(11));
		p.setCoordlatitud(columnasValor.get(12));
		p.setCoordaltitud(columnasValor.get(13));		
		// Agregar registro
		if (this.getModo() == this.AGREGAR) {
			// Todos los datos se han ingresado, asignar el código
			String seq_codigo = null;
			seq_codigo = Secuencia.get("GrupoEstudio");
			p.setCodigo(seq_codigo);
			System.out.println("0. "+this.obtenerColumnaEtiqueta(0)+" : "+seq_codigo);

			db.addGrupoEstudio(p);
		}
	}

	@Override
	public void listar() {
		int numero = 1;
		boolean retorno = false;
		super.listar();
		// Mostrar la cabecera del listado
		//System.out.println(String.format("%1$02d", numero) + ". "+pt.cabecera());
		
		// Leer todos los registros
		for (GrupoEstudio p : db.getGrupoEstudio()) {
			//if (p.coincide(this.obtenerColumnasValor())) {
			if (true) {
				System.out.println(String.format("%1$02d", numero) + ". "+p);
				numero++;
				retorno = true;
			}
		}
	}

	@Override
	public void modificar() {
		// Ubicar registro a modificar
		GrupoEstudio p = this.db.getGrupoEstudio().get(0);
		this.asignarColumnaValor(0, p.getCodigo());
		this.asignarColumnaValor(1, p.getNombre());
		this.asignarColumnaValor(2, p.getDescripcion());
		this.asignarColumnaValor(3, p.getAcademia());
		this.asignarColumnaValor(4, p.getCurso());
		this.asignarColumnaValor(5, p.getFechainicio());
		this.asignarColumnaValor(6, p.getFechafin());
		this.asignarColumnaValor(7, p.getEstado());
		this.asignarColumnaValor(8, p.getInstructor());
		this.asignarColumnaValor(9, p.getSyllabus());
		this.asignarColumnaValor(10, p.getLocal());
		this.asignarColumnaValor(11, p.getAula());
		this.asignarColumnaValor(12, p.getCoordlatitud());
		this.asignarColumnaValor(13, p.getCoordaltitud());
		
		
		// Modificar registro
		super.modificar();
	}
}
class GrupoEstudioFechaContactoComparator implements Comparator { 

public int compare(Object o1, Object o2) { 
	GrupoEstudio p1 = (GrupoEstudio) o1; 
	GrupoEstudio p2 = (GrupoEstudio) o2; 
        return p1.getFechainicio(). 
                compareTo(p2.getFechainicio()); 

    } 
} 