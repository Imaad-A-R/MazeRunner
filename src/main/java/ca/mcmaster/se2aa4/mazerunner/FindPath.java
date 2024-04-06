package ca.mcmaster.se2aa4.mazerunner;

//interface that serves as a blueprint for algorithms that generate a valid path for a maze
public interface FindPath {
    String find(String[][] maze, int start, int end);

    default String factorize(String canonical){
        String factored = "";
        int total = 1;
        //look at the first element
        char current = canonical.charAt(0);

        //compare the last element with the for loop one, increasing a count and printing only when they don't match
        for (int i=1; i<canonical.length(); i++){
            if (canonical.charAt(i)==current){
                total++;

                //these if statements are purely for the case where we are on the last element
                if (i==canonical.length()-1){
                    factored = factored+" "+total+canonical.charAt(i);
                }
            }
            else if(canonical.charAt(i)!=current && total>=2){
                factored = factored+" "+total+current;
                total=1;
                if (i==canonical.length()-1){
                    factored = factored+" "+canonical.charAt(i);
                }
            }
            else{
                factored=factored+" "+current;
                if (i==canonical.length()-1){
                    factored = factored+" "+canonical.charAt(i);
                }
            }
            current = canonical.charAt(i);
        }
        return factored.substring(1);
    }
}
