
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,  String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean[] visited = new boolean[366];
        // Alice's arrival and departure
        int aArr = getDay(arriveAlice, days);
        int aLeave = getDay(leaveAlice, days);
        // Mark all days Alice is present
        for (int i = aArr; i <= aLeave; i++) {
            visited[i] = true;
        }

        // Bob's arrival and departure
        int bArr = getDay(arriveBob, days);
        int bLeave = getDay(leaveBob, days);

        int count = 0;

        // Count overlapping days
        for (int i = bArr; i <= bLeave; i++) {
            if (visited[i]) {
                count++;
            }
        }

        return count;
    }

    private int getDay(String date, int[] days) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int total = day;

        for (int i = 0; i < month - 1; i++) {
            total += days[i];
        }

        return total;
    }
}
