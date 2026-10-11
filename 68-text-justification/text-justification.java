class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int j = i;
            int letters = 0;

            while (j < n && letters + words[j].length() + (j - i) <= maxWidth) {
                letters += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder(maxWidth);

            if (j == n || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        line.append(' ');
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(' ');
                }
            } else {
                int spaces = maxWidth - letters;
                int each = spaces / gaps;
                int extra = spaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int pad = each + (k - i < extra ? 1 : 0);
                        for (int s = 0; s < pad; s++) {
                            line.append(' ');
                        }
                    }
                }
            }

            lines.add(line.toString());
            i = j;
        }

        return lines;
    }
}