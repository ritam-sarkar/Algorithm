package com.gs.hard;

/*
 * == Instructions ==
 *
 * Debug why the included test cases aren't succeeding and account for them in the code
 *
 * A description of the expected behaviour is given below
 */

/**
 * Given two words returns the shortest distance between their two midpoints in number of characters
 * Words can appear multiple times in any order and should be case insensitive.
 *
 * E.g. for the document="This is a sample document we just made up"
 *   shortestDistance( document, "we", "just" ) == 4
 *   shortestDistance( document, "is", "a" ) == 2.5
 *   shortestDistance( document, "is", "not" ) == -1
 */

public class ShortDistanceBetweenWords {
    public static void main(String[] args) {
        String document =  """
      In publishing and graphic design, lorem ipsum is a
      filler text commonly used to demonstrate the graphic elements of a
      document or visual presentation. Replacing meaningful content that
      could be distracting with placeholder text may allow viewers to focus
      on graphic aspects such as font, typography, and page layout. It also
      reduces the need for the designer to come up with meaningful text, as
      they can instead use hastily generated lorem ipsum text. The lorem
      ipsum text is typically a scrambled section of De finibus bonorum et
      malorum, a 1st-century BC Latin text by Cicero, with words altered,
      added, and removed to make it nonsensical, improper Latin. A variation
      of the ordinary lorem ipsum text has been used in typesetting since
      the 1960s or earlier, when it was popularized by advertisements for
      Letraset transfer sheets. It was introduced to the Information Age in
      the mid-1980s by Aldus Corporation, which employed it in graphics and
      word processing templates for its desktop publishing program,
      PageMaker, for the Apple Macintosh. A common form of lorem ipsum
      reads: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
      eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
      minim veniam, quis nostrud exercitation ullamco laboris nisi ut
      aliquip ex ea commodo consequat. Duis aute irure dolor in
      reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
      pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
      culpa qui officia deserunt mollit anim id est laborum.""".replace('\n',' ');

        System.out.println(shortDistance(document, "and","graphic"));
        System.out.println(shortDistance(document, "removed", "lorem"));
        System.out.println(shortDistance(document, "It", "transfer"));

    }

    private static double shortDistance(String document, String word1, String word2) {

        document = document.toLowerCase();
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        int sDist = Integer.MAX_VALUE;
//		String words[] = document.split("\\s+");
        String words[] = document.split("[[ ]*|[,]*|[\\.]*]");

        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        int dist = getDist(word1, word2, words, i, j);
                        sDist = Math.min(sDist, dist);
                    }
                }
            }
        }
        return sDist;

    }

    private static int getDist(String word1, String word2, String[] words, int i, int j) {
        int start = Math.min(i, j);
        int end = Math.max(i, j);
        int dist = end - start;
        dist += (word1.length() + word2.length()) / 2;
        for (int k = start + 1; k < end; k++) {
            dist += words[k].length();
        }
        return dist;
    }

}
