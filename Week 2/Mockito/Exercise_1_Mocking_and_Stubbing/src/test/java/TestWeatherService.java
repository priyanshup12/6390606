import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.WeatherApi;
import org.example.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestWeatherService {

    @Test
    public void testExternalApi() {
        WeatherApi mockApi = Mockito.mock(WeatherApi.class);
        when(mockApi.getCurrentTemperature()).thenReturn("30°C");
        WeatherService service = new WeatherService(mockApi);
        String result = service.fetchWeather();
        assertEquals("30°C", result);
    }
}

