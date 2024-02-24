import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<Appointment> appts;

    public Schedule(String schedule) {
        this.appts = new ArrayList<>();
        createSchedule(schedule);
    }

    private void createSchedule(String schedule) {
        this.appts = parseSchedule(schedule);
    }

    private List<Appointment> parseSchedule(String schedule) {
        List<Appointment> appts = new ArrayList<>();

        int startI;
        for (int i = 0; i < schedule.length(); i++) {
            startI = i;
            if (schedule.charAt(i) == '{') {
                while (schedule.charAt(i) != '}') {
                    i++;
                }
                appts.add(parseApptData(schedule.substring(startI, i+1)));
            }
        }

        return appts;
    }

    private Appointment parseApptData(String data) {
        int doctorId = 0;
        int personId = 0;
        String dateTime = null;
        boolean newPatient = false;
        
        // Find doctorId
        int i = 12;
        int startI = i;
        while (data.charAt(i) != ',') {
            i++;
        }
        doctorId = Integer.parseInt(data.substring(startI, i));

        // Find personId
        startI = i + 12;
        i = startI;
        while (data.charAt(i) != ',') {
            i++;
        }
        personId = Integer.parseInt(data.substring(startI, i));

        // Find dateTime
        startI = i + 20;
        i = startI;
        while (data.charAt(i) != ',') {
            i++;
        }
        dateTime = data.substring(startI, i-1);
        // new LocalDateTime()
        // dateTime = new LocalDateTime(new LocalDate(Integer.parseInt(data.substring(startI+1, startI+5)), 
        //                                            Integer.parseInt(data.substring(startI+6, startI+8)),
        //                                            Integer.parseInt(data.substring(startI+9, startI+11))),
        //                             new LocalTime(Integer.parseInt(data.substring(startI+12, startI+14)),
        //                                           0, 0, 0));

        // Find newPatient
        startI = i + 27;
        i = startI;
        if (data.charAt(startI) == 'f') {
            newPatient = false;
        }
        else {
            newPatient = true;
        }

        return new Appointment(doctorId, personId, dateTime, newPatient);
    }

    public String addAppt(String data) {

        // TODO

        Appointment appt = parseApptRequestData(data);
        this.appts.add(appt);

        String apptStr = "{" +
            "\"doctorId\":" + appt.doctorId + "," +
            "\"personId\":" + appt.personId + "," +
            "\"appointmentTime\":" + appt.dateTime + "," + 
            "\"isNewPatientApppointment\":" + String.valueOf(appt.newPatient) + 
        "}";

        return apptStr;
    }

    private Appointment parseApptRequestData(String data) {

        // TODO
        
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Appointment appt : this.appts) {
            sb.append("DoctorId: " + appt.doctorId + "\n");
            sb.append("PersonId: " + appt.personId + "\n");
            sb.append("DateTime: " + appt.dateTime + "\n");
            sb.append("NewPatient: " + appt.newPatient + "\n");
            sb.append("\n");
        }

        return sb.toString();
    }
}
