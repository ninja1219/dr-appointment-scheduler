import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    public static boolean postStart(String token) {
        HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://scheduling.interviews.brevium.com/api/Scheduling/Start?token=" + token))
                .header("accept", "*/*")
				.method("POST", HttpRequest.BodyPublishers.noBody())
				.build();
        
        HttpResponse<String> response = null;
        try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        return (response.statusCode() == 200);
    }

    public static String getSchedule(String token) {
        HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://scheduling.interviews.brevium.com/api/Scheduling/Schedule?token=" + token))
                .header("accept", "*/*")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
        
        HttpResponse<String> response = null;
        try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        return response.body();
    }

    public static String getAppointmentRequest(String token) {
        HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://scheduling.interviews.brevium.com/api/Scheduling/ApointmentRequest?token=" + token))
                .header("accept", "*/*")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
        
        HttpResponse<String> response = null;
        try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        if (response.statusCode() == 204) {
			return "STOP";
		}
		else {
			return response.body();
		}
    }

	public static boolean postSchedule(String token, String body) {
        HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://scheduling.interviews.brevium.com/api/Scheduling/Schedule?token=" + token))
                .header("accept", "*/*")
				.method("POST", HttpRequest.BodyPublishers.ofString(body))
				.build();
        
        HttpResponse<String> response = null;
        try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        return (response.statusCode() == 200);
    }

	public static boolean postStop(String token) {
        HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://scheduling.interviews.brevium.com/api/Scheduling/Stop?token=" + token))
                .header("accept", "*/*")
				.method("POST", HttpRequest.BodyPublishers.noBody())
				.build();
        
        HttpResponse<String> response = null;
        try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        return (response.statusCode() == 200);
    }
}
