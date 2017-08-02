package br.com.snackbar.server.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonGenericDataLoader<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonGenericDataLoader.class);

	private static final ObjectMapper mapper = new ObjectMapper();

	private final Class<T> type;

	private final InputStream inputStream;

	public JsonGenericDataLoader(final Class<T> type, final InputStream inputStream) {
		this.inputStream = inputStream;
		this.type = type;
	}

	public List<T> loadData() {

		List<T> list = new ArrayList<>();

		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(this.inputStream))) {
			buffer.lines().forEach(t -> {
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
