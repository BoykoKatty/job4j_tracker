package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int number = 0;
        double mark = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                mark += subject.score();
                number++;
            }
        }
        return number > 0 ? mark / number : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        return scoreByPupil(pupils, true);
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        return scoreBySubject(pupils, true);
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = scoreByPupil(pupils, false);
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = scoreBySubject(pupils, false);
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    private static List<Label> scoreByPupil(List<Pupil> pupils, boolean averageScore) {
        List<Label> labels = new ArrayList<>();
        int number = 0;
        double mark = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                mark += subject.score();
                number++;
            }
            number = averageScore ? number : 1;
            labels.add(new Label(pupil.name(), number > 0 ? mark / number : 0));
            number = 0;
            mark = 0;
        }
        return labels;
    }

    private static List<Label> scoreBySubject(List<Pupil> pupils, boolean averageScore) {
        List<Label> labels = new ArrayList<>();
        Map<String, List<Integer>> subjectMap = new HashMap<>();
        double mark = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectMap.getOrDefault(subject.name(), new ArrayList<>()).add(subject.score());
            }
        }
        for (Map.Entry<String, List<Integer>> subjectScores : subjectMap.entrySet()) {
            for (Integer subjectScore : subjectScores.getValue()) {
                mark += subjectScore;
            }
            if (averageScore) {
                labels.add(new Label(subjectScores.getKey(), mark / subjectScores.getValue().size()));
            } else {
                labels.add(new Label(subjectScores.getKey(), mark));
            }
            mark = 0;
        }
        return labels;
    }
}