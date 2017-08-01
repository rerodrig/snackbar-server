package br.com.snackbar.server.util;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonGenericDataLoader<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonGenericDataLoader.class);

	private static final ObjectMapper mapper = new ObjectMapper();

	private final Class<T> type;

	private final String filePath;

	public JsonGenericDataLoader(final Class<T> type, final String filePath) {
		this.filePath = filePath;
		this.type = type;
	}

	public List<T> loadData() {

		List<T> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(new ClassPathResource(this.filePath).getFile().toPath())) {

			stream.forEach(t -> {
				try {
					list.add(this.createObject(t.getBytes()));
				} catch (Exception e) {
					LOGGER.error("Error loading data", e);
				}

			});

		} catch (Exception e) {
			LOGGER.error("Error reading file", e);
		}

		return list;
	}

	private T createObject(final byte[] bytes) throws Exception {
		return mapper.readValue(bytes, this.type);
	}
}
