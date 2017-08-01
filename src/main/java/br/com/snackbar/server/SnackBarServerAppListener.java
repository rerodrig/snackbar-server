package br.com.snackbar.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.snackbar.server.util.CacheDataLoader;

@Component
public class SnackBarServerAppListener implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private CacheDataLoader dataLoader;

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		this.dataLoader.loadSampleData();
	}

}
