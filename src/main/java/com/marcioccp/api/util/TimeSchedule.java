package com.marcioccp.api.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeSchedule {

	Timer timer;

	public void iniciar() {
		timer = new Timer();
		// Executa tarefa a cada 24 horas a partir da primeira
		// timer.schedule(new tarefasDiarias(),
		// 0,
		// 1 * 1000 * 60 * 60 * 24);
		// Executa tarefa todo dia as 6 da manha

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 6);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		Date time = calendar.getTime();
		timer.schedule(new tarefasDiarias(), time);

		
	}
	
	class tarefasDiarias extends TimerTask {
		
		public void run() {
		
		            //Aqui ficam as tarefas que vão ser executadas...
		
		        }
		
		    }
		

}
