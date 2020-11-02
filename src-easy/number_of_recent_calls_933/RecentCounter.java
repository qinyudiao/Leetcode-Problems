package number_of_recent_calls_933;

import java.util.LinkedList;
import java.util.Queue;

//    You have a RecentCounter class which counts the number of recent requests within a certain time frame.
//    
//    Implement the RecentCounter class:
//        - RecentCounter() Initializes the counter with zero recent requests.
//        - int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, 
//        and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). 
//        Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
//        It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

//    Constraints:
//        1 <= t <= 109
//        Each test case will call ping with strictly increasing values of t.
//        At most 104 calls will be made to ping.

class RecentCounter {
    Queue<Integer> validCalls;
    
    public RecentCounter() {
        validCalls = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        // add the latest call
        validCalls.add(t);
        
        // remove the old calls that is not valid anymore
        while(validCalls.peek() < t - 3000) {
            validCalls.remove();
        }
        
        return validCalls.size();
    }
}
