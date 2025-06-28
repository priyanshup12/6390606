import static org.mockito.Mockito.*;

import org.example.WeatherApi;
import org.example.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestWeatherService {

    @Test
    public void testVerifyInteraction() {

        WeatherApi mockApi = Mockito.mock(WeatherApi.class);

        WeatherService service = new WeatherService(mockApi);

        service.fetchWeather("Mumbai");

        verify(mockApi).getTemperature("Mumbai");
    }
}

