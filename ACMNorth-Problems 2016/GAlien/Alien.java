import java.util.*;


public class Alien {
    Scanner sc;
    ArrayList<String[]> inputs;
    Set<List<String>> pairs;
    Set<String> chars;
    ArrayList<String> orders;
    Alien()
    {
        sc = new Scanner(System.in);
    }

    void runOnce(Scanner sc)
    {
        String s;
        int longest = 0;
        int inputNum = 0;

        inputs = new ArrayList<String[]>();
        pairs = new HashSet<List<String>>();
        chars = new HashSet<String>();
        orders = new ArrayList<String>();
        while(!(s = sc.nextLine()).equals("#")) {
            if(s.length() > longest) longest = s.length();
            inputs.add(s.split("(?!^)"));
            inputNum++;
        }
        inputNum--;
        for(int i = 0; i != longest; i++) {
            for(int j = 0; j != inputNum; j++) {
                if(inputs.get(j).length - 1 < i) continue;
                if(inputs.get(j + 1).length - 1 < i) continue;
                if(inputs.get(j)[i].equals(inputs.get(j + 1)[i])) continue;
                if(i > 0) {
                    boolean flag = false;
                    for(int k = 0; k != i; k++) {
                        if(!inputs.get(j)[k].equals(inputs.get(j+1)[k])) {
                            flag = true;
                            break;
                        }
                    }
                    if(flag) continue;
                }
                String[] pair = new String[2];
                pair[0] = inputs.get(j)[i];
                pair[1] = inputs.get(j + 1)[i];
                chars.add(pair[0]);
                chars.add(pair[1]);
                pairs.add(Arrays.asList(pair[0], pair[1]));
            }
        }
        Iterator iter = pairs.iterator();
        Iterator iter2 = pairs.iterator();
        String[] pair;
        //while(iter.hasNext()) {
        //    pair = (String[])iter.next();
        //    System.out.printf("%s -> %s\n", pair[0], pair[1]);
        //}
        //System.out.println();
        String ch;
        boolean flag;
        Collection<List<String>> removeCandidates;
        while(orders.size() != chars.size()) {
            iter = chars.iterator();
            if(pairs.size() == 1) {
                iter2 = pairs.iterator();
                List<String> ls = (List<String>)iter2.next();
                pair = (String[])ls.toArray();
                if(orders.indexOf(pair[0]) == -1) orders.add(pair[0]);
                if(orders.indexOf(pair[1]) == -1) orders.add(pair[1]);
                continue;
            }
            while(iter.hasNext() && pairs.size() > 1) {
                ch = (String)iter.next();
                iter2 = pairs.iterator();
                flag = true;
                while(iter2.hasNext()) {
                    List<String> ls = (List<String>)iter2.next();
                    pair = (String[])ls.toArray();
                    if(pair[1].equals(ch)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    if(!orders.contains(ch)) orders.add(ch);
                    iter2 = pairs.iterator();
                    removeCandidates = new LinkedList<List<String>>();
                    while(iter2.hasNext()) {
                        List<String> ls = (List<String>)iter2.next();
                        pair = (String[])ls.toArray();
                        if(pair[0].equals(ch)) {
                            removeCandidates.add(ls);
                            break;
                        }

                    }
                    pairs.removeAll(removeCandidates);
                }
            }
        }
        for (String st: orders) {
            System.out.print(st);
        }
        System.out.println();
    }

    void run()
    {
        int testCaseNum = Integer.parseInt(sc.nextLine());
        while(testCaseNum-- > 0) {
            runOnce(sc);
        }
    }


    public static void main(String[] args) {
        Alien al = new Alien();
        al.run();
    }
}
