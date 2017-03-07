package io.iqube.kctgrad;

/**
 * Created by sanjaypradeep on 23-09-2016.
 */
public class ParticipantsContent {
    String ParticipantName,ProjectName,CollegeName;

    public String getCollegeName() {
        return CollegeName;
    }

    public String getParticipantName() {
        return ParticipantName;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public ParticipantsContent(String collegeName, String participantName, String projectName) {

        CollegeName = collegeName;
        ParticipantName = participantName;
        ProjectName = projectName;
    }
}
