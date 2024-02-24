
public class Main {
    public static void main(String[] args) {
        String token = args[0];

        boolean valid = API.postStart(token);
        if (!valid) {
            System.out.println("Invalid API token");
            return;
        }

        String scheduleJson = API.getSchedule(token);
        Schedule schedule = new Schedule(scheduleJson);
        
        // updateSchedule(token, schedule);

        boolean stopped = API.postStop(token);
        if (!stopped) {
            System.out.println("Error stopping");
            return;
        }

        System.out.println(schedule.toString());
    }

    private static void updateSchedule(String token, Schedule schedule) {
        String apptRequest = API.getAppointmentRequest(token);
        while (!apptRequest.equals("STOP")) {

            // TODO

            // Parse request
            String data = schedule.addAppt(apptRequest);

            // Add request to schedule
            boolean added = API.postSchedule(token, data);
            if (!added) {
                System.out.println("Error adding appointment to schedule");
                return;
            }

            apptRequest = API.getAppointmentRequest(token);
        }
    }
 }