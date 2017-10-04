Input
You need to take input of 3 parameters: time1, time2 and appointment description for all the appointments of day. The time1 represents the starting time of an appointment and the ending time is represented by time2. All times are specified in the form of hh:mm. The ending time of an appointment will always be after the starting time. The value of each attribute is separated by a single space. The appointment description is specified in the single quotes.
The value in both of the times must be greater than or equal to 9:00 and less than or equal to 17:00. Therefore, you need to take the value into consideration i.e., nap cannot start before 9:00 and cannot last after 17:00.
Output
For each appointment, you need to do following. Assume start time of nap and maximum nap time are 00:00.
Check if the difference between ending and starting time is greater than maximum nap time, then update the values of start time of nap with the value of starting time of current appointment and maximum nap time with the difference of time calculate for current appointment.
Add this difference of time to the total free time of the day.
Once all the appointments are processed, you need to print the following:
Schedule of the day: You can take a longest nap at hh:mm which will last for [H hours and] M minutes.
The total free time available in the day is hh:mm where hh:mm is the time when the nap can start.
To display the length of the nap, follow these rules:
If the total time X is less than 60 minutes, just print “X minutes.” If the total duration X is at least 60 minutes, print “H hours and M minutes,” where H = X ÷ 60 (integer division, of course) and M = X mod 60.
You don’t have to worry about correct pluralization; i.e., you must print “1 minutes” or “1 hours” if that is the case.
The duration of the nap is calculated by the difference between the ending time and the beginning time. That is, if an appointment ends at 14:00 and the next one starts at 14:47, then you have 14:47 – 14:00 = 47 minutes of possible napping.
If there is more than one longest nap with the same duration, print the earliest one. You can assume the physician won’t be busy all day, so there is always time for at least one possible nap.
You can make the input simpler by asking user to specify one long string which contains the details of all the appointments of a single day using three parameters repeated in the format as “time1 time2 ‘appointment description’ time1 time2 ‘appointment description’ …” and then applying string processing to separate details. You can also use an alternate approach by taking input of three parameters separately. The examples of both methods are shown below:
