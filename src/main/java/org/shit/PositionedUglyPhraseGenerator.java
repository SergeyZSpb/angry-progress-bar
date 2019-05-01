package org.shit;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class PositionedUglyPhraseGenerator {

    private final ArrayList<String> phrases;

    private final Random random;

    public PositionedUglyPhraseGenerator() {
        phrases = Lists.newArrayList("ZHOPA", "GOVNO", "SUKA", "PADLA");
        random = new Random();
    }

    public PositionedUglyPhrase nextPhrase(int xPosLimit) {
        return new PositionedUglyPhrase(
                phrases.get(random.nextInt(phrases.size())),
                random.nextInt(xPosLimit));
    }

    public class PositionedUglyPhrase {
        private final String phrase;
        private final int x;

        public PositionedUglyPhrase(String phrase, int x) {
            this.phrase = phrase;
            this.x = x;
        }

        public String getPhrase() {
            return phrase;
        }

        public int getX() {
            return x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PositionedUglyPhrase that = (PositionedUglyPhrase) o;
            return x == that.x &&
                    Objects.equals(phrase, that.phrase);
        }

        @Override
        public int hashCode() {
            return Objects.hash(phrase, x);
        }
    }

}
