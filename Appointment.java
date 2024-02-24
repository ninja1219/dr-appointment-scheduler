

public class Appointment {
    public int doctorId;
    public int personId;
    public String dateTime;
    public boolean newPatient;

    public Appointment(int doctorId, int personId, String dateTime, boolean newPatient) {
        this.doctorId = doctorId;
        this.personId = personId;
        this.dateTime = dateTime;
        this.newPatient = newPatient;
    }
}
