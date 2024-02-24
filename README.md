# dr-appointment-scheduler

First, compile with javac Main.java
Second, run with java Main {token}, replacing {token} with your Scheduling API token


# Next steps:

- Update Appointment DateTime so I can easily find available dates and times for new apppointments
- Work on and debug AppointmentRequest API call
- Use GSON and JSONObject classes to parse response json data instead
- Add functionality to only add new appointments if all conditions pass


# Issues:

I tried to get GSON and JSONObject classes to work to easily parse the response data, but ran into several errors. I wanted to get some more functionality for this project done, so I decided to parse the responses manually in order to do so, since GSON and JSONObject were giving me a hard time.


# Project Requirements:

This project is a simple doctor appointment scheduler. Your program should read a series of appointment requests from a queue and then schedule these appointments for the practice. When you run your program, it should retrieve the current appointment list, then retrieve and schedule a new appointment for each appointment request in the queue. Your program will interact with the practice's schedule using a simple web API created for this project. You can find swagger docs for the API here: https://scheduling.interviews.brevium.com/swagger/index.html 

This project can be completed using the programming language of your choice, but scripting languages (Bash, PowerShell, JavaScript, etc.) are not allowed.

Constraints
- You may only request the initial state of the schedule once per run of your program.
- Scheduling constraints
    - Appointments may only be scheduled on the hour.
    - Appointments can be scheduled as early as 8 am UTC and as late as 4 pm UTC.
    - Appointments may only be scheduled on weekdays during the months of November and December 2021.
    - Appointments can be scheduled on holidays.
    - For a given doctor, you may only have one appointment scheduled per hour (though different doctors may have appointments at the same time).
    - For a given patient, each appointment must be separated by at least one week. For example, if Bob Smith has an appointment on 11/17 you may schedule another appointment on or before 11/10 or on or after 11/24.
    - Appointments for new patients may only be scheduled for 3 pm and 4 pm.

We have set up the initial schedule and appointment requests in a way that prevents you from getting into a state where an appointment is impossible to schedule. The initial schedule is sparse enough that the first appointments that you schedule cannot completely block a later appointment from being scheduled. That should make the problem significantly easier.

The API requires an authentication token with each request.

