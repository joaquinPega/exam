package muestradehilos;

public class Handler implements Runnable {
	private boolean running;
	private int laps = 0;
	private String nombre;

	@Override
	public void run() {
		while (running) {

			System.out.println(this.nombre + " estatica c " + mainprueba.c++);
			laps++;
			if (laps == 3) {
				running = false;
			}

		}

	}

	public Handler(boolean running, String nombre) {
		this.running = running;
		this.nombre = nombre;
	}
}
