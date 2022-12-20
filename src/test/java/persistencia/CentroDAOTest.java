package persistencia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import negocio.entities.Centro;

public class CentroDAOTest {
	private CentroDAO centro = new CentroDAO(Centro.class);

	public Centro crearCentro() {
		Centro centroCreado = new Centro(8, "Facultad Ciencias Sociales", "Talavera de la Reina");
		return centroCreado;
	}

	@Test
	public void testCrearNuevoEstudiante() {
		List<Centro> listaCentroAntes = centro.listarCentros();

		Centro centroCreado = crearCentro();
		centro.crearNuevoCentro(centroCreado);

		List<Centro> listaCentroDespues = centro.listarCentros();

		assertFalse(listaCentroAntes.contains(centroCreado));
		assertTrue(listaCentroDespues.contains(centroCreado));
		assertTrue(listaCentroAntes.size() == (listaCentroDespues.size() - 1));

		centro.eliminarCentro(centroCreado);

	}
}
