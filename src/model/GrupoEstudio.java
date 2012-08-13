package model;

import java.util.ArrayList;

public class GrupoEstudio {
	private String codigo;
	private String nombre;
	private String descripcion;
	private String academia;
	private String curso;
	private String fechainicio;
	private String fechafin;
	private String estado;
	private String instructor;
	private String syllabus;
	private String local;
	private String aula;
	private String coordlatitud;
	private String coordaltitud;
	
	public GrupoEstudio(){
		
	}
	public GrupoEstudio(String p_nombre, String p_descripcion, String p_academia,
			String p_curso, String p_fechainicio, String p_fechafin, String p_estado,
			String p_instructor,String p_syllabus,String p_local,String p_aula,
			String p_coordlatitud,String p_coordaltitud ) {
		this.nombre = p_nombre;
		this.descripcion = p_descripcion;
		this.academia = p_academia;
		this.curso = p_curso;
		this.fechainicio = p_fechainicio;
		this.fechafin = p_fechafin;
		this.estado = p_estado;
		this.instructor = p_instructor;
		this.syllabus = p_syllabus;
		this.local = p_local;
		this.aula = p_aula;
		this.coordlatitud = p_coordlatitud;
		this.coordaltitud = p_coordaltitud;
		this.codigo = Secuencia.get("GrupoEstudio");
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAcademia() {
		return academia;
	}
	public void setAcademia(String academia) {
		this.academia = academia;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}
	public String getFechafin() {
		return fechafin;
	}
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public String getCoordlatitud() {
		return coordlatitud;
	}
	public void setCoordlatitud(String coordlatitud) {
		this.coordlatitud = coordlatitud;
	}
	public String getCoordaltitud() {
		return coordaltitud;
	}
	public void setCoordaltitud(String coordaltitud) {
		this.coordaltitud = coordaltitud;
	}
	
	@Override
	public String toString() {
		String formato1 = "%1$-5s";
		String formato2 = "%1$-15s";
		String formato3 = "%1$-30s";

		return "| " + String.format(formato1, this.codigo)+
			   "| " + String.format(formato2, this.nombre)+
			   "| " + String.format(formato2, this.descripcion)+
			   "| " + String.format(formato2, this.academia)+
			   "| " + String.format(formato3, this.curso)+
			   "| " + String.format(formato2, this.fechainicio)+
			   "| " + String.format(formato2, this.fechafin)+
			   "| " + String.format(formato2, this.estado)+
			   "| " + String.format(formato2, this.instructor)+
			   "| " + String.format(formato2, this.syllabus)+
			   "| " + String.format(formato2, this.local)+
			   "| " + String.format(formato2, this.aula)+
			   "| " + String.format(formato2, this.coordlatitud)+
			   "| " + String.format(formato2, this.coordaltitud)+			   
			   "|";
	}

	// Recibe un arreglo con datos o nulos, debe coincidir con
	// los datos del objeto para retornar true o
	// los datos del arreglo deben ser todos nulos para retornar true
	public boolean coincide(ArrayList<String> prospectoFiltroVal) {
		boolean ret = true;
		int i = 0;
		// Recorrer el arreglo para comparar por indice
		for (String s : prospectoFiltroVal) {
			if (s != null && !s.isEmpty()) {
				// Si cualquiera de las comparaciones es falsa, no cumple
				switch(i) {
				case 0:
					ret = this.codigo.equals(s);
					break;
				case 1:
					ret = this.nombre.equals(s);
					break;
				case 2:
					ret = this.descripcion.equals(s);
					break;
				case 3:
					ret = this.academia.equals(s);
					break;
				case 4:
					ret = this.curso.equals(s);
					break;
				case 5:
					ret = this.fechainicio.equals(s);
					break;
				case 6:
					ret = this.fechafin.equals(s);
					break;
				case 7:
					ret = this.estado.equals(s);
					break;
				case 8:
					ret = this.instructor.equals(s);
					break;
				case 9:
					ret = this.syllabus.equals(s);
					break;
				case 10:
					ret = this.local.equals(s);
					break;
				case 11:
					ret = this.aula.equals(s);
					break;
				case 12:
					ret = this.coordlatitud.equals(s);					
					break;
				case 13:					
					ret = this.coordaltitud.equals(s);
					break;					
				default:
					break;
				}
			}
		}
		return ret;
	}

}
