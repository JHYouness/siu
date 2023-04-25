package UD07.src.EjercicioFallero;

import java.util.*;

public class Alumnos {

	private Scanner s = new Scanner(System.in);

	private String uni;
	private String nombre;
	private String datos;

	private int edad;
	private int option;

	private ArrayList<String> lista;

	public Alumnos(ArrayList<String> lista) {
		// STRING
		uni = "";
		nombre = "";
		datos = "";

		// NUMERO ENTEROS
		edad = 0;
		option = 0;

		// ARRAYLIST
		this.lista = lista;
	}

	public void menu() {

		boolean siEsta = false;
		while (true) {
			System.out.println("1-Alta");
			System.out.println("2-Baja");
			System.out.println("3-Consulta");
			System.out.println("4-Modificar datos");
			System.out.println("5-Salir");
			option = s.nextInt();
			s.nextLine();

			switch (option) {
			case 1:
				alta();
				break;
			case 2:
				baja();
				break;
			case 3:
				consulta();
				break;
			case 4:
				modificar();
				break;
			case 5:
				siEsta = true;
				break;
			default:
				System.out.println("Option incorrecta");
				break;
			}

			if (siEsta == true) {
				break;
			}
		}

	}

	public void alta() {

		boolean siEsta = false;

		while (true) {
			System.out.println("Introduzca el nombre y apellido");
			nombre = s.nextLine();

			for (int i = 0; i < lista.size(); i++) {
				String[] partes = lista.get(i).split(":");
				if (partes[0].equalsIgnoreCase(nombre)) {
					siEsta = true;
				}
			}

			if (siEsta == true) {
				System.out.println("El alumno " + nombre + " ya existe!");
				siEsta = false;
				continue;
			} else {
				break;
			}
		}
		System.out.println("Introduzca la universidad");
		uni = s.nextLine();

		System.out.println("Introduzca la edad");
		edad = s.nextInt();

		datos = nombre + ":" + edad + " : " + uni + ":";
		lista.add(datos);

		for (int i = 0; i < lista.size(); i++) {
			String[] partes = lista.get(i).split(":");
			System.out.println("-Alumno " + (i + 1) + ":");
			System.out.println("\t-Nombre:" + partes[0]);
			System.out.println("\t-Edad:" + partes[1]);
			System.out.println("\t-Universidad:" + partes[2]);
		}

	}

	private void baja() {

		boolean siEsta = false;

		while (true) {
			System.out.println("Introduzca el nombre a dar de baja");
			nombre = s.nextLine();

			for (int i = 0; i < lista.size(); i++) {
				String[] partes = lista.get(i).split(":");
				if (nombre.equalsIgnoreCase(partes[0])) {
					siEsta = true;
					lista.remove(i);
				}
			}

			if (siEsta == true) {
				System.out.println(nombre + " dado de baja");
				break;
			} else {
				System.out.println("El alumno no existe");
				continue;
			}
		}

		for (int i = 0; i < lista.size(); i++) {
			String[] partes = lista.get(i).split(":");
			System.out.println("-Alumno " + (i + 1) + ":");
			System.out.println("\t-Nombre:" + partes[0]);
			System.out.println("\t-Edad:" + partes[1]);
			System.out.println("\t-Universidad:" + partes[2]);
		}
	}

	public void consulta() {

		boolean siEsta = false;

		while (true) {
			System.out.println("Introduzca el nombre del alumno a consultar o salir para acabar");
			nombre = s.nextLine();

			if (nombre.equalsIgnoreCase("salir")) {
				break;
			}

			for (int i = 0; i < lista.size(); i++) {
				String partes[] = lista.get(i).split(":");
				if (nombre.equalsIgnoreCase(partes[0])) {
					siEsta = true;
				}
			}

			if (siEsta == false) {
				System.out.println("El alumno " + nombre + " no existe");
				continue;
			} else {
				System.out.println("Esto es lo que tenemos del alumno " + nombre + ":");

				siEsta = false;

				for (int i = 0; i < lista.size(); i++) {
					String partes[] = lista.get(i).split(":");
					if (nombre.equalsIgnoreCase(partes[0])) {
						System.out.println("\t-Nombre:" + partes[0]);
						System.out.println("\t-Edad:" + partes[1]);
						System.out.println("\t-Universidad:" + partes[2]);
					}
				}
			}
		}
	}

	public void modificar() {

		boolean siEsta = false;

		String datos = "";
		String nombreNuevo = "";

		int edadNueva = 0;

		while (true) {
			System.out.println("Introduzca el nombre del alumno a modificar o salir para acabar");
			nombre = s.nextLine();

			if (nombre.equalsIgnoreCase("salir")) {
				break;
			}

			for (int i = 0; i < lista.size(); i++) {
				String[] partes = lista.get(i).split(":");
				if (nombre.equalsIgnoreCase(partes[0])) {
					siEsta = true;
					lista.remove(i);

					System.out.println("Que parametros quieres modificar?");
					System.out.println("1-Nombre\n2-Edad\n3-Universidad");
					option = s.nextInt();
					s.nextLine();

					switch (option) {
					case 1:
						System.out.println("Introduzca el nuevo nombre");
						nombreNuevo = s.nextLine();
						datos = nombreNuevo + ":" + partes[1] + ":" + partes[2] + ":";
						lista.add(datos);
						break;
					case 2:
						System.out.println("Introduzca la nueva edad");
						edadNueva = s.nextInt();
						s.nextLine();

						datos = partes[0] + ":" + edadNueva + ":" + partes[2] + ":";
						lista.add(datos);
						break;
					case 3:
						System.out.println("Introduca la nueva universidad");
						nombreNuevo = s.nextLine();
						datos = partes[0] + ":" + partes[1] + ":" + nombreNuevo + ":";
						lista.add(datos);
						break;
					}

					break;
				}
			}

			if (siEsta == false) {
				System.out.println("El alumno no existe");
				continue;
			} else {
				siEsta = false;
				System.out.println("Datos modificados:");
				for (int i = 0; i < lista.size(); i++) {
					String partes[] = lista.get(i).split(":");
					if (nombre.equalsIgnoreCase(partes[0]) || (nombreNuevo.equalsIgnoreCase(partes[0]))) {
						System.out.println("\t-Nombre:" + partes[0]);
						System.out.println("\t-Edad:" + partes[1]);
						System.out.println("\t-Universidad:" + partes[2]);
					}
				}
			}
		}
	}
}