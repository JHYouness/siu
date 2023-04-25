package UD07.src.EjercicioFallero;

import java.util.*;

public class Ciclo {

	// TODO EN LA LINEA 278 HE AÑADIDO EL BORRAR EL MODULO DE LA LISTA
	// "listaModulosIndividuales"

	private Scanner s = new Scanner(System.in);

	private int option;
	private int año;

	private char tipoCiclo;

	private String nombre;
	private String datos;

	private ArrayList<String> lista;
	private ArrayList<String> listaModulos;
	private ArrayList<String> listaModulosIndividuales;

	private boolean siEsta;

	public Ciclo(ArrayList<String> lista, ArrayList<String> listaModulos, ArrayList<String> listaModulosIndividuales,
			boolean finPrograma) {

		// LISTAS
		this.lista = lista;
		this.listaModulos = listaModulos;
		this.listaModulosIndividuales = listaModulosIndividuales;

		// NUMEROS ENTEROS
		option = 0;

		// CHAR
		tipoCiclo = ' ';

		// String
		nombre = "";
		datos = "";

		// BOOLEAN
		siEsta = false;

	}

	public void menu() {

		boolean fin = false;

		while (true) {
			System.out.println("------------------------");
			System.out.println("| 1-Alta               |");
			System.out.println("| 2-Añadir modulo      |");
			System.out.println("| 3-Quitar modulo      |");
			System.out.println("| 4-Consultar          |");
			System.out.println("| 5-Volver atras       |");
			System.out.println("------------------------");
			option = s.nextInt();
			s.nextLine();

			switch (option) {
			case 1:
				alta();
				break;
			case 2:
				añadirModulo();
				break;

			case 3:
				quitarModulo();
				break;
			case 4:
				consultar();
				break;
			case 5:
				fin = true;
				break;
			default:
				System.out.println("Option incorrecta");
				break;
			}

			if (fin == true) {
				break;
			}
		}
	}

	public void alta() {

		String tipo = "";

		while (true) {
			System.out.println("Introduzca el nombre del ciclo a dar de alta");
			nombre = s.nextLine();

			if (nombre.equalsIgnoreCase("salir")) {
				System.out.println("¡No puedes llamar al ciclo ''salir''!");
				continue;
			}
			if (lista.isEmpty() == false) {
				for (int i = 0; i < lista.size(); i++) {
					String[] partes = lista.get(i).split(":");
					if (nombre.equalsIgnoreCase(partes[0])) {
						siEsta = true;
					}
				}

				if (siEsta == true) {
					System.out.println("El ciclo " + nombre + " ya existe!");
					siEsta = false;
					continue;
				} else {
					break;
				}
			}

			break;
		}
		while (true) {
			System.out.println("Introduzca el tipo de ciclo ");
			System.out.println("\tM-Grado medio");
			System.out.println("\tS-Grado superior");
			System.out.println("\tB-Formacion basica");
			tipoCiclo = s.nextLine().charAt(0);

			if ((tipoCiclo != 'M') && (tipoCiclo != 'S') && (tipoCiclo != 'B')) {
				System.out.println("¡Ese tipo de ciclo no existe en España!");
				continue;
			} else {
				break;
			}
		}

		if (tipoCiclo == 'M') {
			tipo = "Grado medio";
		} else if (tipoCiclo == 'S') {
			tipo = "Grado Superior";
		} else {
			tipo = "Formaicon basica";
		}

		// AÑADO EL NOMBRE Y EL TIPO DE CICLO A LA LISTA "lista"
		datos = nombre + ":" + tipo;
		lista.add(datos);
		System.out.println("Ciclo añadido!");
		System.out.println();
	}

	public void añadirModulo() {

		String nombreModulo = "";
		boolean siEstaModulo = false;

		if (lista.isEmpty() == true) {
			System.out.println("No existe ningun ciclo!");
		} else {

			while (true) {
				System.out.println("¿En que ciclo quieres añadir los modulos? teclee salir para acabar");
				nombre = s.nextLine();
				siEsta = false;

				if (nombre.equalsIgnoreCase("salir")) {
					break;
				}

				for (int i = 0; i < lista.size(); i++) {
					String[] partes = lista.get(i).split(":");
					if (nombre.equalsIgnoreCase(partes[0])) {
						siEsta = true;

						while (true) {
							System.out.println("Introduzca el nombre del modulo a añadir");
							nombreModulo = s.nextLine();

							if (listaModulosIndividuales.isEmpty() == false) {
								for (int j = 0; j < listaModulosIndividuales.size(); j++) {
									String[] partesModulosIndividuales = listaModulosIndividuales.get(j).split(":");
									if ((nombreModulo.equalsIgnoreCase(partesModulosIndividuales[1]))
											&& (nombre.equalsIgnoreCase(partesModulosIndividuales[0]))) {
										siEstaModulo = true;
									}
								}

								if (siEstaModulo == true) {
									siEstaModulo = false;
									System.out
											.println("En el ciclo " + nombre + " ya existe el modulo " + nombreModulo);
									continue;
								} else {
									siEstaModulo = false;
									break;
								}
							}
							break;
						}

						System.err.println("Introduzca el anyo del modulo a añadir");
						año = s.nextInt();
						s.nextLine();

						// AÑADIR MODULOS Y AÑOS A LA LISTA "listaModulos"
						datos = nombre + ":" + nombreModulo + " y tiene " + año + " anyos";
						listaModulos.add(datos);

						// AÑADIR MODULOS SIN LOS AÑOS A LA LISTA "listaModulosIndividuales"
						datos = nombre + ":" + nombreModulo;
						listaModulosIndividuales.add(datos);
					}
				}

				if (siEsta == false) {
					System.out.println("El ciclo no existe");
					continue;
				}
			}
		}
	}

	public void quitarModulo() {

		String modulo = "";

		boolean moduloFinalizar = false;

		if (lista.isEmpty() == true) {
			System.out.println("No existe ningun ciclo!");
		} else {
			while (true) {
				System.out.println("Intrdoduzca el ciclo o salir para acabar");
				nombre = s.nextLine();

				if (nombre.equalsIgnoreCase("salir")) {
					break;
				}

				for (int i = 0; i < lista.size(); i++) {
					String[] partes = lista.get(i).split(":");
					if (partes[0].equalsIgnoreCase(nombre)) {
						siEsta = true;
					}
				}

				if (siEsta == false) {
					System.out.println("El ciclo no existe");
					continue;
				} else {
					siEsta = false;
				}

				for (int i = 0; i < listaModulosIndividuales.size(); i++) {
					String[] partes = listaModulosIndividuales.get(i).split(":");
					if (partes[0].equalsIgnoreCase(nombre)) {
						siEsta = true;
					}
				}

				if (siEsta == false) {
					System.out.println("El ciclo " + nombre + " no tiene modulos!");
					continue;
				} else {
					siEsta = false;
				}

				while (true) {
					System.out.println("Introduzca el modulo a quitar");
					modulo = s.nextLine();

					for (int i = 0; i < listaModulosIndividuales.size(); i++) {
						String[] partes = listaModulosIndividuales.get(i).split(":");
						if (partes[1].equalsIgnoreCase(modulo)) {
							siEsta = true;
							listaModulos.remove(i);
							listaModulosIndividuales.remove(i);
						}
					}

					if (siEsta == false) {
						System.out.println("El modulo no existe");
						continue;
					} else {
						siEsta = true;
						System.out.println("Modulo borrado!");
						break;
					}
				}
			}
		}

	}

	public void consultar() {

		int contador = 1;

		char tipos = ' ';

		if (lista.isEmpty() == true) {
			System.out.println("No existe ningun ciclo!");
		} else {
			while (true) {
				System.out.println("Quieres ver todos los cicos existentes o un ciclo en especifico? (t/u)");
				tipos = s.nextLine().charAt(0);

				contador = 1;

				if ((tipos != 't') && (tipos != 'u')) {
					System.out.println("option incorrecta!");
					continue;
				} else {
					break;
				}
			}

			if (tipos == 'u') {
				while (true) {
					System.out.println("Introduza el ciclo a consultar o salir para finalizar");
					nombre = s.nextLine();

					contador = 1;

					if (nombre.equalsIgnoreCase("salir")) {
						break;
					}

					for (int i = 0; i < lista.size(); i++) {
						String[] partes = lista.get(i).split(":");
						if (partes[0].equalsIgnoreCase(nombre)) {
							siEsta = true;
							System.out.println("\t- Ciclo: " + partes[0]);
							System.out.println("\t- Tipo: " + partes[1]);

							for (int j = 0; j < listaModulos.size(); j++) {
								String[] partesModulos = listaModulos.get(j).split(":");
								if (partesModulos[0].equalsIgnoreCase(partes[0])) {
									System.out.println("\t- Modulo " + (contador) + ": " + partesModulos[1]);
									contador++;
								}
							}
						}
					}

					if (siEsta == false) {
						System.out.println("El ciclo no existe!");
						continue;
					} else {
						siEsta = false;
					}
				}
			} else {
				for (int i = 0; i < lista.size(); i++) {
					String[] partes = lista.get(i).split(":");
					System.out.println("Ciclo " + (i + 1) + ":");
					System.out.println("\tCiclo: " + partes[0]);
					System.out.println("\tTipo: " + partes[1]);

					for (int j = 0; j < listaModulos.size(); j++) {
						String[] partesModulos = listaModulos.get(j).split(":");
						if (partesModulos[0].equalsIgnoreCase(partes[0])) {
							System.out.println("\tModulo " + (contador) + ": " + partesModulos[1]);
							contador++;
						}
					}
				}
			}
		}
	}

}
