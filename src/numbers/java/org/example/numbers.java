package org.example;
import java.util.Arrays;

//[9,10,11,12,13,14]
public class numbers {
    public static int maxTeamSize(int[] skills) {
        Arrays.sort(skills);
        System.out.println(Arrays.toString(skills));
        int maxTeam = 1;
        int currentTeamSize = 1;
        for (int i = 1; i < skills.length; i++) {
            if (skills[i] - skills[i - 1] == 0 || skills[i] - skills[i - 1] == 1) {
                currentTeamSize++;
            } else {
                maxTeam = Math.max(maxTeam, currentTeamSize);
                currentTeamSize = 1;
            }
        }
        maxTeam = Math.max(maxTeam,currentTeamSize);
        return maxTeam;
    }

    public static void main(String[] args) {
        int[] skills = {10, 12, 13, 9, 14};
        System.out.println(maxTeamSize(skills));
    }
}
