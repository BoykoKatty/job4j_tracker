package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = evenElements.size();
        for (int i = 0; i < length; i++) {
            Character c = evenElements.pollFirst();
            stringBuilder.append(i % 2 == 0 ? c : "");
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = descendingElements.size();
        for (int i = 0; i < length; i++) {
            Character c = descendingElements.pollLast();
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}